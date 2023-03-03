package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class figure31 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure31);
    }

    protected void onStart() {
        super.onStart();

        ImageView searchRequestsBtn = findViewById(R.id.searchRequestsBtn);
        searchRequestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchRequestsBtn = new Intent(getApplication(), figure35.class);
                startActivity(searchRequestsBtn);
            }
        });

        ImageView pendingsBtn = findViewById(R.id.pendingsBtn);
        pendingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pendingsBtn = new Intent(getApplication(), figure37.class);
                startActivity(pendingsBtn);
            }
        });

    }
}
