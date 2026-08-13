package com.example.escrowapp;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class BuyerServiceRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_service_request);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        EditText etCategory = findViewById(R.id.etCategory);
        EditText etDetails = findViewById(R.id.etProjectDetails);

        findViewById(R.id.btnPostRequest).setOnClickListener(v -> {
            if (etCategory.getText().toString().trim().isEmpty()
                    || etDetails.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Category aur Details fill karein", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Service request posted", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}


