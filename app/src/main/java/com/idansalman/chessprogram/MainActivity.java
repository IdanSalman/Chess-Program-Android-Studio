package com.idansalman.chessprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogIn,btnSignUp,btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogIn=findViewById(R.id.btnLogIn);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnPlay=findViewById(R.id.btnPlay);
        btnSignUp.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnLogIn){
            Intent go=new Intent(this,LogIn.class);
            startActivity(go);
        }
        if(v==btnSignUp){
            Intent go=new Intent(this,SignUp.class);
            startActivity(go);
        }
        if(v==btnPlay){
            Intent go=new Intent(this,Play.class);
            startActivity(go);
        }
    }
}