package com.example.timeline.vo;

import java.io.Serializable;
import java.util.Calendar;

public class DateOfEvent implements Serializable {
    private int day;
    private int month;
    private int year;
    private int timeOfAppointment;
    private String timeOfAppointmentAsHour;
    private String dayOfWeek;
    private int week;

    public DateOfEvent() {
        Calendar calendar = Calendar.getInstance();
        new DateOfEvent(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH));
    }

    public DateOfEvent(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        week = calendar.get(Calendar.WEEK_OF_YEAR);
        dayOfWeek = getDayOfWeekAsName(calendar);
    }

    private String getDayOfWeekAsName(Calendar calendar) {
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "Domingo";
            case 2:
                return "Segunda";
            case 3:
                return "Terça";
            case 4:
                return "Quarta";
            case 5:
                return "Quinta";
            case 6:
                return "Sexta";
            default:
                return "Sábado";
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public String getTimeOfAppointmentAsHour() {
        return timeOfAppointmentAsHour;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public void setTimeOfAppointment(String timeOfAppointment) {
        this.timeOfAppointmentAsHour = timeOfAppointment;
        this.timeOfAppointment = Integer.valueOf(timeOfAppointment.replace(":",""));
    }

    public void setTimeOfAppointment(int timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public void setTimeOfAppointmentAsHour(String timeOfAppointmentAsHour) {
        this.timeOfAppointmentAsHour = timeOfAppointmentAsHour;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setWeek(int week) {
        this.week = week;
    }

     public String getDate() {
        return day + "/" + month + "/" + year;
    }

}

