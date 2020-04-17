package android.example.muthaigagolfclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profiles extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

    }

    public void Services(View view) {
        Intent servicesIntent = new Intent(Profiles.this, Services.class);
        startActivity(servicesIntent);
    }

    public void Location(View view) {
        Intent locationIntent = new Intent(Profiles.this, Location.class);
        startActivity(locationIntent);

    }
}
