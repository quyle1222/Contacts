package com.example.testcontactlist;

public class StoryModel {
    private int number;
    private String startTime;
    private String totalTime;

    public StoryModel(int number, String startTime, String totalTime) {
        this.number = number;
        this.startTime = startTime;
        this.totalTime = totalTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
}
