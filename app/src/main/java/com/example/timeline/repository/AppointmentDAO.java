package com.example.timeline.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppointmentDAO {
    @Query("SELECT * FROM Appointment ORDER BY month ASC, day ASC, timeOfAppointment ASC")
    List<Appointment> getAllAppointment();

    @Query("SELECT * FROM Appointment WHERE week IN(:week) ORDER BY day ASC, timeOfAppointment ASC")
    List<Appointment> getAppointmentByWeek(int week);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Appointment ... appointments);

    @Update
    void updatUser(Appointment appointment);

    @Delete
    void delete(Appointment appointment);
}
