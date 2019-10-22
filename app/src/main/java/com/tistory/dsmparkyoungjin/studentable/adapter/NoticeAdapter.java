package com.tistory.dsmparkyoungjin.studentable.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.NoticeData;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private ArrayList<NoticeData> mItems;

    public NoticeAdapter(ArrayList<NoticeData> items) { mItems = items; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bind(); }

    @Override
    public int getItemCount() { return mItems.size(); }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        void bind() {
            NoticeData item = mItems.get(getAdapterPosition());

            TextView tvDate = mItemView.findViewById(R.id.tv_date_notification);
            tvDate.setText(item.getDate());

            TextView tvContent = mItemView.findViewById(R.id.tv_content_notification);
            tvContent.setText(item.getContent());
        }
    }
}
