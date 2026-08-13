package com.example.escrowapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.R;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.SlideViewHolder> {

    private final Context ctx;
    private final SlideModel[] data;

    static class SlideModel {
        final int primaryIcon;
        final int secondaryIcon;
        final int primaryTint;
        final int secondaryTint;
        final String title;
        final String description;

        SlideModel(int primaryIcon, int secondaryIcon, int primaryTint, int secondaryTint, String title, String description) {
            this.primaryIcon = primaryIcon;
            this.secondaryIcon = secondaryIcon;
            this.primaryTint = primaryTint;
            this.secondaryTint = secondaryTint;
            this.title = title;
            this.description = description;
        }
    }

    public OnboardingAdapter(Context ctx) {
        this.ctx = ctx;
        data = new SlideModel[]{
                new SlideModel(R.drawable.ic_shield, R.drawable.ic_payments, ctx.getColor(R.color.primary), ctx.getColor(R.color.tertiary), ctx.getString(R.string.slide_0_title), ctx.getString(R.string.slide_0_desc)),
                new SlideModel(R.drawable.ic_search, R.drawable.ic_description, ctx.getColor(R.color.primary), ctx.getColor(R.color.secondary), ctx.getString(R.string.slide_1_title), ctx.getString(R.string.slide_1_desc)),
                new SlideModel(R.drawable.ic_rocket_launch, R.drawable.ic_check_circle, ctx.getColor(R.color.primary), ctx.getColor(R.color.tertiary), ctx.getString(R.string.slide_2_title), ctx.getString(R.string.slide_2_desc))
        };
    }

    static class SlideViewHolder extends RecyclerView.ViewHolder {
        final ImageView ivPrimary;
        final ImageView ivSecondary;
        final TextView tvTitle;
        final TextView tvDesc;

        SlideViewHolder(@NonNull View v) {
            super(v);
            ivPrimary = v.findViewById(R.id.ivIconPrimary);
            ivSecondary = v.findViewById(R.id.ivIconSecondary);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDesc = v.findViewById(R.id.tvDescription);
        }
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.fragment_onboarding_slide, parent, false);
        return new SlideViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder h, int position) {
        SlideModel m = data[position];
        h.ivPrimary.setImageResource(m.primaryIcon);
        h.ivSecondary.setImageResource(m.secondaryIcon);
        h.ivPrimary.setColorFilter(m.primaryTint);
        h.ivSecondary.setColorFilter(m.secondaryTint);
        h.tvTitle.setText(m.title);
        h.tvDesc.setText(m.description);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
