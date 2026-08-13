package com.example.escrowapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

public class OnboardingActivity extends AppCompatActivity {

    private static final int TOTAL_SLIDES = 3;
    private ViewPager2 viewPager;
    private LinearLayout dotsLayout;
    private MaterialButton btnNext;
    private LinearLayout finalActionsLayout;
    private MaterialButton btnGetStarted;
    private MaterialButton btnLogin;
    private TextView btnSkip;
    private View[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        bindViews();
        setupViewPager();
        buildDots(0);
        attachListeners();
    }

    private void bindViews() {
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        btnNext = findViewById(R.id.btnNext);
        finalActionsLayout = findViewById(R.id.finalActionsLayout);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        btnLogin = findViewById(R.id.btnLogin);
        btnSkip = findViewById(R.id.btnSkip);
    }

    private void setupViewPager() {
        OnboardingAdapter adapter = new OnboardingAdapter(this);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                refreshDots(position);
                refreshButtons(position);
            }
        });
    }

    private void buildDots(int active) {
        dotsLayout.removeAllViews();
        dots = new View[TOTAL_SLIDES];

        for (int i = 0; i < TOTAL_SLIDES; i++) {
            View dot = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    i == active ? 32 : 8, 8
            );
            lp.setMargins(4, 0, 4, 0);
            dot.setLayoutParams(lp);
            dot.setBackgroundResource(i == active ? R.drawable.bg_dot_active : R.drawable.bg_dot_inactive);
            dots[i] = dot;
            dotsLayout.addView(dot);
        }
    }

    private void refreshDots(int newActive) {
        for (int i = 0; i < TOTAL_SLIDES; i++) {
            if (dots == null || dots[i] == null) continue;
            View dot = dots[i];
            boolean active = (i == newActive);
            int target = active ? 32 : 8;

            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) dot.getLayoutParams();
            lp.width = target;
            dot.setLayoutParams(lp);
            dot.setBackgroundResource(active ? R.drawable.bg_dot_active : R.drawable.bg_dot_inactive);
        }
    }

    private void refreshButtons(int position) {
        boolean isLast = (position == TOTAL_SLIDES - 1);

        if (isLast) {
            btnNext.setVisibility(View.GONE);
            finalActionsLayout.setVisibility(View.VISIBLE);
            btnSkip.setVisibility(View.GONE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            finalActionsLayout.setVisibility(View.GONE);
            btnSkip.setVisibility(View.VISIBLE);
        }
    }

    private void attachListeners() {
        btnNext.setOnClickListener(v -> {
            int next = viewPager.getCurrentItem() + 1;
            if (next < TOTAL_SLIDES) {
                viewPager.setCurrentItem(next, true);
            }
        });

        btnSkip.setOnClickListener(v -> viewPager.setCurrentItem(TOTAL_SLIDES - 1, true));

        btnGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}