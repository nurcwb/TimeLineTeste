package com.example.timeline.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.timeline.R;
import com.example.timeline.adapter.AppointmentAdapter;
import com.example.timeline.databinding.ActivityMainBinding;
import com.example.timeline.viewmodel.ActivityMainViewModel;

import java.util.Calendar;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private ActivityMainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityMainViewModel.class);

        updateList();

        viewModel.requestOk.observe(this, b -> {
            hideLoading();
            showListOfAppointments();
        });

        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        updateList();
                    }
                });

        binding.ivNew.setOnClickListener(v ->
            resultLauncher.launch(new Intent(this, ActivityNewAppointment.class))
        );

    }

    private void updateList() {
        showLoading();
        Calendar calendar = Calendar.getInstance();
        viewModel.requestAppointmentsByWeek(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    private void showListOfAppointments() {
        binding.setData(viewModel.getStatus());
        AppointmentAdapter adapter = new AppointmentAdapter(viewModel.getAppointments());
        binding.rvAppointments.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAppointments.setAdapter(adapter);

    }
}