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

    public long insertExercise(Exercise exercise) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", exercise.getName());
        contentValues.put("eqName", exercise.getEqName());
        contentValues.put("eqNumber", exercise.getEqNumber());
        return db.insert("exercise", null, contentValues);
    }

    public long insertTraining(Training training) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("level", training.getLevel());
        contentValues.put("type", training.getType());
        Long savedId = db.insert("training", null, contentValues);
        for (Exercise exercise : training.getExercises()) {
            contentValues = new ContentValues();
            contentValues.put("idTraining", savedId);
            contentValues.put("idExercise", exercise.getId());
            db.insert("training_exercise", null, contentValues);
        }
        return savedId;
    }

}
