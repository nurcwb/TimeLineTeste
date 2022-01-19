package com.example.timeline.repository;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.timeline.util.IMAGE_TYPE;
import com.example.timeline.vo.DateOfEvent;
import com.example.timeline.vo.NewAppointment;

@Entity
public class Appointment {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @Embedded
    private DateOfEvent dateOfEvent;
    @ColumnInfo(name = "client_name")
    private String clientName;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "image_type")
    private IMAGE_TYPE image;

    public Appointment(DateOfEvent dateOfEvent, String clientName, String details, IMAGE_TYPE image, int id) {
        this.dateOfEvent = dateOfEvent;
        this.clientName = clientName;
        this.details = details;
        this.image = image;
        this.id = id;
    }

    @Ignore
    public Appointment(NewAppointment newAppointment) {
        this.dateOfEvent = newAppointment.getDateOfEvent();
        this.clientName = newAppointment.getClientName();
        this.details = newAppointment.getDetails();
        this.image = newAppointment.getImage();
    }

    public int getId() {
        return id;
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
