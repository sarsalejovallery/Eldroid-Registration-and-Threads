package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure17 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure17);
    }

    protected void onStart() {
        super.onStart();
        Button pardoHireBtn = findViewById(R.id.pardoHireBtn);
        pardoHireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pardoHireBtn = new Intent(getApplication(), figure19.class);
                startActivity(pardoHireBtn);
            }
        });
    }

}
