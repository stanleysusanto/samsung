package me.ltxom.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
    public class NewPatient4 extends AppCompatActivity {

        Button next1;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.new_patient4);

            next1 = findViewById(R.id.next_button4);
            next1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent move1 = new Intent(NewPatient4.this, NewPatient5.class);
                    startActivity(move1);
                }
            });
        }
}
