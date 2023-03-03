package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class figure26 extends AppCompatActivity implements View.OnClickListener{
    TextView result;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonerase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure26);


        result = findViewById(R.id.result);
        assignID(button0, R.id.button_0);
        assignID(button1, R.id.button_1);
        assignID(button2, R.id.button_2);
        assignID(button3, R.id.button_3);
        assignID(button4, R.id.button_4);
        assignID(button5, R.id.button_5);
        assignID(button6, R.id.button_6);
        assignID(button7, R.id.button_7);
        assignID(button8, R.id.button_8);
        assignID(button9, R.id.button_9);
        assignID(buttonerase, R.id.erase);
    }
    void assignID(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String resultText = result.getText().toString();
        String dataToCalculate = result.getText().toString();


        if (buttonText.equals("C"))
        {
            dataToCalculate =dataToCalculate.substring(0, dataToCalculate.length()-1);
        }
        else
        {
            dataToCalculate = dataToCalculate + buttonText;
        }

        result.setText(dataToCalculate);
    }

    protected void onStart() {
        super.onStart();
        Button proceedBtn = findViewById(R.id.proceedBtn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceedBtn = new Intent(getApplication(), figure27.class);
                startActivity(proceedBtn);
            }
        });
    }
}
