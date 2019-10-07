package com.tistory.dsmparkyoungjin.studentable.ui.setting.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SearchSchFragment extends Fragment {

    public SearchSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_sch, container, false);

        rootView.findViewById(R.id.btn_search).setOnClickListener(v -> {
            ((SettingActivity) Objects.requireNonNull(getActivity())).searchFragment();
        });

        return rootView;
    }
}