package com.example.timeline.model;

import com.example.timeline.repository.AppointmentRepository;
import com.example.timeline.repository.dao.Appointment;
import com.example.timeline.vo.AppointmentItenVO;
import com.example.timeline.vo.NewAppointmentVO;
import com.example.timeline.vo.StatusBarVO;

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

    public List<AppointmentItenVO> getAppointments() {
        List<AppointmentItenVO> appointmentItensListVO = new ArrayList<>();
        statusBarVO.clean();
        for (Appointment appointment :
                appointmentList) {
            updadeStatusBarVO(appointment);
            appointmentItensListVO.add(new AppointmentItenVO(appointment));

        }
        return appointmentItensListVO;
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

    public Observable<Boolean> saveAppoitment(NewAppointmentVO newAppointmentVO) {
        return repository.saveAppoitment(new Appointment(newAppointmentVO));
    }

    public StatusBarVO getStatus() {
        return statusBarVO;
    }
}
