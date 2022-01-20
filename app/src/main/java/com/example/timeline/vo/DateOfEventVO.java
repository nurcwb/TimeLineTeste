package com.example.timeline.vo;

import java.io.Serializable;
import java.util.Calendar;

public class DateOfEventVO implements Serializable {
    private int day;
    private int month;
    private int year;
    private int timeOfAppointment;
    private String timeOfAppointmentAsHour;
    private String dayOfWeek;
    private int week;

    public DateOfEventVO() {
        Calendar calendar = Calendar.getInstance();
        new DateOfEventVO(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH));
        setTimeOfAppointment("12:00");
    }

    public DateOfEventVO(int year, int month, int day) {
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
        switch (month){
            case 0:
                return day + " Jan " + year;
            case 1:
                return day + " fev " + year;
            case 2:
                return day + " Mar " + year;
            case 3:
                return day + " Abr " + year;
            case 4:
                return day + " Mai " + year;
            case 5:
                return day + " Jun " + year;
            case 6:
                return day + " Jul " + year;
            case 7:
                return day + " Ago " + year;
            case 8:
                return day + " Set " + year;
            case 9:
                return day + " Out " + year;
            case 10:
                return day + " Nov " + year;
            case 11:
                return day + " Dez " + year;

        }

        return day + "/" + month + "/" + year;
    }

}

