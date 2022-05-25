package com.company.modle;


public class Appointments {
    private static int id = 1;
    private String date;
    private boolean isCompleted;
    private Day[] days = new Day[4];

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

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

    }

    public Appointments(String date) {
        this.date = date;
        id++;
    }

    public void day() {
        days[0] = new Day(1, "8:00", "9:00", true);
        days[1] = new Day(2, "9:00", "10:00", true);
        days[2] = new Day(3, "10:00", "11:00", true);
        days[3] = new Day(4, "11:00", "12:00", true);
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
        return "\t" + id +
                "\t" + date +
                "\t" + (isCompleted ? "مكتمل" : "معلق");
    }


}


