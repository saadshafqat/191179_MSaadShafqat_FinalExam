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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity {

EditText txt,txt1,txt2;
Button btn;
    Boolean check2;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txt=findViewById(R.id.name);
        txt1=findViewById(R.id.email);
        txt2=findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        btn=findViewById(R.id.regbtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txt.getText().toString().trim();
                String email=txt1.getText().toString().trim();
                String password=txt2.getText().toString().trim();

                Boolean check=true;

                if(TextUtils.isEmpty(name)){
                    txt.setError("Must Enter Name!!!");
                    check=false;
                }
                if(TextUtils.isEmpty(email)){
                    txt.setError("Must Enter Email!!!");
                    check=false;
                }
                if(TextUtils.isEmpty(password)){
                    txt.setError("Must Enter Name!!!");
                    check=false;
                }
                if(check==true){
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(Registration.this, "User Registered on Firebase", Toast.LENGTH_SHORT).show();
                            Boolean check2=true;

                        }


                    });
                    Intent intent=new Intent(Registration.this,Login.class);
                    startActivity(intent);

                }

            }
        });
    }
}