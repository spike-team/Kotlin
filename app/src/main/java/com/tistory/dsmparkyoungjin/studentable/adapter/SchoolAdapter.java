package com.tistory.dsmparkyoungjin.studentable.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private ArrayList<SchoolData> mItems;

    public SchoolAdapter(ArrayList<SchoolData> items) { mItems = items; }

    @NonNull
    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder holder, int position) { holder.bind(); }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        void bind() {
            SchoolData item = mItems.get(getAdapterPosition());

            TextView nameSchool = mItemView.findViewById(R.id.tv_nameSchool);
            nameSchool.setText(item.getName());
        }
    }
}
