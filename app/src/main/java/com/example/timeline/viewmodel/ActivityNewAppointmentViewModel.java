package com.example.timeline.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.timeline.model.AppointmentModel;
import com.example.timeline.vo.NewAppointmentVO;

import io.reactivex.observers.DisposableObserver;

public class ActivityNewAppointmentViewModel extends ViewModel {

    private AppointmentModel model = AppointmentModel.getInstance();

    public MutableLiveData<String> error = new MutableLiveData<>();
    public MutableLiveData<Boolean> saveNewAppointment = new MutableLiveData<>();

    public void saveNewAppoitment(NewAppointmentVO newAppointmentVO) {
        model.saveAppoitment(newAppointmentVO).subscribe(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(@NonNull Boolean aBoolean) {
                saveNewAppointment.postValue(aBoolean);
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
}
