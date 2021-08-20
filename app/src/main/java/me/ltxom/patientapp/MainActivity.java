package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static String doctorText = "";
    TextView mDoctorText;
    ImageView mIconScan;
    TextView new_patient;
    TextInputEditText current_patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDoctorText = findViewById(R.id.text_doctor);
        current_patient = findViewById(R.id.current_patient);
        new_patient = findViewById(R.id.new_patient);
        mIconScan = findViewById(R.id.icon_scan);
        mDoctorText.setText(doctorText);

        current_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this, SearchPage.class);
                startActivity(c);
            }
        });

        new_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this, NewPatient.class);
                startActivity(c);
            }
        });

        mIconScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this, QRActivity.class);
                startActivity(c);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
