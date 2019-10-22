package com.tistory.dsmparkyoungjin.studentable.ui.setting.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SearchSchFragment extends Fragment {

    public SearchSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_sch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.btn_search).setOnClickListener(v -> {
            MaterialEditText metSearchSchool = view.findViewById(R.id.met_searchSchool);
            String school = Objects.requireNonNull(metSearchSchool.getText()).toString();
            if (school.length() >= 3) {
                ((SettingActivity) Objects.requireNonNull(getActivity())).selectFragment(school);
            } else {
                Toast.makeText(getContext(), "3글자 이상 입력해주세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}