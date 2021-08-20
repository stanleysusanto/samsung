package me.ltxom.patientapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import me.ltxom.patientapp.entity.Patient;
import me.ltxom.patientapp.service.PatientService;

public class QRActivity extends AppCompatActivity {
    ZBarView mQRCodeView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        mQRCodeView = findViewById(R.id.zbarview);
        mQRCodeView.changeToScanQRCodeStyle();
        final Activity temp = this;
        mQRCodeView.setDelegate(new QRCodeView.Delegate() {
            @Override
            public void onScanQRCodeSuccess(String result) {
                if (!result.contains("patientid")) {
                    Toast.makeText(temp, "Not a valid patient QR code", Toast.LENGTH_SHORT).show();
                } else {
                    String patientid = result.split(":")[1];
                    PatientService patientService = new PatientService();
                    Patient patient = patientService.findPatient(patientid);

                    Toast.makeText(temp, "Patient: " + patient.firstName + " " + patient.lastName, Toast.LENGTH_LONG).show();
                    Profile.patientid = patientid;
                    Intent i1 = new Intent(QRActivity.this, Profile.class);
                    startActivity(i1);
                }
                vibrate();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mQRCodeView.startSpot();
                    }
                }, 1000);
            }

            @Override
            public void onCameraAmbientBrightnessChanged(boolean isDark) {

            }

            @Override
            public void onScanQRCodeOpenCameraError() {
                Toast.makeText(temp, "Camera Error!", Toast.LENGTH_SHORT).show();
            }
        });
        mQRCodeView.startSpot();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();

        mQRCodeView.showScanRect();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

}
