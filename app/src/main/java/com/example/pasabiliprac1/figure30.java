package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class figure30 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure30);
    }

    protected void onStart() {
        super.onStart();
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(getApplication(), figure29.class);
                startActivity(register);
            }
        });

        Button haveaccountbtn = findViewById(R.id.haveaccountbtn);
        haveaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haveaccountbtn = new Intent(getApplication(), figure29.class);
                startActivity(haveaccountbtn);
            }
        });
    }
}
