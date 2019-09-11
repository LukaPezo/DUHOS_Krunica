package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Objects;

public class Otajstva extends AppCompatActivity {

    private RadioButton radosna,zalosna,slavna,svjetla;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otajstva);
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar

        radosna=findViewById(R.id.radosna);
        zalosna=findViewById(R.id.zalosna);
        slavna=findViewById(R.id.slavna);
        svjetla=findViewById(R.id.svjetla);

        exit=findViewById(R.id.vrata_button);

        exit.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Otajstva.this, Selector.class);
            startActivity(mainIntent);
            finish();
        });

        radosna.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Otajstva.this, MainActivity.class);
            mainIntent.putExtra("otajstvo","radosna");
            mainIntent.putExtra("koja_krunica","gospa");
            startActivity(mainIntent);
            finish();
        });
        zalosna.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Otajstva.this, MainActivity.class);
            mainIntent.putExtra("otajstvo","zalosna");
            mainIntent.putExtra("koja_krunica","gospa");
            startActivity(mainIntent);
            finish();
        });
        slavna.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Otajstva.this, MainActivity.class);
            mainIntent.putExtra("otajstvo","slavna");
            mainIntent.putExtra("koja_krunica","gospa");
            startActivity(mainIntent);
            finish();
        });
        svjetla.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Otajstva.this, MainActivity.class);
            mainIntent.putExtra("otajstvo","svjetla");
            mainIntent.putExtra("koja_krunica","gospa");
            startActivity(mainIntent);
            finish();
        });
    }
}
