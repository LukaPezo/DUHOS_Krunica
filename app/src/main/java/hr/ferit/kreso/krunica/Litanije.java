package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class Litanije extends AppCompatActivity {

    private RadioButton duhSvetiI,duhSvetiII,mihael,rita,josip,majka,krv;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litanije);

        duhSvetiI=findViewById(R.id.litanijeDuhuSvetomeI);
        duhSvetiII=findViewById(R.id.litanijeDuhuSvetomeII);
        mihael=findViewById(R.id.litanijeMihaelu);
        rita=findViewById(R.id.litanijeRiti);
        josip=findViewById(R.id.litanijeJosipu);
        majka=findViewById(R.id.litanijeMajci);
        krv=findViewById(R.id.litanijeKrvi);


        exit=findViewById(R.id.litanijeExit2);

        exit.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, StartingPageActivity.class);
            startActivity(mainIntent);
            finish();
        });

        duhSvetiI.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","duhSvetiI");
            startActivity(mainIntent);
            finish();
        });

        duhSvetiII.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","duhSvetiII");
            startActivity(mainIntent);
            finish();
        });

        mihael.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","mihael");
            startActivity(mainIntent);
            finish();
        });

        rita.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","rita");
            startActivity(mainIntent);
            finish();
        });

        josip.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","josip");
            startActivity(mainIntent);
            finish();
        });

        majka.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","majka");
            startActivity(mainIntent);
            finish();
        });

        krv.setOnClickListener(v -> {
            Intent mainIntent = new Intent(Litanije.this, Main2Activity.class);
            mainIntent.putExtra("litanije","krv");
            startActivity(mainIntent);
            finish();
        });




    }


}
