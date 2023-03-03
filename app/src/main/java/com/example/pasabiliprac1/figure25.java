package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure25 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure25);
    }

    protected void onStart() {
        super.onStart();
        Button payBtn = findViewById(R.id.payBtn);
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payBtn = new Intent(getApplication(), figure26.class);
                startActivity(payBtn);
            }
        });
    }
}
