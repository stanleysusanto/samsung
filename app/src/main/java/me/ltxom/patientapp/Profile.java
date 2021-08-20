package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import me.ltxom.patientapp.entity.Patient;
import me.ltxom.patientapp.service.PatientService;

public class Profile extends AppCompatActivity {

    public static String patientid = "";
    TextView name;
    TextView dex1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        if ((height == 2064 && width == 1080)) {
            setContentView(R.layout.profile);

            Patient patient = new PatientService().findPatient(patientid);
            name = findViewById(R.id.patient_name);
            name.setText(patient.firstName + " " + patient.lastName);
            dex1 = findViewById(R.id.dex1);

            final Profile act = this;
            dex1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(act, "Dex Mode", Toast.LENGTH_LONG).show();
                    Intent c = new Intent(Profile.this, ProfileDex.class);
                    startActivity(c);
                }
            });
        } else {
            Toast.makeText(this, "Dex Mode", Toast.LENGTH_LONG).show();
            Intent c = new Intent(Profile.this, ProfileDex.class);
            startActivity(c);
        }

    }

}
