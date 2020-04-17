package com.example.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button cont;
    EditText user, email, pass, cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cont = findViewById(R.id.register);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        cpass = findViewById(R.id.cpassword);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, DetailsActivity.class));
            }
        });
    }
}
