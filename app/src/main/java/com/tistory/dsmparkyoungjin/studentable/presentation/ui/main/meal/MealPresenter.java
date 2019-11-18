package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.MealRepositoryImpl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MealPresenter implements MealContract.Presenter {

    private MealContract.View mView;
    private MealRepository mRepository;

    private String YEAR = new SimpleDateFormat("yyyy년", Locale.KOREA).format(new Date());
    private String MONTH = new SimpleDateFormat("MM월", Locale.KOREA).format(new Date());

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
        mRepository.findMeal(getToday())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            switch (response.code()) {
                                case 200:
                                    assert response.body() != null;
                                    mView.setItem(getDates(response.body().getResult()));
                                    break;
                                case 400:
                                    mView.showToastForStrangeData();
                                    break;
                                case 404:
                                    mView.showToastForNotFound();
                                    break;
                            }
                        },
                        error -> mView.showToastForError()
                );
    }

    private String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());
    }

    private static String getDay(String date) throws ParseException {

        @SuppressLint("SimpleDateFormat")
        Date cDate = new SimpleDateFormat("yyyy년 MM월 dd일").parse(date);

        Calendar calendar = Calendar.getInstance();
        assert cDate != null;
        calendar.setTime(cDate);

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1: return "일요일";
            case 2: return "월요일";
            case 3: return "화요일";
            case 4: return "수요일";
            case 5: return "목요일";
            case 6: return "금요일";
            case 7: return "토요일";
        }
        return "1";
    }

    private String getDate(int index) {
        DecimalFormat decimalFormat = new DecimalFormat(" ##일");
        return MONTH + decimalFormat.format(index + 1);
    }

    private List<MealData> getDates(List<MealData> meals) {
        for (int i = 0; i < meals.size(); i++) {
            String date = getDate(i);
            meals.get(i).setDate(date);
            try {
                meals.get(i).setDay(getDay(YEAR + " " + date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return meals;
    }
}
