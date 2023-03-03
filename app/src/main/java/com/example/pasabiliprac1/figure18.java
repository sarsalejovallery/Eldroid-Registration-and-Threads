package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pasabiliprac1.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class figure18 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure18);
    }

    protected void onStart() {
        super.onStart();
        Button hireNowBtn = findViewById(R.id.hireNowBtn);
        hireNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hireNowBtn = new Intent(getApplication(), figure20.class);
                startActivity(hireNowBtn);
            }
        });
    }


}
