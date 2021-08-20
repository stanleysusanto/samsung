package me.ltxom.patientapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.internal.LinkedTreeMap;

import java.io.ByteArrayOutputStream;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import me.ltxom.patientapp.service.DoctorService;
import me.ltxom.patientapp.service.PatientService;

public class LoginActivity extends AppCompatActivity {
    DoctorService mDoctorService;

    TextView create_account;
    Button mSignInButton;
    TextView mEmailText;
    TextInputEditText mPasswordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDoctorService = new DoctorService();

        create_account = findViewById(R.id.create_account);
        mSignInButton = findViewById(R.id.signin_button);
        mEmailText = findViewById(R.id.edit_email);
        mPasswordText = findViewById(R.id.input_password);
        // add new patient
/*
        PatientService patientService = new PatientService();
        final boolean[] flag = {false};
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, baos);
                flag[0] = true;
            }
        };
        Thread t = new Thread(runnable);
        t.start();

        while(!flag[0]){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.URL_SAFE);

        String patientId = patientService.createProfile("Maurice", "White", "233-3333-3333", "mwhite@email.com", imageString);
*/
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<LinkedTreeMap> doctorList = mDoctorService.listDoctors();
                boolean loginFlag = false;
                String doctorName = "";
                for (LinkedTreeMap map : doctorList) {
                    if (map.get("email").equals(mEmailText.getText().toString()) && map.get("doctorPassword").equals(mPasswordText.getText().toString())) {
                        loginFlag = true;
                        doctorName = map.get("lastName").toString();
                        break;
                    }
                }
                if (loginFlag) {
                    MainActivity.doctorText = "Hi Dr. " + doctorName + ", who are you treating today?";
                    Intent b = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(b);
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed. Please check your email and password combination.", Toast.LENGTH_LONG).show();
                }
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }
}
