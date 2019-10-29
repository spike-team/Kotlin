package com.tistory.dsmparkyoungjin.studentable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import java.util.ArrayList;

public class MealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MealData> mItems;

    private static final int SINGLE = 1;
    private static final int TRIPLE = 3;

    public MealAdapter(ArrayList<MealData> items) {
        mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position).getBreakfast() == null &&
                mItems.get(position).getDinner() == null)
            return SINGLE;
        else
            return TRIPLE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == SINGLE)
            return new MealSingleHolder(layoutInflater.inflate(R.layout.item_meal_single, parent, false));
        else
            return new MealTripleHolder(layoutInflater.inflate(R.layout.item_meal_triple, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MealSingleHolder)
            ((MealSingleHolder) holder).bind();
        else
            ((MealTripleHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MealTripleHolder extends RecyclerView.ViewHolder {

        private View mItemView;

        MealTripleHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }

        void bind() {
            MealData item = mItems.get(getAdapterPosition());

            TextView tvDate = mItemView.findViewById(R.id.tv_date);
            tvDate.setText(item.getDate());

            TextView tvBreakfast = mItemView.findViewById(R.id.tv_listBreakfast);
            TextView tvLunch = mItemView.findViewById(R.id.tv_listLunch);
            TextView tvDinner = mItemView.findViewById(R.id.tv_listDinner);

            StringBuilder listBreakfast = new StringBuilder();
            StringBuilder listLunch = new StringBuilder();
            StringBuilder listDinner = new StringBuilder();

            if (item.getBreakfast() != null) {
                for (String menuBreakfast : item.getBreakfast()) {
                    listBreakfast.append(menuBreakfast).append(" ");
                }
                tvBreakfast.setText(listBreakfast);
            }

            if (item.getLunch() != null) {
                for (String menuLunch : item.getLunch()) {
                    listLunch.append(menuLunch).append(" ");
                }
                tvLunch.setText(listLunch);
            }

            if (item.getDinner() != null) {
                for (String menuDinner : item.getDinner()) {
                    listDinner.append(menuDinner).append(" ");
                }
                tvDinner.setText(listDinner);
            }
        }
    }

    class MealSingleHolder extends RecyclerView.ViewHolder {

        private View mItemView;

        MealSingleHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }

        void bind() {
            MealData item = mItems.get(getAdapterPosition());

            TextView tvDate = mItemView.findViewById(R.id.tv_date);
            tvDate.setText(item.getDate());

            TextView tvLunch = mItemView.findViewById(R.id.tv_listLunch);

            StringBuilder listLunch = new StringBuilder();

            if (item.getLunch() != null) {
                for (String menuLunch : item.getLunch()) {
                    listLunch.append(menuLunch).append(" ");
                }
                tvLunch.setText(listLunch);
            }
        }
    }
}
