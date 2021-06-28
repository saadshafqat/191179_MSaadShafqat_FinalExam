package com.example.a191179_msaadshafqat_mclabfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
Button newbtn;
EditText txt,txt1;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newbtn=findViewById(R.id.logbtn);
        txt=findViewById(R.id.logemail);
        txt1=findViewById(R.id.logpassword);
        auth = FirebaseAuth.getInstance();
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txt.getText().toString().trim();
                String password=txt1.getText().toString().trim();


                Boolean check=true;

                if(TextUtils.isEmpty(email)){
                    txt.setError("Must Enter Email!!!");
                    check=false;
                }
                if(TextUtils.isEmpty(password)){
                    txt1.setError("Must Enter Password!!!");
                    check=false;
                }
                if (check==true){
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, Dashboard.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(Login.this, "Wrong Pass or Email", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}