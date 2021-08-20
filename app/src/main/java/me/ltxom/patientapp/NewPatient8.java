package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewPatient8 extends AppCompatActivity {

    Button print_qrcode, home2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_patient8);

        print_qrcode = findViewById(R.id.print_qrcode);
        home2 = findViewById(R.id.home2);

        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move1 = new Intent(NewPatient8.this, MainActivity.class);
                startActivity(move1);
            }
        });



    }

}
