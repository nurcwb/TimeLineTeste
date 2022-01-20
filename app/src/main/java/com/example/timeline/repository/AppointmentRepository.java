package com.example.timeline.repository;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.timeline.repository.dao.Appointment;
import com.example.timeline.repository.dao.AppointmentDatabase;
import com.example.timeline.util.MyApp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppointmentRepository {

    private static List<Appointment> appointments = new ArrayList<>();

    private AppointmentDatabase database = Room.databaseBuilder(
            MyApp.getContext(),
            AppointmentDatabase.class,
            "appointment_db").build();

    public Observable<List<Appointment>> getAppointments() {
        return Observable.create(new ObservableOnSubscribe<List<Appointment>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Appointment>> emitter) throws Exception {
                emitter.onNext(database.appointmentDAO().getAllAppointment());
            }
        }).delay(1, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread());
    }

    public Observable<List<Appointment>> getAppointmentsByWeek(int week) {
        return Observable.create(new ObservableOnSubscribe<List<Appointment>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Appointment>> emitter) throws Exception {
                emitter.onNext(database.appointmentDAO().getAppointmentByWeek(week));
            }
        }).delay(1, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread());
    }


    public Observable<Boolean> saveAppoitment(Appointment appointment) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> emitter) throws Exception {
                database.appointmentDAO().insertAll(appointment);
                emitter.onNext(true);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }
}
