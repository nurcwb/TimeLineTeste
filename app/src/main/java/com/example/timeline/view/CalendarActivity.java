package com.example.timeline.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.timeline.R;
import com.example.timeline.databinding.ActivityCalendarBinding;
import com.example.timeline.util.Constans;
import com.example.timeline.vo.DateOfEventVO;

public class CalendarActivity extends AppCompatActivity {

    private ActivityCalendarBinding binding;
    private DateOfEventVO dateOfEventVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);

        binding.btnOk.setEnabled(false);
        binding.tpTime.setEnabled(false);

        binding.calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                dateOfEventVO = new DateOfEventVO(year, month, day);
                binding.tpTime.setEnabled(true);
            }
        });

        binding.tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minuts) {

                if (minuts < 10) {
                    dateOfEventVO.setTimeOfAppointment(hour + ":" + "0" + minuts);
                } else
                    dateOfEventVO.setTimeOfAppointment(hour + ":" + minuts);
                binding.btnOk.setEnabled(true);
            }
        });

        binding.btnOk.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(Constans.CALENDAR_TIME_APPOINTMENT, dateOfEventVO);
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}