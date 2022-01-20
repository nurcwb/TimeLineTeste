package com.example.timeline.vo;

import com.example.timeline.repository.Appointment;
import com.example.timeline.util.IMAGE_TYPE;

public class AppointmentItenVO {
    private int id;
    private String day;
    private String time;
    private IMAGE_TYPE image;
    private String detailsAppointment;
    private String contactName;

    public AppointmentItenVO(Appointment appointment) {
        this.id = appointment.getId();
        this.day = appointment.getDateOfEventVO().getDayOfWeek();
        this.time = appointment.getDateOfEventVO().getTimeOfAppointmentAsHour();
        this.image = appointment.getImage();
        this.detailsAppointment = appointment.getDetails();
        this.contactName = appointment.getClientName();
    }

    public int getId() {
        return id;
    }

    public String getDay() {
        return day.substring(0,3);
    }

    public String getTime() {
        return time;
    }

    public int getImage() {
        return image.getImageType();
    }

    public String getDetailsAppointment() {
        return detailsAppointment;
    }

    public String getContactName() {
        return contactName;
    }
}
