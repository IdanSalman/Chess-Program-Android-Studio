package com.idansalman.chessprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.idansalman.chessprogram.Classes.User;

public class
SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText etFName,etLName,etPhone,etEmail,etPassword;

    Button btnSgnUp;

    Spinner spCity;
    String fName,lName, phone, email, password;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        init_views();


        btnSgnUp.setOnClickListener(this);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        mAuth = FirebaseAuth.getInstance();

    }

    private void init_views(){
        btnSgnUp=findViewById(R.id.btnSgnUp);
        etFName=findViewById(R.id.etFName);
        etLName=findViewById(R.id.etLName);
        etPhone=findViewById(R.id.etPhone);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

    }

    @Override
    public void onClick(View v) {
        fName=etFName.getText().toString();
        lName=etLName.getText().toString();
        phone=etPhone.getText().toString();
        email=etEmail.getText().toString();
        password=etPassword.getText().toString();



        //check if registration is valid
        Boolean isValid=true;
        if (fName.length()<2){
            Toast.makeText(SignUp.this,"שם פרטי קצר מדי", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (lName.length()<2){
            Toast.makeText(SignUp.this,"שם משפחה קצר מדי", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (phone.length()<9||phone.length()>10){
            Toast.makeText(SignUp.this,"מספר הטלפון לא תקין", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if (!email.contains("@")){
            Toast.makeText(SignUp.this,"כתובת האימייל לא תקינה", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if(password.length()<6){
            Toast.makeText(SignUp.this,"הסיסמה קצרה מדי", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if(password.length()>20){
            Toast.makeText(SignUp.this,"הסיסמה ארוכה מדי", Toast.LENGTH_LONG).show();
            isValid = false;
        }
        isValid=true;

        if (isValid==true){

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "createUserWithEmail:success");
                                FirebaseUser fireuser = mAuth.getCurrentUser();
                                User newUser=new User(fireuser.getUid(), fName, lName,phone,email,password);
                                myRef.child(fireuser.getUid()).setValue(newUser);
                                SharedPreferences.Editor editor = sharedpreferences.edit();

                                editor.putString("email", email);
                                editor.putString("password", password);

                                editor.commit();
                                Intent goLog=new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(goLog);


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
