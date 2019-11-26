package com.tistory.dsmparkyoungjin.studentable.data;

import java.util.List;

import io.realm.RealmList;

public class MealMapper {

    public static MealResultRealm toMealResultRealm(MealResultData data) {
        MealResultRealm result = new MealResultRealm();

        result.setCode(data.getCode());
        result.setDate(data.getDate());
        result.setList(toMealRealmList(data.getResult()));

        return result;
    }

    private static RealmList<MealRealm> toMealRealmList(List<MealData> data) {
        RealmList<MealRealm> result = new RealmList<>();
        for (MealData meal : data) {
            result.add(new MealRealm(
                    meal.getDay(),
                    meal.getDate(),
                    toRealmList(meal.getBreakfast()),
                    toRealmList(meal.getLunch()),
                    toRealmList(meal.getDinner())
            ));
        }
        return result;
    }

    private static RealmList<String> toRealmList(List<String> list) {
        RealmList<String> result = new RealmList<>();
        result.addAll(list);
        return result;
    }
}
