package com.example.timeline.vo;

import com.example.timeline.util.IMAGE_TYPE;

public class NewAppointment {
    private DateOfEvent dateOfEvent;
    private String clientName;
    private String details;
    private IMAGE_TYPE image;

    public NewAppointment(DateOfEvent dateOfEvent, String clientName, String details, IMAGE_TYPE image) {
        this.dateOfEvent = dateOfEvent;
        this.clientName = clientName;
        this.details = details;
        this.image = image;
    }

    public DateOfEvent getDateOfEvent() {
        return dateOfEvent;
    }

    public String getClientName() {
        return clientName;
    }

    public String getDetails() {
        return details;
    }

    public IMAGE_TYPE getImage() {
        return image;
    }
}
