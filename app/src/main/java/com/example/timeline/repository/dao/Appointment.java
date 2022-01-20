package com.example.timeline.repository.dao;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.timeline.util.IMAGE_TYPE;
import com.example.timeline.vo.DateOfEventVO;
import com.example.timeline.vo.NewAppointmentVO;

@Entity
public class Appointment {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @Embedded
    private DateOfEventVO dateOfEventVO;
    @ColumnInfo(name = "client_name")
    private String clientName;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "image_type")
    private IMAGE_TYPE image;

    public Appointment(DateOfEventVO dateOfEventVO, String clientName, String details, IMAGE_TYPE image, int id) {
        this.dateOfEventVO = dateOfEventVO;
        this.clientName = clientName;
        this.details = details;
        this.image = image;
        this.id = id;
    }

    @Ignore
    public Appointment(NewAppointmentVO newAppointmentVO) {
        this.dateOfEventVO = newAppointmentVO.getDateOfEvent();
        this.clientName = newAppointmentVO.getClientName();
        this.details = newAppointmentVO.getDetails();
        this.image = newAppointmentVO.getImage();
    }

    public int getId() {
        return id;
    }

    public DateOfEventVO getDateOfEventVO() {
        return dateOfEventVO;
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
