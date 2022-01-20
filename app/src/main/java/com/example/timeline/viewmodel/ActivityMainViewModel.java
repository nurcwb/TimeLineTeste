package com.example.timeline.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.timeline.model.AppointmentModel;
import com.example.timeline.vo.AppointmentItenVO;
import com.example.timeline.vo.StatusBarVO;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class ActivityMainViewModel extends ViewModel {
    private AppointmentModel model = AppointmentModel.getInstance();
    private CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<Boolean> requestOk = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();


    public void requestAppointments() {
        model.requestAppointments().subscribe(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(@NonNull Boolean hasAppointments) {
                requestOk.postValue(hasAppointments);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                error.postValue(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void requestAppointmentsByWeek(int week) {
        model.requestAppointmentsByWeek(week).subscribe(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(@NonNull Boolean hasAppointments) {
                requestOk.postValue(hasAppointments);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                error.postValue(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public List<AppointmentItenVO> getAppointments() {
        return model.getAppointments();
    }

    public StatusBarVO getStatus() {
        return model.getStatus();
    }
}
