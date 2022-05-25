package com.company.modle;


public class Appointments {
    private int id;
    private String date;
    private Status completed;
    private Day[] days = new Day[4];
    private static int counter;

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

    public Appointments(String date) {
        this.date = date;
        this.completed = Status.معلق;
        this.id = counter++;
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


    public void setCompleted(Status isCompleted) {
        this.completed = isCompleted;
    }

    public Status getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "\t" + id +
                "\t" + date +
                "\t" + (completed.name())
                ;
    }


}


