package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure10 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure10);
    }

    protected void onStart() {
        super.onStart();
        Button customerVerification = findViewById(R.id.customerVerification);
        customerVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customerVerification = new Intent(getApplication(), figure11.class);
                startActivity(customerVerification);
            }
        });
    }
}
