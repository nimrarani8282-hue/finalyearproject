package com.example.escrowapp;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        findViewById(R.id.rowExportFinancial).setOnClickListener(v ->
                Toast.makeText(this, "Exporting Financial Summary Report...", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowExportDisputes).setOnClickListener(v ->
                Toast.makeText(this, "Exporting Disputes & Resolutions Report...", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowExportUsers).setOnClickListener(v ->
                Toast.makeText(this, "Exporting User Growth Report...", Toast.LENGTH_SHORT).show());
    }
}
