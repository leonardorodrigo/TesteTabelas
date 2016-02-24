package br.com.testetabelas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.Calendar;

public class Main extends Activity implements CompoundButton.OnCheckedChangeListener {

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

        initializeListenersRadioButtons();
        initializeCalendar();
        initializeGroups();

        radioButtonGroupFat.setChecked(true);
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

    private void initializeListenersRadioButtons() {
        radioButtonFat1.setOnCheckedChangeListener(this);
        radioButtonFat2.setOnCheckedChangeListener(this);
        radioButtonFat3.setOnCheckedChangeListener(this);
        radioButtonHyp1.setOnCheckedChangeListener(this);
        radioButtonHyp2.setOnCheckedChangeListener(this);
        radioButtonHyp3.setOnCheckedChangeListener(this);
    }

    private void initializeCalendar() {
        calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setShowWeekNumber(false);
        calendarView.setFirstDayOfWeek(2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
            }
        });
    }

    private void initializeGroups() {
        radioButtonGroupFat = (RadioButton) findViewById(R.id.group_fat);
        radioButtonGroupHyper = (RadioButton) findViewById(R.id.group_hyper);
        radioButtonGroupFat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setVisibilityFatButtons(true);
                    setVisibilityHyperButtons(false);
                }
            }
        });
        radioButtonGroupHyper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setVisibilityFatButtons(false);
                    setVisibilityHyperButtons(true);
                }
            }
        });
    }

    private void createNewExercise() {

    }

    private void createNewTraining() {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (buttonView.getId() != R.id.group_fat && buttonView.getId() != R.id.group_hyper && isChecked) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(calendarView.getDate());
            final RadioButton selected = (RadioButton) findViewById(buttonView.getId());
            builder.setMessage(selected.getText() + "\n(" + calendar.getTime().toString() + ")\n" + "Confirma?");
            builder.setPositiveButton("Sim", null);
            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selected.setChecked(false);
                }
            });
            builder.create().show();
        }
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

    private void setVisibilityFatButtons(boolean visible) {
        if (!visible) {
            radioButtonFat1.setChecked(false);
            radioButtonFat2.setChecked(false);
            radioButtonFat3.setChecked(false);
        }
        findViewById(R.id.radio_group_fat).setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    private void setVisibilityHyperButtons(boolean visible) {
        if (!visible) {
            radioButtonHyp1.setChecked(false);
            radioButtonHyp2.setChecked(false);
            radioButtonHyp3.setChecked(false);
        }
        findViewById(R.id.radio_group_thin).setVisibility(visible ? View.VISIBLE : View.GONE);
    }

}
