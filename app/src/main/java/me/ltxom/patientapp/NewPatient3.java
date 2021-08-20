package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewPatient3 extends AppCompatActivity {

    Button next1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_patient3);

        next1 = findViewById(R.id.next_button3);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move1 = new Intent(NewPatient3.this, NewPatient4.class);
                startActivity(move1);
            }
        });
    }

}
