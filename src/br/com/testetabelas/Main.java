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

        radioButtonFat1 = (RadioButton) findViewById(R.id.fat_burn_1);
        radioButtonFat2 = (RadioButton) findViewById(R.id.fat_burn_2);
        radioButtonFat3 = (RadioButton) findViewById(R.id.fat_burn_3);

        radioButtonHyp1 = (RadioButton) findViewById(R.id.hypertrophy_1);
        radioButtonHyp2 = (RadioButton) findViewById(R.id.hypertrophy_2);
        radioButtonHyp3 = (RadioButton) findViewById(R.id.hypertrophy_3);

        initializeCalendar();
        initializeGroups();
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
                if (isChecked) {
                    radioButtonFat1.setChecked(true);
                    setEnableFatButtons(true);
                    setEnableHyperButtons(false);
                }
            }
        });
        radioButtonGroupHyper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButtonHyp1.setChecked(true);
                    setEnableFatButtons(false);
                    setEnableHyperButtons(true);
                }
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

    private void setEnableFatButtons(boolean enable) {
        if (!enable) {
            radioButtonFat1.setChecked(false);
            radioButtonFat2.setChecked(false);
            radioButtonFat3.setChecked(false);
        }
        radioButtonFat1.setEnabled(enable);
        radioButtonFat2.setEnabled(enable);
        radioButtonFat3.setEnabled(enable);
    }

    private void setEnableHyperButtons(boolean enable) {
        if (!enable) {
            radioButtonHyp1.setChecked(false);
            radioButtonHyp2.setChecked(false);
            radioButtonHyp3.setChecked(false);
        }
        radioButtonHyp1.setEnabled(enable);
        radioButtonHyp2.setEnabled(enable);
        radioButtonHyp3.setEnabled(enable);
    }
}
