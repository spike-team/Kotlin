package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MealPresenter implements MealContract.Presenter {

    private MealContract.View mView;
    private MealRepository mRepository;

    MealPresenter(Context context) {
        mRepository = new MealRepositoryImpl(context);
    }

    @Override
    public void init(MealContract.View view) {
        mView = view;
        mView.initView();
        findMeals();
    }

    @SuppressLint("CheckResult")
    @Override
    public void findMeals() {
        if (mRepository.isExist(getToday())) {
            mView.setItem(mRepository.getMeals(getToday()).getList());
        } else {
            mRepository.findMeals(getToday())
                    .subscribe(
                            response -> {
                                switch(response.code()) {
                                    case 200:
                                        assert response.body() != null;
                                        mRepository.cache(response.body());
                                        mView.setItem(mRepository.getMeals(getToday()).getList());
                                        break;
                                    case 400:
                                        mView.showToastForStrangeData();
                                        break;
                                    case 404:
                                        mView.showToastForNotFound();
                                        break;
                                    default:
                                        mView.showToastForError();
                                }
                            }
                    );
        }
    }

    private String getToday() {
        return new SimpleDateFormat("yyyy-MM", Locale.KOREA).format(new Date()) + "-01";
    }
}
