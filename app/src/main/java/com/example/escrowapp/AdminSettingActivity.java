package com.example.escrowapp;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class AdminSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_settings);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        EditText etFeeRate = findViewById(R.id.etFeeRate);
        Switch switchAutoFlag = findViewById(R.id.switchAutoFlag);
        Switch switchEmailAlerts = findViewById(R.id.switchEmailAlerts);

        findViewById(R.id.btnSaveSettings).setOnClickListener(v -> {
            String feeRate = etFeeRate.getText().toString();
            Toast.makeText(this, "Settings saved — Fee: " + feeRate + "%, Auto-flag: "
                            + switchAutoFlag.isChecked() + ", Email alerts: " + switchEmailAlerts.isChecked(),
                    Toast.LENGTH_LONG).show();
        });
    }
}

