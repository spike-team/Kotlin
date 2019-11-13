package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
        mView.setItem(findMeals());
    }

    @SuppressLint("CheckResult")
    @Override
    public List<MealData> findMeals() {
        List<MealData> result = new ArrayList<>();

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());

        mRepository.findMeal(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            switch (response.code()) {
                                case 200:
                                    assert response.body() != null;
                                    result.addAll(response.body().getResult());
                                    break;
                                case 400:
                                    mView.showToastForStrangeData();
                                    break;
                                case 404:
                                    mView.showToastForNotFound();
                                    break;
                            }
                        },
                        error -> {
                            mView.showToastForError();
                            Log.d("TT", Objects.requireNonNull(error.getMessage()));
                        }
                );

        return result;
    }
}
