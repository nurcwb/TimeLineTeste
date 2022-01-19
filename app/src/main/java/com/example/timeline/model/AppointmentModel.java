package com.example.timeline.model;

import com.example.timeline.repository.Appointment;
import com.example.timeline.repository.AppointmentRepository;
import com.example.timeline.vo.NewAppointment;
import com.example.timeline.vo.StatusBarVO;
import com.example.timeline.vo.VOAppointmentIten;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class AppointmentModel {
    private static AppointmentModel model;
    private static AppointmentRepository repository;
    private static List<Appointment> appointmentList = new ArrayList<>();
    private final StatusBarVO statusBarVO = new StatusBarVO();


    public static AppointmentModel getInstance() {
        if (null == model) {
            model = new AppointmentModel();
            repository = new AppointmentRepository();
        }
        return model;
    }

    public Observable<Boolean> requestAppointments() {
        return repository.getAppointments().map(appointments -> {
            if (!appointments.isEmpty()) {
                appointmentList = appointments;
                return true;
            } else
                return false;
        });
    }

    public Observable<Boolean> requestAppointmentsByWeek(int week) {
        return repository.getAppointmentsByWeek(week).map(appointments -> {
                if (!appointments.isEmpty()) {
                    appointmentList = appointments;
                    return true;
                } else
                    return false;
        });
    }

    public List<VOAppointmentIten> getAppointments() {
        List<VOAppointmentIten> voAppointmentItensList = new ArrayList<>();
        statusBarVO.clean();
        for (Appointment appointment :
                appointmentList) {
            updadeStatusBarVO(appointment);
            voAppointmentItensList.add(new VOAppointmentIten(appointment));

        }
        return voAppointmentItensList;
    }

    private void updadeStatusBarVO(Appointment appointment) {
        switch (appointment.getImage().getImageType()) {
            case 0:
                statusBarVO.addNumMaps();
                break;
            case 1:
                statusBarVO.addNumPhone();
                break;
            case 2:
                statusBarVO.addNumEmail();
                break;
        }
    }

    public Observable<Boolean> saveAppoitment(NewAppointment newAppointment) {
        return repository.saveAppoitment(new Appointment(newAppointment));
    }

    public StatusBarVO getStatus() {
        return statusBarVO;
    }
}
