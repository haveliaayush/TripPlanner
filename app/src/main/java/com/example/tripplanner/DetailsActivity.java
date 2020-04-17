package com.example.tripplanner;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DetailsActivity extends AppCompatActivity {

    Button register;
    EditText dob, contact, name;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        register = findViewById(R.id.register);
        dob = findViewById(R.id.dob);
        contact = findViewById(R.id.contact);
        name = findViewById(R.id.name);

        dob.setInputType(0);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal =Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(DetailsActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar,dateSetListener,year,month,day);
                dialog.show();

            }
        });
        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                String Date=i2+"/"+i1+"/"+i;
                dob.setText(Date);
            }
        };

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, MainActivity.class));
            }
        });
    }
}
