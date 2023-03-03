package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure15 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure15);
    }

    protected void onStart() {
        super.onStart();
        Button makeARequestBtn = findViewById(R.id.makeARequestBtn);
        makeARequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent makeARequestBtn = new Intent(getApplication(), figure22.class);
                startActivity(makeARequestBtn);
            }
        });
    }
}
