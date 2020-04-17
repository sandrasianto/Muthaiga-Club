package android.example.muthaigagolfclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
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

    EditText etEmail,etPassword,etConfirmPassword,etFirstName,etLastName;
    Button btnSignup;

    String HttpUrl = "https://tetraethyl-prison.000webhostapp.com/12345_golfclub/UserDatabase.php";
    String Url ="https://files.000webhost.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);


        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname,lastname,email,pass,conPass;

                firstname = etFirstName.getText().toString();
                lastname = etLastName.getText().toString();
                email = etEmail.getText().toString();
                pass = etPassword.getText().toString();
                conPass = etConfirmPassword.getText().toString();

                if (firstname.equals("")){
                    Toast.makeText(Signup.this, "FirstName Required", Toast.LENGTH_SHORT).show();
                }
                else if (lastname.equals("")){
                    Toast.makeText(Signup.this, "LastName Required", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals("")){
                    Toast.makeText(Signup.this, "Email Required", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Please enter a valid email");
                    return;
                }else if (pass.equals("")){
                    Toast.makeText(Signup.this, "Password Required", Toast.LENGTH_SHORT).show();
                }
                else if(!PASSWORD_PATTERN.matcher(pass).matches()) {
                    etPassword.setError("Password too weak");
                    return;
                }else if (conPass.equals("")){
                    Toast.makeText(Signup.this, "Confirm Password Required", Toast.LENGTH_SHORT).show();
                }
                else if (!conPass.equals("pass")){
                    Toast.makeText(Signup.this, "Confirm Password Mismatch", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Authentication
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
            }
        });
    }
}
