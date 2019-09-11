package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Objects;

public class Selector extends AppCompatActivity {

    private RadioButton gospa,josip, srceIsusovo,malaMarija,milosrdje;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar

        gospa=findViewById(R.id.gospinaKrunica);
        josip=findViewById(R.id.svJosip);
        srceIsusovo=findViewById(R.id.srceIsusovo);
        malaMarija=findViewById(R.id.malaMarija);
        milosrdje=findViewById(R.id.milosrdje);

        exit=findViewById(R.id.door_button);

        exit.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, StartingPageActivity.class);
            startActivity(mainIntent);
            finish();
        });


        gospa.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, Otajstva.class);
            startActivity(mainIntent);
            finish();
        });
        josip.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, MainActivity.class);
            mainIntent.putExtra("koja_krunica","josip");
            startActivity(mainIntent);
            finish();
        });
        srceIsusovo.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, MainActivity.class);
            mainIntent.putExtra("koja_krunica","srceIsusovo");

            startActivity(mainIntent);
            finish();
        });
        malaMarija.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, MainActivity.class);
            mainIntent.putExtra("koja_krunica","malaMarija");
            startActivity(mainIntent);
            finish();
        });
        milosrdje.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Selector.this, MainActivity.class);
            mainIntent.putExtra("koja_krunica","milosrdje");
            startActivity(mainIntent);
            finish();
        });
    }
}
