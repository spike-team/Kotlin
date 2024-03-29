package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.Objects;

public class SearchSchFragment extends Fragment implements SearchSchContract.View {

    private View mCurrentView;
    private SearchSchContract.Presenter mPresenter;

    public SearchSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_search_sch, container, false);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new SearchSchPresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void initView() {
        initSearchButton();
        initSearchEditText();
    }

    @Override
    public void showToastForLackWord() {
        Toast.makeText(getContext(), "3글자 이상 입력해주세요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextSearch() {
        ((SetActivity) Objects.requireNonNull(getActivity())).selectFragment();
    }

    @Override
    public String getSchoolName() {
        MaterialEditText metSearchSchool = mCurrentView.findViewById(R.id.met_searchSchool);
        return Objects.requireNonNull(metSearchSchool.getText()).toString();
    }

    private void initSearchButton() {
        mCurrentView.findViewById(R.id.btn_search).setOnClickListener(
                v -> mPresenter.search()
        );
    }

    private void initSearchEditText() {
        ((EditText) mCurrentView.findViewById(R.id.met_searchSchool)).setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mPresenter.search();
            }
            return true;
        });
    }
}