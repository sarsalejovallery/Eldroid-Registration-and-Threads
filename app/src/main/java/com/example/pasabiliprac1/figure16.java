package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure16 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure16);
    }

    protected void onStart() {
        super.onStart();
        Button pardoViewBtn = findViewById(R.id.pardoViewBtn);
        pardoViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pardoViewBtn = new Intent(getApplication(), figure17.class);
                startActivity(pardoViewBtn);
            }
        });
    }
}
