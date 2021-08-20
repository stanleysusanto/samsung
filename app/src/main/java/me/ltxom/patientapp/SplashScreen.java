package me.ltxom.patientapp;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by paulstanley on 6/11/19.
 */

public class SplashScreen extends AppCompatActivity {
    ProgressBar prgLoading;
    int progress = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        prgLoading = findViewById(R.id.prgLoading);
        prgLoading.setProgress(progress);

        new Loading().execute();
    }


    public class Loading extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            while (progress < 100) {
                try {
                    Thread.sleep(1000);
                    progress += 100;
                    prgLoading.setProgress(progress);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            Intent i = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(i);
        }
    }


}
