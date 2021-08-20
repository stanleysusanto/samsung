package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.knox.accounts.*;

public class ProfileDex extends AppCompatActivity {

    Button psBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_dex);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        psBtn = findViewById(R.id.prescription_btn);

        psBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(ProfileDex.this, ProfileDexPres.class);
                startActivity(c);
            }
        });

        // Patient patient = new PatientService().findPatient(Profile.patientid);


    }

}
