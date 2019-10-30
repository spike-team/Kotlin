package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;

public class TimeFragment extends Fragment {

    public TimeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String[] subjects = {
                "자바\n신요",
                "자바\n신요",
                "자바\n신요",
                "논술\n강래",
                "네트\n이경",
                "네트\n이경",
                "영어\n임채",
                "자바\n신요",
                "자바\n신요",
                "자바\n신요",
                "논술\n강래",
                "네트\n이경",
                "네트\n이경",
                "영어\n임채",
                "자바\n신요",
                "자바\n신요",
                "자바\n신요",
                "논술\n강래",
                "네트\n이경",
                "네트\n이경",
                "영어\n임채",
                "자바\n신요",
                "자바\n신요",
                "자바\n신요",
                "논술\n강래",
                "네트\n이경",
                "네트\n이경",
                "영어\n임채",
                "자바\n신요",
                "자바\n신요",
                "자바\n신요",
                "논술\n강래",
                "네트\n이경",
                "네트\n이경",
                "영어\n임채"
        };

        TextView[] subjectViews = {
                view.findViewById(R.id.tv_subject_11),
                view.findViewById(R.id.tv_subject_12),
                view.findViewById(R.id.tv_subject_13),
                view.findViewById(R.id.tv_subject_14),
                view.findViewById(R.id.tv_subject_15),
                view.findViewById(R.id.tv_subject_16),
                view.findViewById(R.id.tv_subject_17),
                view.findViewById(R.id.tv_subject_21),
                view.findViewById(R.id.tv_subject_22),
                view.findViewById(R.id.tv_subject_23),
                view.findViewById(R.id.tv_subject_24),
                view.findViewById(R.id.tv_subject_25),
                view.findViewById(R.id.tv_subject_26),
                view.findViewById(R.id.tv_subject_27),
                view.findViewById(R.id.tv_subject_31),
                view.findViewById(R.id.tv_subject_32),
                view.findViewById(R.id.tv_subject_33),
                view.findViewById(R.id.tv_subject_34),
                view.findViewById(R.id.tv_subject_35),
                view.findViewById(R.id.tv_subject_36),
                view.findViewById(R.id.tv_subject_37),
                view.findViewById(R.id.tv_subject_41),
                view.findViewById(R.id.tv_subject_42),
                view.findViewById(R.id.tv_subject_43),
                view.findViewById(R.id.tv_subject_44),
                view.findViewById(R.id.tv_subject_45),
                view.findViewById(R.id.tv_subject_46),
                view.findViewById(R.id.tv_subject_47),
                view.findViewById(R.id.tv_subject_51),
                view.findViewById(R.id.tv_subject_52),
                view.findViewById(R.id.tv_subject_53),
                view.findViewById(R.id.tv_subject_54),
                view.findViewById(R.id.tv_subject_55),
                view.findViewById(R.id.tv_subject_56),
                view.findViewById(R.id.tv_subject_57),
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++)
                subjectViews[i * 7 + j].setText(subjects[i * 7 + j]);
        }
    }
}
