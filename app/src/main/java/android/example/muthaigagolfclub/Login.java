package android.example.muthaigagolfclub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN=
            Pattern.compile("^"+
                    "(?=.*[0-9])"+                  //at least 1 digit
                    "(?=.*[a-z])"+                  //at least 1 lower case letter
                    "(?=.*[A-Z])"+                  //at least 1 upper case letter
                    //"(?=.*[a-zA-Z]"+                //any letter
                    "(?=.*[@#$%^&+=])"+             //at least 1 special character
                    "(?=\\S+$)"+                    //no white spaces
                    ".{6,}"+                        //at least 6 characters
                    "$");


    EditText etEmail,etPass;
    Button btnLogin;
    TextView tvSignup;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_languages);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass;

                email = etEmail.getText().toString();
                pass = etPass.getText().toString();

                if (email.equals("")){
                    Toast.makeText(Login.this, "Email Required", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etEmail.setError("Please enter a valid email");
                    return;
                }else if (pass.equals("")){
                    Toast.makeText(Login.this, "Password Required", Toast.LENGTH_SHORT).show();
                }
                else if(!PASSWORD_PATTERN.matcher(pass).matches()){
                    etPass.setError("Password too weak");
                    return;
                }else{
                    //Authentication
                    startActivity(new Intent(getApplicationContext(), Profiles.class));
                }
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login. this,Signup.class);
                startActivity(i);
                finish();
            }
        });
    }
}



