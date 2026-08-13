package com.example.escrowapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize views
        initializeViews();

        // Start animations
        startSplashAnimations();

        // Navigate to next activity after delay
        navigateAfterDelay();
    }

    private void initializeViews() {
        ImageView imgLogo = findViewById(R.id.imgLogo);
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        TextView tvVerifying = findViewById(R.id.tvVerifying);

        // Logo animation - Fade in
        if (imgLogo != null) {
            imgLogo.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        }

        // Welcome text animation - Fade in
        if (tvWelcome != null) {
            tvWelcome.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        }

        // Verifying label animation - Fade in
        if (tvVerifying != null) {
            tvVerifying.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        }
    }

    private void startSplashAnimations() {
        // Animate loading bar
        View loadingBar = findViewById(R.id.loadingBar);
        if (loadingBar != null) {
            // Animate from left to right (width expansion)
            loadingBar.animate()
                    .translationX(160f) // Move to the right
                    .setDuration(SPLASH_DURATION)
                    .start();
        }
    }

    private void navigateAfterDelay() {
        new Handler().postDelayed(() -> {
            // Navigate to OnboardingActivity
            Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
            startActivity(intent);

            // Finish this activity
            finish();

            // Add transition animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, SPLASH_DURATION);
    }
}