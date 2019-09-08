package com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.set;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SetClsFragment extends Fragment {

    public SetClsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_cls, container, false);

        rootView.findViewById(R.id.btn_save).setOnClickListener(
                v -> ((SettingActivity) Objects.requireNonNull(getActivity())).setClass()
        );

        return rootView;
    }
}