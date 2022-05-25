package com.company.modle;


import java.util.ArrayList;
import java.util.List;

public class Appointments {
    private int id;
    private String date;
    private boolean isCompleted;
    public List<Day> days = new ArrayList<Day>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Appointments(int id, String date, boolean isCompleted) {
        this.id = id;
        this.date = date;
        this.isCompleted = isCompleted;
        this.days = new ArrayList<Day>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                ", id=" + id +
                ",\t date='" + date + '\'' +
                ",\t isCompleted=" + isCompleted +
                '}';
    }

    public boolean addDay(Day day) {
        return days.add(day);
    }

}


