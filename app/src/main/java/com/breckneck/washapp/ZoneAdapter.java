package com.breckneck.washapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Zone> zoneList;



    interface OnZoneClickListener {
        void onZoneClick(Zone zone, int position);
    }

    private final OnZoneClickListener onZoneClickListener;

    ZoneAdapter(Context context, List<Zone> zoneList, OnZoneClickListener onZoneClickListener) {
        this.zoneList = zoneList;
        this.inflater = LayoutInflater.from(context);
        this.onZoneClickListener = onZoneClickListener;
    }

    @NonNull
    @Override
    public ZoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.zone_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZoneAdapter.ViewHolder holder, int position) {
        Zone zone = zoneList.get(position);
        holder.nameView.setText(zone.getZoneName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onZoneClickListener.onZoneClick(zone, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return zoneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.zonename);
        }
    }
}
