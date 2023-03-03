package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.pasabiliprac1.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class figure6 extends AppCompatActivity {

    final String TAG = "FIRESTORE";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText email, password;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure6);
        db = FirebaseFirestore.getInstance();

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        signInBtn = findViewById(R.id.signinbtn);

        email.addTextChangedListener(registerTextWatcher);
        password.addTextChangedListener(registerTextWatcher);



        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();


                db.collection("users")
                        .document(emailInput)
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String queriedEmails = documentSnapshot.getString("Email");
                                String queriedPasswords = documentSnapshot.getString("Password");
                                Log.d("Firestore", "Data read from Firestore: " + documentSnapshot.getData());
                                Log.d("Firestore", "password: " + queriedPasswords);
                                Log.d("Firestore", "password input from login: " + passwordInput);

                                if(queriedEmails == null){
                                    Toast.makeText(figure6.this,"Invalid Credentials!", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    if (passwordInput.equals(queriedPasswords))
                                    {
                                        Intent signInBtn = new Intent(getApplication(), figure8.class);
                                        startActivity(signInBtn);

                                    }
                                    else
                                    {
                                        Toast.makeText(figure6.this,"Invalid Password!", Toast.LENGTH_SHORT).show();
                                    }


                                }

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("Firestore", "Error reading data from Firestore: " + e.getMessage());
                            }
                        });
            }
        });

    }

    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            signInBtn.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    protected void onStart() {
        super.onStart();

        //signup button
        Button signupbtn = findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupbtn = new Intent(getApplication(), figure7.class);
                startActivity(signupbtn);
            }
        });

        //login as traveler button
        Button logintravelerbtn = findViewById(R.id.logintravelerbtn);
        logintravelerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logintravelerbtn = new Intent(getApplication(), figure29.class);
                startActivity(logintravelerbtn);
            }
        });
    }
}
