package com.tistory.dsmparkyoungjin.studentable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealHolder> {

    private List<MealData> mItems;

    private static final int BREAKFAST = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;

    public MealAdapter(List<MealData> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MealHolder extends RecyclerView.ViewHolder {

        private View mItemView;

        MealHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }

        void bind() {
            MealData item = mItems.get(getAdapterPosition());

            TextView tvDay = mItemView.findViewById(R.id.tv_day);
            TextView tvDate = mItemView.findViewById(R.id.tv_date);
            tvDate.setText(item.getDate());
            tvDay.setText(item.getDay());

            List[] itemList = new List[]{
                    item.getBreakfast(),
                    item.getLunch(),
                    item.getDinner()};

            TextView[] itemViewArray = {
                    mItemView.findViewById(R.id.tv_listBreakfast),
                    mItemView.findViewById(R.id.tv_listLunch),
                    mItemView.findViewById(R.id.tv_listDinner)};

            RelativeLayout[] containerArray = {
                    mItemView.findViewById(R.id.rl_breakfast),
                    mItemView.findViewById(R.id.rl_lunch),
                    mItemView.findViewById(R.id.rl_dinner)};

            StringBuilder strBuilder = new StringBuilder();

            for (int i = BREAKFAST; i <= DINNER; i++) {
                strBuilder.delete(0, strBuilder.length());
                if (itemList[i] != null) {
                    for (int j = 0; j < itemList[i].size(); j++) {
                        strBuilder.append(itemList[i].get(j)).append(" ");
                    }
                    itemViewArray[i].setText(strBuilder);
                } else {
                    containerArray[i].setVisibility(View.GONE);
                }
            }
        }
    }
}
