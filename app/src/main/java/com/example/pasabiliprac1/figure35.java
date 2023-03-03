package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure35 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure35);
    }

    protected void onStart() {
        super.onStart();
        Button viewBtn = findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewBtn = new Intent(getApplication(), figure36.class);
                startActivity(viewBtn);
            }
        });
    }
}
