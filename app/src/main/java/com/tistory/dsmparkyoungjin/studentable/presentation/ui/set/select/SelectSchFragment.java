package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

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

    public SelectSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_select_sch, container, false);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new SelectSchPresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void initView() {
        initNextButton();
        initRecyclerView();
    }

    private void initNextButton() {
        mCurrentView.findViewById(R.id.btn_next).setOnClickListener(
                v -> onNextSelect()
        );
    }

    private void initRecyclerView() {
    }

    @Override
    public void setItems(List<SchoolData> items) {
        RecyclerView rvSchool = mCurrentView.findViewById(R.id.rv_school);
        SchoolAdapter adapter = new SchoolAdapter(items);
        rvSchool.setAdapter(adapter);
    }

    @Override
    public void onNextSelect() {
        ((SetActivity) Objects.requireNonNull(getActivity())).setFragment();
    }

    @Override
    public void notFound() {
        Toast.makeText(getContext(), "결과를 찾을 수 없습니다", Toast.LENGTH_SHORT).show();
        ((SetActivity) Objects.requireNonNull(getActivity())).searchFragment();
    }
}