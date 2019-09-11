package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    private String litanije;
    private TextView naslov,text;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar
        Intent intent = getIntent();

        naslov=findViewById(R.id.naslovLitanija);
        text=findViewById(R.id.tekstLitanija);
        text.setMovementMethod(new ScrollingMovementMethod());

        exit=findViewById(R.id.litanijeExit);

        exit.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Main2Activity.this, Litanije.class);
            startActivity(mainIntent);
            finish();
        });

        litanije = intent.getStringExtra("litanije");

        if(litanije.equals("duhSvetiI")){
            naslov.setText("Litanije Duhu Svetome I");
            text.setText(R.string.litanijeDuhuSvetomI);
        }

        if(litanije.equals("duhSvetiII")){
            naslov.setText("Litanije Duhu Svetome II");
            text.setText(R.string.litanijeDuhuSvetomII);
        }

        if(litanije.equals("mihael")){
            naslov.setText("Litanije sv. Mihaelu Arkanđelu");
            text.setText(R.string.miheal);
        }

        if(litanije.equals("rita")){
            naslov.setText("Litanije sv.Rite");
            text.setText(R.string.litanijeSvRite);
        }

        if(litanije.equals("josip")){
            naslov.setText("Litanije sv.Josipa");
            text.setText(R.string.litanijeSvJosipa);
        }

        if(litanije.equals("majka")){
            naslov.setText("Litanije Majke Božje");
            text.setText(R.string.litanijeMarije);
        }

        if(litanije.equals("krv")){
            naslov.setText("Litanije Krvi Kristovoj");
            text.setText(R.string.litanijeKrviKristovoj);
        }


    }
}
