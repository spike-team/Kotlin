package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.presentation.adapter.SchoolAdapter;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.ArrayList;
import java.util.Objects;

public class SelectSchFragment extends Fragment {

    public SelectSchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_sch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ArrayList<SchoolData> items = new ArrayList<>();
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "1"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "2"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "3"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "4"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "5"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "6"));
        items.add(new SchoolData("대덕소프트웨어마이스터고등학교", "7"));

        RecyclerView recyclerView = view.findViewById(R.id.rv_school);
        recyclerView.setAdapter(new SchoolAdapter(items));
        view.findViewById(R.id.btn_next).setOnClickListener(
                v -> ((SetActivity) Objects.requireNonNull(getActivity())).setFragment()
        );
    }
}