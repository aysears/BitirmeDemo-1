package com.example.bitirmeprojesidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PatientAreaActivity extends AppCompatActivity {

    // Bu bilgiler giris yapan kullanicinin serverdan alinan bilgileri olacak.
    String User_Name = "Ayla";
    String User_Mail = "ayla@gmail.com";
    String User_BirthDate = "23.10.1989";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_area);
        final ListView lvDevices = (ListView) findViewById(R.id.lvDevices);

        final TextView name = (TextView) findViewById(R.id.tvName);
        final TextView email = (TextView) findViewById(R.id.tvMail);
        final TextView birthDate = (TextView) findViewById(R.id.tvBirthDate);

        final Button btnOnOff = (Button) findViewById(R.id.bOnOff);
        final Button btnEnDis = (Button) findViewById(R.id.bEnDis);
        final Button btnDiscover = (Button) findViewById(R.id.bDiscover);
        final Button btnGetData = (Button) findViewById(R.id.bGetData);

        // Alinan bilgiler burada hasta sayfasina yazdirilicak.
        name.setText(User_Name);
        email.setText(User_Mail);
        birthDate.setText(User_BirthDate);

        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buraya bluetooth acma kodu gelecek.
            }
        });

        btnEnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buraya etraftaki cihazlar icin gorunurluk kodu gelecek.
            }
        });

        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buraya etraftaki ble cihazlarini arama kodu gelecek.
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buraya ble cihazindan data alma ve bu datalari server a gonderme kodu gelecek.

            }
        });
    }
}