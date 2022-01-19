package com.example.timeline.vo;

public class StatusBarVO {
    private int numMaps;
    private int numPhone;
    private int numEmail;

    public String getNumMaps() {
        return String.valueOf(numMaps);
    }

    public String getNumPhone() {
        return String.valueOf(numPhone);
    }

    public String getNumEmail() {
        return String.valueOf(numEmail);
    }

    public void addNumMaps() {
        numMaps++;
    }

    public void addNumPhone() {
        numPhone++;
    }

    public void addNumEmail() {
        numEmail++;
    }

    public void clean() {
        numEmail = 0;
        numMaps = 0;
        numPhone = 0;
    }
}
