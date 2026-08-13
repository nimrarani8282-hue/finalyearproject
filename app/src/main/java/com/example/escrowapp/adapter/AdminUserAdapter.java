package com.example.escrowapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.R;
import com.example.escrowapp.model.AdminUser;

import java.util.List;

public class AdminUserAdapter extends RecyclerView.Adapter<AdminUserAdapter.ViewHolder> {

    private final List<AdminUser> users;

    // SINGLE CONSTRUCTOR - REMOVE DUPLICATES
    public AdminUserAdapter(List<AdminUser> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_admin_user, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminUser u = users.get(position);

        if (holder.tvInitials != null) {
            holder.tvInitials.setText(u.getInitials());
        }
        if (holder.tvName != null) {
            holder.tvName.setText(u.getName());
        }
        if (holder.tvSubtitle != null) {
            holder.tvSubtitle.setText(u.getSubtitle());
        }
        if (holder.tvFlag != null) {
            holder.tvFlag.setVisibility(u.isFlagged() ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInitials, tvName, tvSubtitle, tvFlag;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInitials = itemView.findViewById(R.id.tvUserInitials);
            tvName = itemView.findViewById(R.id.tvUserName);
            tvSubtitle = itemView.findViewById(R.id.tvUserSubtitle);
            tvFlag = itemView.findViewById(R.id.tvUserFlag);
        }
    }
}