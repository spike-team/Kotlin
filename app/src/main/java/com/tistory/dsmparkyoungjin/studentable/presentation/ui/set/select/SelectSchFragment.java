package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.presentation.adapter.SchoolAdapter;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.List;
import java.util.Objects;

public class SelectSchFragment extends Fragment implements SelectSchContract.View {

    private View mCurrentView;
    private SelectSchContract.Presenter mPresenter;
    private SchoolAdapter mAdapter;

    public SelectSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_select_sch, container, false);
        return mCurrentView;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new SelectSchPresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void initView() {
        initSelectButton();
    }

    @Override
    public void setItems(List<SchoolData> items) {
        RecyclerView rvSchool = mCurrentView.findViewById(R.id.rv_school);
        mAdapter = new SchoolAdapter(items);
        rvSchool.setAdapter(mAdapter);
    }

    @Override
    public void showToastForNotFound() {
        Toast.makeText(getContext(), "찾을 수 없는 학교 이름입니다", Toast.LENGTH_SHORT).show();
        onPrevious();
    }

    @Override
    public void showToastForNotConnectInternet() {
        Toast.makeText(getContext(), "연결할 수 없습니다. 인터넷을 확인해주세요", Toast.LENGTH_SHORT).show();
        onPrevious();
    }

    @Override
    public SchoolData getSelectedItem() {
        return mAdapter.getSelectedItem();
    }

    @Override
    public void onNextSelect() {
        ((SetActivity) Objects.requireNonNull(getActivity())).setFragment();
    }

    @Override
    public void notSelected() {
        Toast.makeText(getContext(), "학교를 선택해주세요", Toast.LENGTH_SHORT).show();
    }

    private void initSelectButton() {
        mCurrentView.findViewById(R.id.btn_next).setOnClickListener(
                v -> mPresenter.select()
        );
    }

    private void onPrevious() {
        ((SetActivity) Objects.requireNonNull(getActivity())).searchFragment();
    }
}