package com.breckneck.washapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Room> roomList;

    RoomAdapter(Context context, List<Room> roomList) {
        this.roomList = roomList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.room_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.nameView.setText(room.getRoomName());
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.roomname);
        }
    }
}
