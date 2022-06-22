package com.idansalman.chessprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idansalman.chessprogram.Classes.User;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="loginToFireBase" ;
    TextView tvLog;
    EditText etEmail2, etPass2;
    Button btnLog;

    String email2, pass2;
    private FirebaseAuth mAuth;
    String admin="edenkario@gmail.com";

    public static final String MyPREFERENCES = "MyPrefs" ;



    SharedPreferences sharedpreferences;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public  static User theUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth=FirebaseAuth.getInstance();


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        init_views();
        database=FirebaseDatabase.getInstance();
        email2=sharedpreferences.getString("email","");
        pass2=sharedpreferences.getString("password","");
        etEmail2.setText(email2);
        etPass2.setText(pass2);
        btnLog.setOnClickListener(this);
    }

    private void init_views() {
        btnLog=findViewById(R.id.btnLog);
        etEmail2=findViewById(R.id.etEmail2);
        etPass2=findViewById(R.id.etPassword2);
    }


    @Override
    public void onClick(View v) {
        email2=etEmail2.getText().toString();
        pass2=etPass2.getText().toString();

        mAuth.signInWithEmailAndPassword(email2, pass2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            final FirebaseUser user = mAuth.getCurrentUser();

                            myRef = database.getReference("Users").child(user.getUid());


                            myRef.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {


                                    theUser=dataSnapshot.getValue(User.class);





                                    Toast.makeText(LogIn.this, "טוען...",
                                            Toast.LENGTH_LONG).show();

                                    SharedPreferences.Editor editor = sharedpreferences.edit();

                                    editor.putString("email", email2);
                                    editor.putString("password", pass2);

                                    editor.commit();


//                                    if (email2.equals(admin)) {
//                                        Intent goLog = new Intent(getApplicationContext(), AdminPage.class);
//                                        startActivity(goLog);
//
//                                    } else {
                                        Intent goLog = new Intent(getApplicationContext(), Play.class);
                                        startActivity(goLog);
                                    }


//                                }


                                @Override
                                public void onCancelled(DatabaseError error) {
                                    // Failed to read value
                                    //  Log.w(TAG, "Failed to read value.", error.toException());
                                }
                            });
                        }

                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }



}
