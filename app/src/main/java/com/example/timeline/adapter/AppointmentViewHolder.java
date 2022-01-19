package com.example.timeline.adapter;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timeline.R;
import com.example.timeline.databinding.LayoutItenTimelineBinding;
import com.example.timeline.util.MyApp;
import com.example.timeline.vo.VOAppointmentIten;

public class AppointmentViewHolder extends RecyclerView.ViewHolder {

    private com.example.timeline.databinding.LayoutItenTimelineBinding binding;

    public AppointmentViewHolder(@NonNull LayoutItenTimelineBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setItem(VOAppointmentIten voAppointmentIten) {
        binding.setData(voAppointmentIten);
        switch (voAppointmentIten.getImage()) {
            case 0:
                binding.ivIten.setImageResource(R.drawable.ic_maps);
                break;
            case 1:
                binding.ivIten.setImageResource(R.drawable.ic_phone);
                break;
            default:
                binding.ivIten.setImageResource(R.drawable.ic_email);
                break;
        }

    }
}
