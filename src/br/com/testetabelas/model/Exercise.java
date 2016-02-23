package br.com.testetabelas.model;

/**
 * Created by desenvolv09 on 23/02/2016.
 */
public class Exercise {

    private int id;
    private String name;
    private String eqName;
    private int eqNumber;

    public Exercise(int id, String name, String eqName, int eqNumber) {
        this.id = id;
        this.name = name;
        this.eqName = eqName;
        this.eqNumber = eqNumber;
    }

    public Exercise(String name, String eqName, int eqNumber) {
        this.name = name;
        this.eqName = eqName;
        this.eqNumber = eqNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public int getEqNumber() {
        return eqNumber;
    }

    public void setEqNumber(int eqNumber) {
        this.eqNumber = eqNumber;
    }
}
