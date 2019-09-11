package hr.ferit.kreso.krunica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class FlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        //hide status/notification bar (fullscreen)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar

        setContentView(R.layout.activity_flash_screen);

        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(FlashScreenActivity.this, StartingPageActivity.class);
            startActivity(mainIntent);
            finish();
        }, 2000);
    }
}

