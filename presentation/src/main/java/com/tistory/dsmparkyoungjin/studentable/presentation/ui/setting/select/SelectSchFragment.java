package com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.adapter.SchoolAdapter;
import com.tistory.dsmparkyoungjin.studentable.presentation.entity.School;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

import java.util.ArrayList;
import java.util.Objects;

public class SelectSchFragment extends Fragment {

    public SelectSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_sch, container, false);

        ArrayList<School> dummy = new ArrayList<>();
        dummy.add(new School("대덕소프트웨어마이스터고등학교"));

        RecyclerView rvSchool = rootView.findViewById(R.id.rv_school);
        rvSchool.setAdapter(new SchoolAdapter(dummy));

        rootView.findViewById(R.id.btn_next).setOnClickListener(
                v -> ((SettingActivity) Objects.requireNonNull(getActivity())).selectSchool()
        );

        return rootView;
    }
}