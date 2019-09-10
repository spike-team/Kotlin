package com.tistory.dsmparkyoungjin.studentable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.entity.Notification;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<Notification> mItems;

    public NotificationAdapter(ArrayList<Notification> items) { mItems = items; }

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

        private View mView;
        private Notification mItem = mItems.get(getAdapterPosition() + 1);

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        void bind() {
            TextView date = mView.findViewById(R.id.tv_date_notification);
            TextView content = mView.findViewById(R.id.tv_content_notification);

            date.setText(mItem.getDate());
            content.setText(mItem.getContent());
        }
    }
}
