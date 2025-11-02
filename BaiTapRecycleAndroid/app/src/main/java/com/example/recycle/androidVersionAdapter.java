package com.example.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class androidVersionAdapter extends RecyclerView.Adapter<androidVersionAdapter.ViewHolder> {

    private final ArrayList<androidVersion> androidList;
    private final ItemClicked activity;

    // Giao diện callback
    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public androidVersionAdapter(Context context, ArrayList<androidVersion> list) {
        androidList = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName, tvVersion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvnam);
            tvVersion = itemView.findViewById(R.id.tvversion);
            ivIcon = itemView.findViewById(R.id.ivicon);

            // Sự kiện click vào từng item
            itemView.setOnClickListener(v -> activity.onItemClicked(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public androidVersionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_item, parent, false); // ⚠️ đổi từ list_item → album_item
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull androidVersionAdapter.ViewHolder holder, int position) {
        androidVersion current = androidList.get(position);

        holder.tvName.setText(current.getName());
        holder.tvVersion.setText(current.getVersion());

        // 🖼️ Load hình theo tên trong drawable
        Context context = holder.ivIcon.getContext();
        int imageRes = context.getResources().getIdentifier(
                current.getImage(), "drawable", context.getPackageName()
        );

        if (imageRes != 0) {
            holder.ivIcon.setImageResource(imageRes);
        } else {
            // Ảnh mặc định nếu không tìm thấy
            holder.ivIcon.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }
}
