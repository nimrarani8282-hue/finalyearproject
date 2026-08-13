package com.example.escrowapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.R;
import com.example.escrowapp.model.BuyerTransaction;

import java.util.List;
import java.util.Locale;

public class BuyerTransactionAdapter extends RecyclerView.Adapter<BuyerTransactionAdapter.ViewHolder> {

    private final List<BuyerTransaction> transactions;

    // SINGLE CONSTRUCTOR - REMOVE DUPLICATE
    public BuyerTransactionAdapter(List<BuyerTransaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_buyer_transaction, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BuyerTransaction t = transactions.get(position);

        if (holder.tvTitle != null) {
            holder.tvTitle.setText(t.getTitle());
        }
        if (holder.tvSubtitle != null) {
            holder.tvSubtitle.setText(t.getCounterparty() + " • " + t.getDate());
        }
        if (holder.tvAmount != null) {
            holder.tvAmount.setText(String.format(Locale.US, "$%,.2f", t.getAmount()));
        }

        if (holder.tvStatus != null) {
            switch (t.getStatus()) {
                case SECURED:
                    holder.tvStatus.setText("Secured");
                    holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_secured);
                    holder.tvStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_secondary_container, null));
                    break;
                case RELEASED:
                    holder.tvStatus.setText("Released");
                    holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_released);
                    holder.tvStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_tertiary_fixed, null));
                    break;
                case DISPUTED:
                    holder.tvStatus.setText("Disputed");
                    holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_disputed);
                    holder.tvStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.on_error_container, null));
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvAmount, tvStatus;
        ImageView ivIcon;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTxTitle);
            tvSubtitle = itemView.findViewById(R.id.tvTxSubtitle);
            tvAmount = itemView.findViewById(R.id.tvTxAmount);
            tvStatus = itemView.findViewById(R.id.tvTxStatus);
            ivIcon = itemView.findViewById(R.id.ivTxIcon);
        }
    }
}