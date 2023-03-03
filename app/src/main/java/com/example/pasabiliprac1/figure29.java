package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class figure29 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure29);
    }

    protected void onStart() {
        super.onStart();
        Button signInAsItinerantBtn = findViewById(R.id.signInAsItinerantBtn);
        signInAsItinerantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInAsItinerantBtn = new Intent(getApplication(), figure31.class);
                startActivity(signInAsItinerantBtn);
            }
        });

        TextView createItinerantAcct = findViewById(R.id.createItinerantAcct);
        createItinerantAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createItinerantAcct = new Intent(getApplication(), figure30.class);
                startActivity(createItinerantAcct);
            }
        });

        Button loginCustomerBtn = findViewById(R.id.loginCustomerBtn);
        loginCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginCustomerBtn = new Intent(getApplication(), figure6.class);
                startActivity(loginCustomerBtn);
            }
        });
    }
}
