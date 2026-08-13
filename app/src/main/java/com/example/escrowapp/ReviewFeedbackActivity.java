package com.example.escrowapp;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ReviewFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_feedback);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        RatingBar ratingBar = findViewById(R.id.ratingBar);

        findViewById(R.id.btnSubmitReview).setOnClickListener(v -> {
            Toast.makeText(this, "Review submitted: " + (int) ratingBar.getRating() + " stars",
                    Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}