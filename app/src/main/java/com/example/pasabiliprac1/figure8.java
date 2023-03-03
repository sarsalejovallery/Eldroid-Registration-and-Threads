package com.example.pasabiliprac1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class figure8 extends AppCompatActivity {
    private volatile boolean stopThreadFlag = false;
    final String TAG = "FIRESTORE";
    private Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure8);
        Log.d("THREAD ACTIVITY", "ON CREATE");

    }


    public void startThread(int seconds) {
        GraduationRunnable runnable = new GraduationRunnable(10);
        new Thread(runnable).start();
    }

    public void stopThread() {
        stopThreadFlag = true;
    }

    class GraduationRunnable implements Runnable
    {
        int seconds;

        //Non-Default Constructor
        GraduationRunnable(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for(int i =0; i< seconds; i++){
                if(stopThreadFlag)
                {
                    return;
                }
                if(i == 8) {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            openDialog();
                            Log.d(TAG, "ALREADY 5 MINUTES: ");
                        }
                    });

                }
                Log.d("THREAD ACTIVITY", "Start Thread : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void openDialog()
    {
        DialogExample dialog = new DialogExample();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }
    protected void onStart() {
        super.onStart();
        Log.d("THREAD ACTIVITY", "ON START");


        Button addMoneyBtn = findViewById(R.id.addMoneyBtn);
        addMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addMoneyBtn = new Intent(getApplication(), figure12.class);
                startActivity(addMoneyBtn);
            }
        });

        ImageView searchItinerantBtn = findViewById(R.id.searchItinerantBtn);
        searchItinerantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchItinerantBtn = new Intent(getApplication(), figure13.class);
                startActivity(searchItinerantBtn);
            }
        });

        ImageView requestAssistanceBtn = findViewById(R.id.requestAssistanceBtn);
        requestAssistanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent requestAssistanceBtn = new Intent(getApplication(), figure15.class);
                startActivity(requestAssistanceBtn);
            }
        });

        ImageView pendingsBtn = findViewById(R.id.pendingsBtn);
        pendingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pendingsBtn = new Intent(getApplication(), figure22.class);
                startActivity(pendingsBtn);
            }
        });

        Button exploreBtn = findViewById(R.id.exploreBtn);
        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exploreBtn = new Intent(getApplication(), figure16.class);
                startActivity(exploreBtn);
            }
        });

        Button hireItinerantBtn1 = findViewById(R.id.hireItinerantBtn1);
        hireItinerantBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hireItinerantBtn1 = new Intent(getApplication(), figure19.class);
                startActivity(hireItinerantBtn1);
            }
        });


    }

    public void onResume()
    {
        super.onResume();
        startThread(0);
        Log.d("THREAD ACTIVITY", "ON RESUME");
    }

    public void onPause(){
        super.onPause();
        stopThread();

        Log.d("THREAD ACTIVITY", "ON PAUSE");
    }

    public void onRestart(){
        super.onRestart();
        Log.d("THREAD ACTIVITY", "ON RESTART");
    }

    public void onStop(){
        super.onStop();
        Log.d("THREAD ACTIVITY", "ON STOP");
    }

}
