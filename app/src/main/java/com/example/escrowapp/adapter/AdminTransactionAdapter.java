package com.example.escrowapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.R;
import com.example.escrowapp.model.AdminTransaction;

import java.util.List;
import java.util.Locale;

public class AdminTransactionAdapter extends RecyclerView.Adapter<AdminTransactionAdapter.ViewHolder> {

    private final List<AdminTransaction> transactions;

    // SINGLE CONSTRUCTOR - REMOVE DUPLICATES
    public AdminTransactionAdapter(List<AdminTransaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_admin_transaction, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminTransaction t = transactions.get(position);

        if (holder.tvTxId != null) {
            holder.tvTxId.setText(t.getTransactionId());
        }
        if (holder.tvTxUser != null) {
            holder.tvTxUser.setText(t.getUserName());
        }
        if (holder.tvTxValue != null) {
            holder.tvTxValue.setText(String.format(Locale.US, "$%,.2f", t.getValue()));
        }

        if (holder.tvTxStatus != null) {
            switch (t.getStatus()) {
                case DISPUTED:
                    holder.tvTxStatus.setText("Disputed");
                    holder.tvTxStatus.setBackgroundResource(R.drawable.bg_badge_disputed);
                    holder.tvTxStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_error_container, null));
                    break;
                case VERIFICATION:
                    holder.tvTxStatus.setText("Verification");
                    holder.tvTxStatus.setBackgroundResource(R.drawable.bg_badge_verification);
                    holder.tvTxStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_surface_variant, null));
                    break;
                case SECURED:
                    holder.tvTxStatus.setText("Secured");
                    holder.tvTxStatus.setBackgroundResource(R.drawable.bg_badge_released);
                    holder.tvTxStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_tertiary_fixed_variant, null));
                    break;
            }
        }

        if (holder.ivTxView != null) {
            holder.ivTxView.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Viewing " + t.getTransactionId(), Toast.LENGTH_SHORT).show());
        }
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTxId, tvTxUser, tvTxValue, tvTxStatus;
        ImageView ivTxView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTxId = itemView.findViewById(R.id.tvTxId);
            tvTxUser = itemView.findViewById(R.id.tvTxUser);
            tvTxValue = itemView.findViewById(R.id.tvTxValue);
            tvTxStatus = itemView.findViewById(R.id.tvTxStatus);
            ivTxView = itemView.findViewById(R.id.ivTxView);
        }
    }
}