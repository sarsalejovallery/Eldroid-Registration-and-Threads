package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure27 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure27);
    }

    protected void onStart() {
        super.onStart();
        Button payNowBtn = findViewById(R.id.payNowBtn);
        payNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payNowBtn = new Intent(getApplication(), figure28.class);
                startActivity(payNowBtn);
            }
        });
    }
}
