package me.ltxom.patientapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileDexPres extends AppCompatActivity {

    LinearLayout addMedicine;
    TextView medicine1;
    TextView medicine2;
    TextView medicine3;
    LinearLayout checkOut;
    final int[] counter = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        if (!(height == 2064 && width == 1080)) {
            setContentView(R.layout.profile_dex_pres);

            addMedicine = findViewById(R.id.add_medicine);
            medicine1 = findViewById(R.id.medicine1);
            medicine2 = findViewById(R.id.medicine2);
            medicine3 = findViewById(R.id.medicine3);
            checkOut = findViewById(R.id.check_out);
            medicine1.setVisibility(View.GONE);
            medicine2.setVisibility(View.GONE);
            medicine3.setVisibility(View.GONE);

            addMedicine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter[0]++;
                    switch (counter[0]) {
                        case 1:
                            medicine1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            medicine2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            medicine3.setVisibility(View.VISIBLE);
                            break;
                    }
                    if (counter[0] >= 3) {
                        checkOut.setBackgroundColor(Color.parseColor("#71d88c"));
                        Prescription.flag = true;
                    }
                }
            });
            checkOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent c = new Intent(ProfileDexPres.this, Prescription.class);
                    startActivity(c);
                }
            });
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent c = new Intent(ProfileDexPres.this, Prescription.class);
            startActivity(c);
        }
        // Patient patient = new PatientService().findPatient(Profile.patientid);

    }
/*
    @Override
    public void onResume() {
        super.onResume();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        if ((height == 2064 && width == 1080)) {
            Toast.makeText(this, "Mobile Mode", Toast.LENGTH_LONG).show();
            Intent c = new Intent(ProfileDexPres.this, Profile.class);
            if (Prescription.flag) {
                //TODO
                c = new Intent(ProfileDexPres.this, Prescription.class);
            }
            startActivity(c);
        }
    }*/
}
