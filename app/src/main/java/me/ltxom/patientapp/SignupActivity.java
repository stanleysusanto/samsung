package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import me.ltxom.patientapp.service.DoctorService;

public class SignupActivity extends AppCompatActivity {
    DoctorService mDoctorService;

    Button signUp_button;
    Spinner spinner;
    CheckBox mCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp_button = findViewById(R.id.signup_button);
        mCheckBox = findViewById(R.id.checkbox1);

        mDoctorService = new DoctorService();

        final EditText mFirstName = findViewById(R.id.edit_firstName);
        final EditText mLastName = findViewById(R.id.edit_lastName);
        final EditText mEmail = findViewById(R.id.edit_email2);
        final EditText mPassword = findViewById(R.id.edit_password2);

        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCheckBox.isChecked()) {
                    List<LinkedTreeMap> doctorList = mDoctorService.listDoctors();
                    boolean emailFlag = false;
                    for (LinkedTreeMap doctor : doctorList) {
                        if (doctor.get("email").equals(mEmail.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Email is taken.", Toast.LENGTH_SHORT).show();
                            emailFlag = true;
                            break;
                        }
                    }
                    if (!emailFlag) {
                        mDoctorService.addDoctor(mFirstName.getText().toString(), mLastName.getText().toString(), mEmail.getText().toString(), mPassword.getText().toString());
                        MainActivity.doctorText = "Hi Dr. " + mLastName.getText().toString() + ", who are you treating today?";
                        Toast.makeText(getApplicationContext(), "Doctor Profile Created", Toast.LENGTH_SHORT).show();
                        Intent b = new Intent(SignupActivity.this, MainActivity.class);
                        startActivity(b);
                    }
                } else {
                    // popup u should agree to continue
                    Toast.makeText(getApplicationContext(), "You need to agree Terms and Conditions.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        spinner = findViewById(R.id.provider_type);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getBaseContext(),
                R.array.providerType_string, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }
/*
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox1:
                if (checked) {
                    Intent a = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(a);
                }
        }
    }
    */
}
