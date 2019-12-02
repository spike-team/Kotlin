package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;

import java.util.Objects;

import io.realm.RealmList;

public class TimeFragment extends Fragment implements TimeContract.View {

    private View mCurrentView;
    private TimeContract.Presenter mPresenter;

    public TimeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_time, container, false);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new TimePresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.findTimes();
    }

    @Override
    public void initView() {
    }

    @Override
    public void visibleProgress() {
        mCurrentView.findViewById(R.id.pb_time).setVisibility(View.VISIBLE);
    }

    @Override
    public void invisibleProgress() {
        mCurrentView.findViewById(R.id.pb_time).setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setItem(RealmList<String> items) {
        TextView[] subjectViews = {
                mCurrentView.findViewById(R.id.tv_subject_11),
                mCurrentView.findViewById(R.id.tv_subject_12),
                mCurrentView.findViewById(R.id.tv_subject_13),
                mCurrentView.findViewById(R.id.tv_subject_14),
                mCurrentView.findViewById(R.id.tv_subject_15),
                mCurrentView.findViewById(R.id.tv_subject_16),
                mCurrentView.findViewById(R.id.tv_subject_17),
                mCurrentView.findViewById(R.id.tv_subject_21),
                mCurrentView.findViewById(R.id.tv_subject_22),
                mCurrentView.findViewById(R.id.tv_subject_23),
                mCurrentView.findViewById(R.id.tv_subject_24),
                mCurrentView.findViewById(R.id.tv_subject_25),
                mCurrentView.findViewById(R.id.tv_subject_26),
                mCurrentView.findViewById(R.id.tv_subject_27),
                mCurrentView.findViewById(R.id.tv_subject_31),
                mCurrentView.findViewById(R.id.tv_subject_32),
                mCurrentView.findViewById(R.id.tv_subject_33),
                mCurrentView.findViewById(R.id.tv_subject_34),
                mCurrentView.findViewById(R.id.tv_subject_35),
                mCurrentView.findViewById(R.id.tv_subject_36),
                mCurrentView.findViewById(R.id.tv_subject_37),
                mCurrentView.findViewById(R.id.tv_subject_41),
                mCurrentView.findViewById(R.id.tv_subject_42),
                mCurrentView.findViewById(R.id.tv_subject_43),
                mCurrentView.findViewById(R.id.tv_subject_44),
                mCurrentView.findViewById(R.id.tv_subject_45),
                mCurrentView.findViewById(R.id.tv_subject_46),
                mCurrentView.findViewById(R.id.tv_subject_47),
                mCurrentView.findViewById(R.id.tv_subject_51),
                mCurrentView.findViewById(R.id.tv_subject_52),
                mCurrentView.findViewById(R.id.tv_subject_53),
                mCurrentView.findViewById(R.id.tv_subject_54),
                mCurrentView.findViewById(R.id.tv_subject_55),
                mCurrentView.findViewById(R.id.tv_subject_56),
                mCurrentView.findViewById(R.id.tv_subject_57),
        };

        int i, j;
        for (i = 0; i < 5; i++)
            for (j = 0; j < 7; j++)
                if (i * 7 + j != 34)
                    subjectViews[i * 7 + j].setText(Html.fromHtml(
                            "<b>" + Objects.requireNonNull(items.get(i * 7 + j))
                                    .replace("/", "</b><br>"))
                    );
    }

    @Override
    public void showToastForError() {
        Toast.makeText(getContext(), "시간표를 불러올 수 없습니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastForStrangeData() {
        Toast.makeText(getContext(), "학교 혹은 학년 반이 잘못되었습니다. 설정을 확인해주세요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastForNotFound() {
        Toast.makeText(getContext(), "서버에서 시간표를 찾을 수 없습니다", Toast.LENGTH_SHORT).show();
    }
}
