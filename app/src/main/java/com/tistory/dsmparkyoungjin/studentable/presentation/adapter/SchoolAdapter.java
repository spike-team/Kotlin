package com.tistory.dsmparkyoungjin.studentable.presentation.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private List<SchoolData> mItems;

    private SchoolData selectItem;
    private int selectPosition = -1;

    public SchoolAdapter(List<SchoolData> items) {
        mItems = items;
    }

    public SchoolData getSelectedItem() {
        return selectItem;
    }

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

        private View mItemView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        void bind() {
            if (getAdapterPosition() == selectPosition)
                mItemView.setBackgroundColor(Color.GRAY);
            else
                mItemView.setBackgroundColor(Color.WHITE);

            SchoolData item = mItems.get(getAdapterPosition());

            TextView nameSchool = mItemView.findViewById(R.id.tv_nameSchool);
            nameSchool.setText(parseSchoolName(item.getFullName()));

            mItemView.setOnClickListener(v -> {
                if (selectPosition == getAdapterPosition()) {
                    selectItem = null;
                    selectPosition = -1;
                } else {
                    selectItem = item;
                    selectPosition = getAdapterPosition();
                }

                notifyDataSetChanged();
            });
        }

    }

    private static String parseSchoolName(String text) {
        return text.replaceFirst("(?s)(.*)" + " ", "$1" + "\n");
    }
}