package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import androidx.appcompat.app.AppCompatActivity;
import me.ltxom.patientapp.entity.Patient;
import me.ltxom.patientapp.service.PatientService;

public class Prescription extends AppCompatActivity {
    public static boolean flag = false;

    TextView name;
    CheckBox mCheckBox;
    MaterialCardView mMaterialCardView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription);

        name = findViewById(R.id.patient_name_pres);
        name.setText("");
        mCheckBox  = findViewById(R.id.checkbox_prs);
        mMaterialCardView = findViewById(R.id.cardview_pres);
        mButton = findViewById(R.id.confirm_button_prs);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Prescription.this, FingerPrint.class);
                startActivity(c);
            }
        });

    }

}
