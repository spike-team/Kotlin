package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.set;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.Objects;

import nl.dionsegijn.steppertouch.StepperTouch;

public class SetClsFragment extends Fragment implements SetClsContract.View {

    private View mCurrentView;
    private SetClsContract.Presenter mPresenter;

    public SetClsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_set_cls, container, false);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new SetClsPresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void initView() {
        initSaveButton();
    }

    @Override
    public void setSchoolName(String name) {
        TextView tvSchoolName = mCurrentView.findViewById(R.id.tv_nameSchool);
        tvSchoolName.setText(name);
    }

    @Override
    public int getGradeNo() {
        StepperTouch stGrade = mCurrentView.findViewById(R.id.st_grade);
        return stGrade.getCount();
    }

    @Override
    public int getClassNo() {
        StepperTouch stClass = mCurrentView.findViewById(R.id.st_class);
        return stClass.getCount();
    }

    @Override
    public void showToastForSetNumber() {
        Toast.makeText(getContext(), "학년 반을 설정해 주세요.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextSave() {
        ((SetActivity) Objects.requireNonNull(getActivity())).onNextSet();
    }

    private void initSaveButton() {
        mCurrentView.findViewById(R.id.btn_save).setOnClickListener(v -> mPresenter.save());
    }
}