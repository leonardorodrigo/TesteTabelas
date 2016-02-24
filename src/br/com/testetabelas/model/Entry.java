package br.com.testetabelas.model;

import java.util.Date;

/**
 * Created by desenvolv09 on 24/02/2016.
 */
public class Entry {
    private Training training;
    private Date date;

    public Entry(Training training, Date date) {
        this.training = training;
        this.date = date;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
