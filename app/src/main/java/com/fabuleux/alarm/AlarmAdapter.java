package com.fabuleux.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ListViewHolder>
{

    private Context context;
    List<String> alarms;

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.alarm_time.setText("12:00");
    }

    @Override
    public int getItemCount()
    {
        return 14;
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.alarm_time) public AppCompatTextView alarm_time;

        ListViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
