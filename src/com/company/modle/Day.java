package com.company.modle;

public class Day {
    private int id;
    private String startTime;
    private String endTime;
    private boolean available;

    public Day(int id, String startTime, String endTime, boolean available) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.available = available;
    }




    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return id + " - " +
                startTime + '-' +
                endTime + " . " + (isAvailable() ? "متاح" : "غير متوفر");
    }

}
