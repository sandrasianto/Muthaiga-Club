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
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonsecond = findViewById(R.id.button_second);


        buttonsecond.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent int1 = new Intent(MainActivity.this,Login.class);
                startActivity(int1);
            }
        });



    }

    public void Number(View view) {
        Intent numberIntent = new Intent(MainActivity.this, Number.class);
        startActivity(numberIntent);
    }

    public void Email(View view) {
        Intent emailIntent = new Intent(MainActivity.this, ContactsContract.CommonDataKinds.Email.class);
        startActivity(emailIntent);
    }

    public void MultipleLanguages(View view) {
        Intent multiplelanguagesIntent = new Intent(MainActivity.this, MultipleLanguages.class);
        startActivity(multiplelanguagesIntent);
    }
}
