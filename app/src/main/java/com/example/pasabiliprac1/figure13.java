package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure13 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure13);
    }

    protected void onStart() {
        super.onStart();
        Button hireNowButton = findViewById(R.id.hireNowButton);
        hireNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hireNowButton = new Intent(getApplication(), figure14.class);
                startActivity(hireNowButton);
            }
        });
    }
}
