package com.example.timeline.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timeline.databinding.LayoutItenTimelineBinding;
import com.example.timeline.vo.AppointmentItenVO;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentViewHolder> {

    private final List<AppointmentItenVO> appointmentItens;

    public AppointmentAdapter(List<AppointmentItenVO> appointmentItens) {
        this.appointmentItens = appointmentItens;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutItenTimelineBinding binding = LayoutItenTimelineBinding.inflate(layoutInflater, parent, false);
        return new AppointmentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        holder.setItem(appointmentItens.get(position));
    }

    @Override
    public int getItemCount() {
        return appointmentItens.size();
    }
}
