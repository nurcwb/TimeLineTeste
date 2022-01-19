package com.example.timeline.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Appointment.class}, version = 1)
public abstract class AppointmentDatabase extends RoomDatabase {
    public abstract AppointmentDAO appointmentDAO();
}
