 package hr.ferit.kreso.krunica;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;



 public class MainActivity extends AppCompatActivity {

     private Button next, previous, exit;
     private TextView text, naslov;
     int brojac = -1, slika = 0;
     private String otajstvo, krunica;
     ArrayList<String> polje = new ArrayList<String>();


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Objects.requireNonNull(getSupportActionBar()).hide(); //hide app name bar

         brojac = -1;
         next = findViewById(R.id.button_next);
         previous = findViewById(R.id.button_previous);
         exit = findViewById(R.id.button_exit);

         naslov = findViewById(R.id.naslov);

         text = findViewById(R.id.text_molitva);
         text.setMovementMethod(new ScrollingMovementMethod());

         Intent intent = getIntent();
         otajstvo = intent.getStringExtra("otajstvo");
         krunica = intent.getStringExtra("koja_krunica");

         previous.setOnClickListener(v -> {
             text.scrollTo(0,0);

             if (krunica.equals("gospa")) {
                 slika--;
                 brojac--;
                 if (slika == -1)
                     slika++;
                 if (slika == 0) {
                     int resID = getResources().getIdentifier("krunica", "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 } else {
                     int resID = getResources().getIdentifier(polje.get(slika - 1), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 if (brojac == -2)
                     brojac++;
                 if (brojac == -1) {
                     text.setText(R.string.ZnakKriza);
                     naslov.setText("Znak Križa");
                 } else if (brojac == 0) {
                     text.setText(R.string.Vjerovanje);
                     naslov.setText("Vjerovanje");
                 } else if (brojac == 1 || brojac == 6 || brojac == 19 || brojac == 32 || brojac == 45 || brojac == 58) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče Naš");
                 } else if (brojac == 5 || brojac == 17 || brojac == 30 || brojac == 43 || brojac == 56 || brojac == 69) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 } else if (brojac == 18 || brojac == 31 || brojac == 44 || brojac == 57 || brojac == 70) {
                     text.setText(R.string.MojIsuse);
                     naslov.setText("O, moj Isuse...");
                 } else if (brojac == 2) {
                     String bold = " Koji neka nam umnoži vjeru.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 144, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 3) {
                     String bold = " Koji neka nam učvrsti ufanje.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 4) {
                     String bold = " Koji neka nam usavrši ljubav.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 157, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 161, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 35, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 67, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 153, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 53, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64 || brojac == 65 || brojac == 66 || brojac == 67 || brojac == 68) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 149, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 39, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 71) {
                     text.setText(R.string.ZdravoKraljice);
                     naslov.setText("Zdravo Kraljice");
                 } else if (brojac == 72) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             //////////

             if (krunica.equals("josip")) {
                     slika--;
                     brojac--;
                     if (slika == -1)
                         slika++;
                     if (slika == 0) {
                         int resID = getResources().getIdentifier("krunica", "drawable", getPackageName());
                         ImageView imageView = findViewById(R.id.krunica_image);
                         Drawable image = getResources().getDrawable(resID);
                         imageView.setImageDrawable(image);
                     } else {
                         int resID = getResources().getIdentifier(polje.get(slika - 1), "drawable", getPackageName());
                         ImageView imageView = findViewById(R.id.krunica_image);
                         Drawable image = getResources().getDrawable(resID);
                         imageView.setImageDrawable(image);
                     }
                     if (brojac == -2)
                         brojac++;
                     if (brojac == -1) {
                         text.setText(R.string.ZnakKriza);
                         naslov.setText("Znak Križa");
                     } else if (brojac == 0) {
                         text.setText(R.string.Vjerovanje);
                         naslov.setText("Vjerovanje");
                     } else if (brojac == 1 || brojac == 6 || brojac == 19 || brojac == 32 || brojac == 45 || brojac == 58) {
                         text.setText(R.string.OčeNaš);
                         naslov.setText("Oče Naš");
                     } else if (brojac == 5 || brojac == 17 || brojac == 30 || brojac == 43 || brojac == 56 || brojac == 69) {
                         text.setText(R.string.SlavaOcu);
                         naslov.setText("Slava Ocu");
                     } else if (brojac == 18 || brojac == 31 || brojac == 44 || brojac == 57 || brojac == 70) {
                         text.setText(R.string.MiliJosipe);
                         naslov.setText("O, mili, blagi,...");

                     } else if (brojac == 2) {
                         String bold = "koji neka nam umnoži vjeru. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 3) {
                         String bold = "koji neka nam učvrsti ufanje. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 4) {
                         String bold = "koji neka nam usavrši ljubav. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16) {
                         String bold = "kojeg si žarko volio. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29) {
                         String bold = "koji je tebe slušao i ljubio. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42) {
                         String bold = "za koga si marljivo radio. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55) {
                         String bold = "koji je tebe u poslu pomagao. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64 || brojac == 65 || brojac == 66 || brojac == 67 || brojac == 68) {
                         String bold = "koji je uza te bio kad si umirao. ";
                         String temp = getResources().getString(R.string.ZdravoJosipe);
                         temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Josipe");

                     } else if (brojac == 71) {
                         text.setText(R.string.BožeOče);
                         naslov.setText("Bože Oče...");
                     } else if (brojac == 72) {
                         Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                         Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                         startActivity(mainIntent);
                         finish();
                     }
             }

             if (krunica.equals("milosrdje")) {
                 slika--;
                 brojac--;
                 if(brojac==13)
                     slika=17;
                 if(brojac==24)
                     slika=30;
                 if(brojac==35)
                     slika=43;
                 if(brojac==46)
                     slika=56;
                 if(brojac==57)
                     slika=69;
                 if (slika == 0) {
                     int resID = getResources().getIdentifier("krunica", "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 } else {
                     int resID = getResources().getIdentifier(polje.get(slika - 1), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 if (brojac == -2)
                     brojac++;
                 if (brojac == -1) {
                     text.setText(R.string.ZnakKriza);
                     naslov.setText("Znak Križa");
                 } else if (brojac == 0) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče Naš");
                 } else if (brojac == 1) {
                     text.setText(R.string.ZdravoMarijo);
                     naslov.setText("Zdravo Marijo");

                 } else if (brojac == 2) {
                     text.setText(R.string.Vjerovanje);
                     naslov.setText("Vjerovanje");

                 } else if (brojac == 3 || brojac == 14 || brojac == 25 || brojac == 36 || brojac == 47) {
                     text.setText(R.string.VječniOče);
                     naslov.setText("Vječni Oče...");

                 } else if (brojac == 4 || brojac == 5 || brojac == 6 || brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 15 || brojac == 16 || brojac == 17 || brojac == 18 || brojac == 19 || brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29 || brojac == 30 || brojac == 31 || brojac == 32 || brojac == 33 || brojac == 34 || brojac == 35 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42 || brojac == 43 || brojac == 44 || brojac == 45 || brojac == 46 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55 || brojac == 56 || brojac==57) {
                     text.setText(R.string.PoNjegovojPregorkojMuci);
                     naslov.setText("Po njegovoj pregorkoj muci...");
                 } else if (brojac == 58) {
                     text.setText(R.string.SvetiBože);
                     naslov.setText("Sveti Bože...");
                 } else if (brojac == 59) {
                     text.setText(R.string.KrviIVodo);
                     naslov.setText("O, Krvi i Vodo...");
                 } else if (brojac == 60) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             if (krunica.equals("srceIsusovo")) {
                 slika--;
                 brojac--;
                 if(brojac==16)
                     slika=17;
                 if(brojac==28)
                     slika=30;
                 if(brojac==40)
                     slika=43;
                 if(brojac==52)
                     slika=56;
                 if(brojac==64)
                     slika=69;
                 if (slika == -1)
                     slika++;
                 if (slika == 0) {
                     int resID = getResources().getIdentifier("krunica", "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 } else {
                     int resID = getResources().getIdentifier(polje.get(slika - 1), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 if (brojac == -2)
                     brojac++;
                 if (brojac == -1) {
                     text.setText(R.string.ZnakKriza);
                     naslov.setText("Znak Križa");
                 } else if (brojac == 0) {
                     text.setText(R.string.SlatkoSrce);
                     naslov.setText("Slatko Srce mog Isusa...");
                 } else if (brojac == 1  || brojac == 6 || brojac == 18 || brojac == 30 || brojac == 42 || brojac == 54) {
                     text.setText(R.string.VječniOčeSrce);
                     naslov.setText("Vječni Oče...");
                 } else if (brojac == 2 || brojac == 3 || brojac == 4 || brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16 || brojac == 19 || brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 31 || brojac == 32 || brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 43 || brojac == 44 || brojac == 45 || brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 55 || brojac == 56 || brojac == 57 || brojac == 58 || brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64) {
                     text.setText(R.string.IsuseBlagaIPoniznaSrca);
                     naslov.setText("Isuse blaga i ponizna Srca...");
                 }else if (brojac == 5 || brojac == 17 || brojac == 29 || brojac == 41 || brojac == 53 || brojac==65) {
                     text.setText(R.string.SlatkoSrceMarijino);
                     naslov.setText("Slatko Srce Marijino...");
                 }else if (brojac == 66) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče naš...");
                 } else if (brojac == 67) {
                     text.setText(R.string.ZdravoMarijo);
                     naslov.setText("Zdravo Marijo...");
                 }else if (brojac == 68) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu...");
                 } else if (brojac == 69) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             if (krunica.equals("malaMarija")) {
                 slika--;
                 brojac--;
                 if(brojac==14)
                     slika=17;
                 if(brojac==25)
                     slika=30;
                 if(brojac==36)
                     slika=43;
                 if(brojac==47)
                     slika=56;
                 if(brojac==58)
                     slika=69;
                 if (slika == -1)
                     slika++;
                 if (slika == 0) {
                     int resID = getResources().getIdentifier("krunica", "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 } else {
                     int resID = getResources().getIdentifier(polje.get(slika - 1), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 if (brojac == -2)
                     brojac++;
                 if (brojac == -1) {
                     text.setText(R.string.ZnakKriza);
                     naslov.setText("Znak Križa");
                 } else if (brojac == 0 || brojac==4 || brojac==15 || brojac==26 || brojac==37 || brojac==48 || brojac==59) {
                     text.setText(R.string.Prežalosno);
                     naslov.setText("Prežalosno i bezgrešno...");
                 } else if (brojac == 1 || brojac == 2 || brojac == 3 || brojac==5|| brojac == 6 || brojac == 7 || brojac==8|| brojac == 9 || brojac == 10 || brojac==11|| brojac == 12 || brojac == 13 || brojac==14|| brojac == 16 || brojac == 17 || brojac==18|| brojac == 19 || brojac == 20 || brojac==21 || brojac == 22 || brojac == 23 || brojac==24|| brojac == 25 || brojac == 27 || brojac==28|| brojac == 29 || brojac == 30 || brojac==31|| brojac == 32 || brojac == 33 || brojac==34|| brojac == 35 || brojac == 36 || brojac==38|| brojac == 39 || brojac == 40 || brojac==41|| brojac == 42 || brojac == 43 || brojac==44|| brojac == 45 || brojac == 46 || brojac==47 || brojac == 49 || brojac == 50 || brojac==51|| brojac == 52 || brojac == 53 || brojac==54|| brojac == 55 || brojac == 56 || brojac==57 || brojac==58) {
                     text.setText(R.string.PresvetaMajko);
                     naslov.setText("Presveta Majko...");
                 }else if (brojac == 60) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 61) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 62) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 63) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }
         });


         exit.setOnClickListener(v -> {
             Intent mainIntent = new Intent(MainActivity.this, Selector.class);
             startActivity(mainIntent);
             finish();
         });

         for (int i = 0; i < 72; i++) {
             polje.add("krunica" + i);

         }


         next.setOnClickListener(v -> {
             text.scrollTo(0,0);

             if (krunica.equals("gospa")) {
                 if (slika < 72) {
                     int resID = getResources().getIdentifier(polje.get(slika), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }

                 slika++;
                 brojac++;
                 if (brojac == 0) {
                     text.setText(R.string.Vjerovanje);
                     naslov.setText("Vjerovanje");
                 } else if (brojac == 1 || brojac == 6 || brojac == 19 || brojac == 32 || brojac == 45 || brojac == 58) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče Naš");
                 } else if (brojac == 5 || brojac == 17 || brojac == 30 || brojac == 43 || brojac == 56 || brojac == 69) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 } else if (brojac == 18 || brojac == 31 || brojac == 44 || brojac == 57 || brojac == 70) {
                     text.setText(R.string.MojIsuse);
                     naslov.setText("O, moj Isuse...");
                 } else if (brojac == 2) {
                     String bold = " Koji neka nam umnoži vjeru.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 144, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 3) {
                     String bold = " Koji neka nam učvrsti ufanje.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 4) {
                     String bold = " Koji neka nam usavrši ljubav.";
                     String temp = getResources().getString(R.string.ZdravoMarijo);
                     temp = temp.substring(0, 117) + bold + temp.substring(117, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 117, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Marijo");
                 } else if (brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 157, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla1);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 161, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla2);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 35, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla3);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 67, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 153, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 36, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla4);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 53, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64 || brojac == 65 || brojac == 66 || brojac == 67 || brojac == 68) {
                     if (otajstvo.equals("radosna")) {
                         String bold = getResources().getString(R.string.radosna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 149, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("zalosna")) {
                         String bold = getResources().getString(R.string.zalosna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }

                     if (otajstvo.equals("slavna")) {
                         String bold = getResources().getString(R.string.slavna5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 39, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                     if (otajstvo.equals("svjetla")) {
                         String bold = getResources().getString(R.string.svjetla5);
                         String temp = getResources().getString(R.string.ZdravoMarijo);
                         temp = temp.substring(0, 117) + " " + bold + temp.substring(117, temp.length());
                         SpannableString str = new SpannableString(temp);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         str.setSpan(new StyleSpan(Typeface.BOLD), 117, 117 + 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                         text.setText(str);
                         naslov.setText("Zdravo Marijo");
                     }
                 } else if (brojac == 71) {
                     text.setText(R.string.ZdravoKraljice);
                     naslov.setText("Zdravo Kraljice");
                 } else if (brojac == 72) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             ////////////

             if (krunica.equals("josip")) {
                 if (slika < 72) {
                     int resID = getResources().getIdentifier(polje.get(slika), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }

                 slika++;
                 brojac++;
                 if (brojac == 0) {
                     text.setText(R.string.Vjerovanje);
                     naslov.setText("Vjerovanje");
                 } else if (brojac == 1 || brojac == 6 || brojac == 19 || brojac == 32 || brojac == 45 || brojac == 58) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče Naš");
                 } else if (brojac == 5 || brojac == 17 || brojac == 30 || brojac == 43 || brojac == 56 || brojac == 69) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 } else if (brojac == 18 || brojac == 31 || brojac == 44 || brojac == 57 || brojac == 70) {
                     text.setText(R.string.MiliJosipe);
                     naslov.setText("O, mili, blagi,...");

                 } else if (brojac == 2) {
                     String bold = "koji neka nam umnoži vjeru. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 3) {
                     String bold = "koji neka nam učvrsti ufanje. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 4) {
                     String bold = "koji neka nam usavrši ljubav. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16) {
                     String bold = "kojeg si žarko volio. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29) {
                     String bold = "koji je tebe slušao i ljubio. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42) {
                     String bold = "za koga si marljivo radio. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55) {
                     String bold = "koji je tebe u poslu pomagao. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64 || brojac == 65 || brojac == 66 || brojac == 67 || brojac == 68) {
                     String bold = "koji je uza te bio kad si umirao. ";
                     String temp = getResources().getString(R.string.ZdravoJosipe);
                     temp = temp.substring(0, 82) + bold + temp.substring(82, temp.length());
                     SpannableString str = new SpannableString(temp);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     str.setSpan(new StyleSpan(Typeface.BOLD), 82, 82 + 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                     text.setText(str);
                     naslov.setText("Zdravo Josipe");

                 } else if (brojac == 71) {
                     text.setText(R.string.BožeOče);
                     naslov.setText("Bože Oče...");
                 } else if (brojac == 72) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             ///////////

             if (krunica.equals("milosrdje")) {
                     if(brojac==-1)
                         slika=2;
                     if(brojac==3)
                         slika=7;
                     if(brojac==13)
                         slika=19;
                     if(brojac==24)
                         slika=32;
                     if(brojac==35)
                         slika=45;
                     if(brojac==46)
                         slika=58;

                     if (slika < 72) {
                         int resID = getResources().getIdentifier(polje.get(slika), "drawable", getPackageName());
                         ImageView imageView = findViewById(R.id.krunica_image);
                         Drawable image = getResources().getDrawable(resID);
                         imageView.setImageDrawable(image);
                     }

                     slika++;
                     brojac++;
                     if (brojac == 0) {
                         text.setText(R.string.OčeNaš);
                         naslov.setText("Oče Naš");
                     } else if (brojac == 1) {
                         text.setText(R.string.ZdravoMarijo);
                         naslov.setText("Zdravo Marijo");

                     } else if (brojac == 2) {
                         text.setText(R.string.Vjerovanje);
                         naslov.setText("Vjerovanje");

                     } else if (brojac == 3 || brojac == 14 || brojac == 25 || brojac == 36 || brojac == 47) {
                         text.setText(R.string.VječniOče);
                         naslov.setText("Vječni Oče...");

                     } else if (brojac == 4 || brojac == 5 || brojac == 6 || brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 15 || brojac == 16 || brojac == 17 || brojac == 18 || brojac == 19 || brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 29 || brojac == 30 || brojac == 31 || brojac == 32 || brojac == 33 || brojac == 34 || brojac == 35 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 41 || brojac == 42 || brojac == 43 || brojac == 44 || brojac == 45 || brojac == 46 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 53 || brojac == 54 || brojac == 55 || brojac == 56 || brojac==57) {
                         text.setText(R.string.PoNjegovojPregorkojMuci);
                         naslov.setText("Po njegovoj pregorkoj muci...");
                     } else if (brojac == 58) {
                         text.setText(R.string.SvetiBože);
                         naslov.setText("Sveti Bože...");
                     } else if (brojac == 59) {
                         text.setText(R.string.KrviIVodo);
                         naslov.setText("O, Krvi i Vodo...");
                     } else if (brojac == 60) {
                         Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                         Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                         startActivity(mainIntent);
                         finish();
                     }
             }

             if (krunica.equals("srceIsusovo")) {
                 if (slika < 72) {
                     int resID = getResources().getIdentifier(polje.get(slika), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 if(brojac==17|| brojac == 29 || brojac == 41 || brojac == 53)
                     slika++;

                 slika++;
                 brojac++;
                 if (brojac == 0) {
                     text.setText(R.string.SlatkoSrce);
                     naslov.setText("Slatko Srce mog Isusa...");
                 } else if (brojac == 1  || brojac == 6 || brojac == 18 || brojac == 30 || brojac == 42 || brojac == 54) {
                     text.setText(R.string.VječniOčeSrce);
                     naslov.setText("Vječni Oče...");
                 } else if (brojac == 2 || brojac == 3 || brojac == 4 || brojac == 7 || brojac == 8 || brojac == 9 || brojac == 10 || brojac == 11 || brojac == 12 || brojac == 13 || brojac == 14 || brojac == 15 || brojac == 16 || brojac == 19 || brojac == 20 || brojac == 21 || brojac == 22 || brojac == 23 || brojac == 24 || brojac == 25 || brojac == 26 || brojac == 27 || brojac == 28 || brojac == 31 || brojac == 32 || brojac == 33 || brojac == 34 || brojac == 35 || brojac == 36 || brojac == 37 || brojac == 38 || brojac == 39 || brojac == 40 || brojac == 43 || brojac == 44 || brojac == 45 || brojac == 46 || brojac == 47 || brojac == 48 || brojac == 49 || brojac == 50 || brojac == 51 || brojac == 52 || brojac == 55 || brojac == 56 || brojac == 57 || brojac == 58 || brojac == 59 || brojac == 60 || brojac == 61 || brojac == 62 || brojac == 63 || brojac == 64) {
                     text.setText(R.string.IsuseBlagaIPoniznaSrca);
                     naslov.setText("Isuse blaga i ponizna Srca...");
                 }else if (brojac == 5 || brojac == 17 || brojac == 29 || brojac == 41 || brojac == 53 || brojac==65) {
                     text.setText(R.string.SlatkoSrceMarijino);
                     naslov.setText("Slatko Srce Marijino...");
                 }else if (brojac == 66) {
                     text.setText(R.string.OčeNaš);
                     naslov.setText("Oče naš...");
                 } else if (brojac == 67) {
                     text.setText(R.string.ZdravoMarijo);
                     naslov.setText("Zdravo Marijo...");
                 }else if (brojac == 68) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu...");
                 } else if (brojac == 69) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }

             if (krunica.equals("malaMarija")) {
                 if(brojac==-1)
                     slika=1;
                 if(brojac==3)
                     slika=6;
                 if(brojac==15)
                     slika=20;
                 if(brojac==26)
                     slika=33;
                 if(brojac==37)
                     slika=46;
                 if(brojac==48)
                     slika=59;
                 if(brojac==59)
                     slika=72;

                 if (slika < 72) {
                     int resID = getResources().getIdentifier(polje.get(slika), "drawable", getPackageName());
                     ImageView imageView = findViewById(R.id.krunica_image);
                     Drawable image = getResources().getDrawable(resID);
                     imageView.setImageDrawable(image);
                 }
                 slika++;
                 brojac++;
                 if (brojac == 0 || brojac==4 || brojac==15 || brojac==26 || brojac==37 || brojac==48 || brojac==59) {
                     text.setText(R.string.Prežalosno);
                     naslov.setText("Prežalosno i bezgrešno...");
                 } else if (brojac == 1 || brojac == 2 || brojac == 3 || brojac==5|| brojac == 6 || brojac == 7 || brojac==8|| brojac == 9 || brojac == 10 || brojac==11|| brojac == 12 || brojac == 13 || brojac==14|| brojac == 16 || brojac == 17 || brojac==18|| brojac == 19 || brojac == 20 || brojac==21 || brojac == 22 || brojac == 23 || brojac==24|| brojac == 25 || brojac == 27 || brojac==28|| brojac == 29 || brojac == 30 || brojac==31|| brojac == 32 || brojac == 33 || brojac==34|| brojac == 35 || brojac == 36 || brojac==38|| brojac == 39 || brojac == 40 || brojac==41|| brojac == 42 || brojac == 43 || brojac==44|| brojac == 45 || brojac == 46 || brojac==47 || brojac == 49 || brojac == 50 || brojac==51|| brojac == 52 || brojac == 53 || brojac==54|| brojac == 55 || brojac == 56 || brojac==57 || brojac==58) {
                     text.setText(R.string.PresvetaMajko);
                     naslov.setText("Presveta Majko...");
                 }else if (brojac == 60) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 61) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 62) {
                     text.setText(R.string.SlavaOcu);
                     naslov.setText("Slava Ocu");
                 }else if (brojac == 63) {
                     Toast.makeText(getApplicationContext(), "AMEN", Toast.LENGTH_SHORT).show();
                     Intent mainIntent = new Intent(MainActivity.this, Selector.class);
                     startActivity(mainIntent);
                     finish();
                 }
             }
         });
     }
 }
