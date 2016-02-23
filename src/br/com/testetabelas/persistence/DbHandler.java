package br.com.testetabelas.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by desenvolv09 on 23/02/2016.
 */
public class DbHandler extends SQLiteOpenHelper{

    private static final String DB_NAME = "db";
    private static final int DB_VERSION = 1;

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table training(_id INTEGER primary key autoincrement, level INTEGER NOT NULL, type TEXT NOT NULL);");
        db.execSQL("create table exercise(_id INTEGER primary key autoincrement, name TEXT NOT NULL, eqNumber INTEGER NOT NULL);");
        db.execSQL("create table training_exercise(idTraining INTEGER NOT NULL, idExercise INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table training");
        db.execSQL("drop table exercise");
        db.execSQL("drop table training_exercise");
        onCreate(db);
    }
}
