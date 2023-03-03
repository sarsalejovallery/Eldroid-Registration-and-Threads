package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure36 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure36);
    }

    protected void onStart() {
        super.onStart();
        Button acceptJobBtn = findViewById(R.id.acceptJobBtn);
        acceptJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acceptJobBtn = new Intent(getApplication(), figure37.class);
                startActivity(acceptJobBtn);
            }
        });
    }
}
