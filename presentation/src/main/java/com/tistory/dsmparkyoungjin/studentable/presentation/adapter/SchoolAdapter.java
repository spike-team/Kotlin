package com.tistory.dsmparkyoungjin.studentable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.entity.School;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private ArrayList<School> mItems;

    public SchoolAdapter(ArrayList<School> items) { mItems = items; }

    @NonNull
    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private School mItem = mItems.get(getAdapterPosition() + 1);

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        void bind() {
            TextView nameSchool = mView.findViewById(R.id.tv_nameSchool);
            nameSchool.setText(mItem.getName());
        }
    }
}
