package br.com.testetabelas.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.testetabelas.model.Exercise;
import br.com.testetabelas.model.Training;

/**
 * Created by desenvolv09 on 23/02/2016.
 */
public class Persistence {

    private SQLiteDatabase db;

    public Persistence(Context context) {
        DbHandler dbHandler = new DbHandler(context);
        db = dbHandler.getWritableDatabase();
    }

    public void insertExercise(Exercise exercise) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", exercise.getName());
    }

    public void insertTraining(Training training) {

    }
}
