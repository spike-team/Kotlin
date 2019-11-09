package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

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

//        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());
//
//        mRepository.findMeal(date)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        meal -> {
//                            meal.setDate(date);
//                            result.add(meal);
//                        },
//                        error -> Log.d("MealPresenter", "findMeals: ")
//                );

        return result;
    }
}
