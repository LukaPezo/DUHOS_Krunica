package hr.ferit.kreso.krunica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EventRecycleAdapter extends RecyclerView.Adapter<EventRecycleAdapter.MyViewHolder> {

    Context context;
    ArrayList<Events> arrayList;

    public EventRecycleAdapter(Context context, ArrayList<Events> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_events_rowlayout, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Events events = arrayList.get(position);
        holder.Event.setText(events.getEVENT());
        holder.DateTxt.setText(events.getDATE());
        holder.Time.setText(events.getTIME());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView DateTxt, Event, Time;
        public MyViewHolder(View view){
            super(view);
            DateTxt = view.findViewById(R.id.eventDate);
            Event = view.findViewById(R.id.eventName);
            Time = view.findViewById(R.id.eventTime);
        }
    }
}
