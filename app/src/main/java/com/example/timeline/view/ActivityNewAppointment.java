package com.example.timeline.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.timeline.R;
import com.example.timeline.databinding.ActivityNewAppointmentBinding;
import com.example.timeline.util.Constans;
import com.example.timeline.util.IMAGE_TYPE;
import com.example.timeline.viewmodel.ActivityNewAppointmentViewModel;
import com.example.timeline.vo.DateOfEvent;
import com.example.timeline.vo.NewAppointment;

public class ActivityNewAppointment extends BaseActivity {

    private ActivityNewAppointmentBinding binding;
    private DateOfEvent dateOfEvent;
    private IMAGE_TYPE image_type = IMAGE_TYPE.EMAIL;

    private ActivityNewAppointmentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_appointment);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityNewAppointmentViewModel.class);

        binding.ivMail.setBackground(getResources().getDrawable(R.drawable.circle_red));

        viewModel.saveNewAppointment.observe(this, b -> {
            hideLoading();
            if (b) {
                setResult(RESULT_OK);
                finish();
            }
        });

        viewModel.error.observe(this, error -> {
            hideLoading();
            Toast.makeText(this, "Erro ao salvar.", Toast.LENGTH_SHORT).show();
        });


        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        if (result.getData().hasExtra(Constans.CALENDAR_TIME_APPOINTMENT)) {
                            dateOfEvent = (DateOfEvent) result.getData().getSerializableExtra(Constans.CALENDAR_TIME_APPOINTMENT);
                            binding.tvDaySelected.setText(dateOfEvent.getDate());
                            binding.tvTimeSelected.setText(dateOfEvent.getTimeOfAppointmentAsHour());
                        }
                    }
                });

        binding.btnCancel.setOnClickListener(v -> finish());
        binding.clCalendarTimer.setOnClickListener(v ->
                resultLauncher.launch(new Intent(this, CalendarActivity.class)));
        binding.btnNew.setOnClickListener(v -> {
            NewAppointment newAppointment = new NewAppointment(dateOfEvent,
                    binding.etClient.getText().toString(),
                    binding.etDescription.getText().toString(),
                    image_type);
            showLoading();
            viewModel.saveNewAppoitment(newAppointment);
        });

        binding.ivMail.setOnClickListener(v -> {
            image_type = IMAGE_TYPE.EMAIL;
            setImageAppointmentType(R.drawable.circle_red, R.drawable.circle, R.drawable.circle);
        });
        binding.ivPhone.setOnClickListener(v -> {
            image_type = IMAGE_TYPE.PHONE;
            setImageAppointmentType(R.drawable.circle, R.drawable.circle_red, R.drawable.circle);
        });
        binding.ivMaps.setOnClickListener(v -> {
            image_type = IMAGE_TYPE.MAPS;
            setImageAppointmentType(R.drawable.circle, R.drawable.circle, R.drawable.circle_red);
        });
    }

    private void setImageAppointmentType(int p, int p2, int p3) {
        binding.ivMail.setBackground(getResources().getDrawable(p));
        binding.ivPhone.setBackground(getResources().getDrawable(p2));
        binding.ivMaps.setBackground(getResources().getDrawable(p3));
    }
}