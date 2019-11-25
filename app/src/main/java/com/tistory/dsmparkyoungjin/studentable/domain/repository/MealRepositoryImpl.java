package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultRealm;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MealDao;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MealDaoImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.remote.MealService;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRepositoryImpl implements MealRepository {

    private SetPrefHelper mPrefHelper;
    private MealService mService;
    private MealDao mDao;

    private String YEAR = new SimpleDateFormat("yyyy년", Locale.KOREA).format(new Date());
    private String MONTH = new SimpleDateFormat("MM월", Locale.KOREA).format(new Date());

    public MealRepositoryImpl(Context context) {
        mPrefHelper = new SetPrefHelperImpl(context);
        mService = new Retrofit.Builder()
                .baseUrl("http://studentable.jaehoon.kim/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MealService.class);
        mDao = new MealDaoImpl();
    }

    @Override
    public boolean isExist(String date) {
        return mDao.getCache(date, mPrefHelper.getSchoolCode()) != null;
    }

    @Override
    public MealResultRealm getMeals(String date) {
        return mDao.getCache(date, mPrefHelper.getSchoolCode());
    }

    @Override
    public Flowable<Response<MealResultData>> findMeals(String date) {
        return mService.findMeal(date, mPrefHelper.getSchoolCode())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void cache(MealResultData data) {
        mDao.setCache(data);
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
        return "";
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