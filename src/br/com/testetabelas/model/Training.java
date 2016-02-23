package br.com.testetabelas.model;

import java.util.List;

/**
 * Created by desenvolv09 on 23/02/2016.
 */
public class Training {

    private int id;
    private int level;
    private String type;
    private List<Exercise> exercises;

    public Training(int id, int level, String type, List<Exercise> exercises) {
        this.id = id;
        this.level = level;
        this.type = type;
        this.exercises = exercises;
    }

    public Training(int level, String type, List<Exercise> exercises) {
        this.level = level;
        this.type = type;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
