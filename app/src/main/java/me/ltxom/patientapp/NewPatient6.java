package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewPatient6 extends AppCompatActivity {

    Button add_visit, home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_patient6);

        add_visit = findViewById(R.id.add_visit);
        home = findViewById(R.id.home);

        add_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move1 = new Intent(NewPatient6.this, NewPatient7.class);
                startActivity(move1);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move1 = new Intent(NewPatient6.this, MainActivity.class);
                startActivity(move1);
            }
        });
    }
}
