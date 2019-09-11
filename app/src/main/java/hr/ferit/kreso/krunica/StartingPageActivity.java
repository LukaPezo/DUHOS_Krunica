package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class StartingPageActivity extends AppCompatActivity implements Dialog.Call_dialogListener {

    private Button molitva,exit,kalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar
        kalendar=findViewById(R.id.kalendar_button);

        molitva=findViewById(R.id.molitva_button);

        exit=findViewById(R.id.izađi_button);

        exit.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });

        molitva.setOnClickListener(v -> {
            openDialog();
        });
        kalendar.setOnClickListener(v -> {
            openCalendar();
        });
    }

    private void openCalendar() {
        Intent intentCalendar = new Intent(StartingPageActivity.this, Calendar.class);
        startActivity(intentCalendar);
    }

    @Override
    public void applySelected(String data) {
        if (data.matches("Krunica")) {
            Intent mainIntent = new Intent(StartingPageActivity.this, Selector.class);
            startActivity(mainIntent);
            finish();
        }
        if (data.matches("Litanije")){
            Intent mainIntent = new Intent(StartingPageActivity.this, Litanije.class);
            startActivity(mainIntent);
            finish();
        }
    }

    private void openDialog() {
        Dialog call_dialog = new Dialog();
        call_dialog.setCancelable(true);
        call_dialog.show(getSupportFragmentManager(), "tag");
    }

}
