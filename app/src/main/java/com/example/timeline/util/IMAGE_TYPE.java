package com.example.timeline.util;

public enum IMAGE_TYPE {
    MAPS(0), PHONE(1), EMAIL(2);

    private final int imageType;

    IMAGE_TYPE(int imageType) {
        this.imageType = imageType;
    }

    public int getImageType() {
        return imageType;
    }
}
