package com.example.bitirmeprojesidemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etUsername= (EditText)findViewById(R.id.etUsername);
        final EditText etPassword= (EditText)findViewById(R.id.etPassword);
        final Button bLogin= (Button)findViewById(R.id.bLogin);
        final TextView registerLink=(TextView)findViewById(R.id.tvRegisterHere);
        final RadioGroup rgType = (RadioGroup)findViewById(R.id.rgType);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = rgType.getCheckedRadioButtonId(); // Doctor ya da patient butonunu kontrol etmek icin
                // Asagida ilgili alanlarin doldurulup doldurulmadigi kontrol ediliyor.
                if(etUsername.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || checkedId == -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Please Fill The Blanks")
                            .setNegativeButton("Try Again", null)
                            .create()
                            .show();
                }else{
                    if(checkedId == R.id.rbDoctor){
                        // Burada server ile baglanti kurulacak ve eger girilen bilgilere ait kisi bulunduysa doctor sayfasina yonlendirilecek.
                        // Eger yanlis bilgilerse uyari verilecek.
                        Intent loginIntent = new Intent(LoginActivity.this, DoctorAreaActivity.class);
                        LoginActivity.this.startActivity(loginIntent);
                    }
                    else {
                        // Burada server ile baglanti kurulacak ve eger girilen bilgilere ait kisi bulunduysa patient sayfasina yonlendirilecek.
                        // Eger yanlis bilgilerse uyari verilecek.
                        Intent loginIntent = new Intent(LoginActivity.this, PatientAreaActivity.class);
                        LoginActivity.this.startActivity(loginIntent);
                    }
                }
            }
        });


    }

}