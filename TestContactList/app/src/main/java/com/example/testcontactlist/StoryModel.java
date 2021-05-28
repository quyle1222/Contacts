package com.example.testcontactlist;

public class StoryModel {
    private String contactNumber;
    private String startTime;
    private String totalTime;

    public StoryModel(String contactNumber, String startTime, String totalTime) {
        this.contactNumber = contactNumber;
        this.startTime = startTime;
        this.totalTime = totalTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
