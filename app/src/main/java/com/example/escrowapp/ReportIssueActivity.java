package com.example.escrowapp;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ReportIssueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issue);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        EditText etOrderId = findViewById(R.id.etOrderId);
        EditText etIssueDescription = findViewById(R.id.etIssueDescription);

        findViewById(R.id.btnSubmitDispute).setOnClickListener(v -> {
            if (etOrderId.getText().toString().trim().isEmpty()
                    || etIssueDescription.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Order ID aur Issue description fill karein", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Dispute case opened. Support will review.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
