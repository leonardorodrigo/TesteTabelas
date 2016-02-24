package br.com.testetabelas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class Main extends Activity {

    CalendarView calendarView;
    RadioButton radioButtonGroupFat, radioButtonGroupHyper;
    RadioButton radioButtonFat1, radioButtonFat2, radioButtonFat3;
    RadioButton radioButtonHyp1, radioButtonHyp2, radioButtonHyp3;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeCalendar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_exercise:
                createNewExercise();
                break;
            case R.id.new_training:
                createNewTraining();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeGroups() {
        radioButtonGroupFat = (RadioButton) findViewById(R.id.group_fat);
        radioButtonGroupHyper = (RadioButton) findViewById(R.id.group_hyper);

        radioButtonGroupFat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        radioButtonGroupHyper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    private void initializeCalendar() {
        calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setShowWeekNumber(false);
        calendarView.setFirstDayOfWeek(2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                Toast.makeText(getApplicationContext(), calendar.getTime().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createNewExercise() {

    }

    private void createNewTraining() {

    }
}
