package com.example.timeline.vo;

import com.example.timeline.util.IMAGE_TYPE;

public class NewAppointmentVO {
    private DateOfEventVO dateOfEventVO;
    private String clientName;
    private String details;
    private IMAGE_TYPE image;

    public NewAppointmentVO(DateOfEventVO dateOfEventVO, String clientName, String details, IMAGE_TYPE image) {
        this.dateOfEventVO = dateOfEventVO;
        this.clientName = clientName;
        this.details = details;
        this.image = image;
    }

    public DateOfEventVO getDateOfEvent() {
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
