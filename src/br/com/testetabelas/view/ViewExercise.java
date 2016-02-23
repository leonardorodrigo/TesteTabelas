package br.com.testetabelas.view;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import br.com.testetabelas.R;
import br.com.testetabelas.model.Exercise;

/**
 * Created by desenvolv09 on 23/02/2016.
 */
public class ViewExercise {

    private Context context;
    private TextView textViewDescription;
    private Exercise exercise;

    public ViewExercise(Context context) {
        this.context = context;
        textViewDescription = (TextView) ((Activity) context).findViewById(R.id.description);
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
