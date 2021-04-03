package com.example.bitirmeprojesidemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String typeOfClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etName= (EditText)findViewById(R.id.etName);
        final EditText etUsername= (EditText)findViewById(R.id.etUsername);
        final EditText etEmail= (EditText)findViewById(R.id.etEmail);
        final EditText etPassword= (EditText)findViewById(R.id.etPassword);
        final EditText etConfirmPassword= (EditText)findViewById(R.id.etConfirmPassword);
        final EditText etPhone= (EditText)findViewById(R.id.etPhone);
        final EditText etAddress= (EditText)findViewById(R.id.etAddress);
        final Button bRegister= (Button)findViewById(R.id.bRegister);
        final Button bBack= (Button)findViewById(R.id.bBack);
        final TextView tvBirthDate= (TextView) findViewById(R.id.tvBirthDate);
        final TextView tvBirth= (TextView) findViewById(R.id.tvBirth);
        final Spinner spinner1= findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.title, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || tvBirthDate.getText().toString().isEmpty() || etConfirmPassword.getText().toString().isEmpty()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("İşaretli(*) alanların doldurulması zorunludur.")
                            .setNegativeButton("Tekrar Dene",null)
                            .create()
                            .show();
                }
                else {
                    if(!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
                        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("Şifrenizi kontrol ediniz.")
                                .setNegativeButton("Tekrar Dene",null)
                                .create()
                                .show();
                    }else if(!etEmail.getText().toString().contains("@gmail.com")){
                        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("Lütfen geçerli bir e-mail hesabı giriniz.")
                                .setNegativeButton("Tekrar Dene",null)
                                .create()
                                .show();
                    }else{
                        Intent registerIntent=new Intent(RegisterActivity.this,LoginActivity.class);
                        RegisterActivity.this.startActivity(registerIntent);
                    }

                }

            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(RegisterActivity.this,LoginActivity.class);
                RegisterActivity.this.startActivity(backIntent);
            }
        });

        tvBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog= new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                String date= month + "/" + dayOfMonth + "/" + year;
                tvBirthDate.setText(date);
            }
        };


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        typeOfClient=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}