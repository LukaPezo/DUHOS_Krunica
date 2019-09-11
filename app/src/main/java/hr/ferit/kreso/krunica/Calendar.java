package hr.ferit.kreso.krunica;

import android.app.Activity;
import android.os.Bundle;

public class Calendar extends Activity {

    CustomCalendarView customCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        customCalendarView = (CustomCalendarView) findViewById(R.id.custom_calendar_view);
    }
}
