package com.example.pasabiliprac1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class figure7 extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    //ELDROID CODES
    final String TAG = "FIRESTORE";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText username, password, email, firstname, lastname, address, confirmPass;
    Button registerBtn;
    TextView passwordMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figure7);
        db = FirebaseFirestore.getInstance();

        registerBtn = findViewById(R.id.register);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPass);
        passwordMatch = findViewById(R.id.passwordMatch);

        email.addTextChangedListener(registerTextWatcher);
        username.addTextChangedListener(registerTextWatcher);
        firstname.addTextChangedListener(registerTextWatcher);
        lastname.addTextChangedListener(registerTextWatcher);
        address.addTextChangedListener(registerTextWatcher);
        password.addTextChangedListener(registerTextWatcher);

        confirmPass.addTextChangedListener(registerTextWatcher);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  emailInput = email.getText().toString();
                String  usernameInput = username.getText().toString();
                String  fNameInput = firstname.getText().toString();
                String  lNameInput = lastname.getText().toString();
                String  addressInput = address.getText().toString();
                String  passwordInput = password.getText().toString();

                //if(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !emailInput.isEmpty() && !fNameInput.isEmpty()
                //&& !lNameInput.isEmpty() && !addressInput.isEmpty())
                //{

                db.collection("users")
                        .document(emailInput)
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String queriedEmails = documentSnapshot.getString("Email");
                                Log.d("Firestore", "Data read from Firestore: " + documentSnapshot.getData());

                                if(queriedEmails == null){
                                    addUser(emailInput, usernameInput, fNameInput, lNameInput, addressInput, passwordInput);
                                }
                                else{
                                    Log.d(TAG, "DocumentSnapshot added with ID: " + username);
                                    Toast.makeText(figure7.this,"Email ALREADY exists!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("Firestore", "Error reading data from Firestore: " + e.getMessage());
                            }
                        });



                //}
                //else
                //{
                    //Toast.makeText(figure7.this,"Please make sure there are no empty fields", Toast.LENGTH_SHORT).show();
                //}


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
            String usernameInput = username.getText().toString().trim();
            String firstnameInput = firstname.getText().toString().trim();
            String lastnameInput = lastname.getText().toString().trim();
            String addressInput = address.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            registerBtn.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !emailInput.isEmpty() && !firstnameInput.isEmpty()
                    && !lastnameInput.isEmpty() && !addressInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!password.getText().toString().equals(confirmPass.getText().toString())){
                passwordMatch.setVisibility(View.VISIBLE);
                registerBtn.setEnabled(false);
            }else
            {
                passwordMatch.setVisibility(View.INVISIBLE);
            }
        }
    };

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }




    public void addUser(String email, String username, String firstname, String lastname, String address, String password)
    {

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Email", email);
        user.put("Username", username);
        user.put("First Name", firstname);
        user.put("Last Name", lastname);
        user.put("Address", address);
        user.put("Password", password);

        // Add a new document with a generated ID
        db.collection("users").document(email)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + username);
                        Toast.makeText(figure7.this,"Registration Successful!", Toast.LENGTH_SHORT).show();
                        clearForm((ViewGroup) findViewById(R.id.registrationView));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(figure7.this,"Error adding user " + e, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Error adding document", e);
                    }
                });
    }


    protected void onStart() {
        super.onStart();


        Button haveaccountbtn = findViewById(R.id.haveaccountbtn);
        haveaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haveaccountbtn = new Intent(getApplication(), figure6.class);
                startActivity(haveaccountbtn);
            }
        });
    }
}
