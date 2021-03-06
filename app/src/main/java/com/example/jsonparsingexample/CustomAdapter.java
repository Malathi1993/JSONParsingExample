package com.example.jsonparsingexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> Name;
    ArrayList<String>Rollno;
    ArrayList<String> Id;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> Name, ArrayList<String> Rollno, ArrayList<String> Id) {
        this.context = context;
        this.Name = Name;
        this.Rollno = Rollno;
        this.Id = Id;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.Name.setText(Name.get(position));
        holder.Rollno.setText(Rollno.get(position));
        holder.Id.setText(Id.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, Name.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Rollno, Id;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            Name = (TextView) itemView.findViewById(R.id.name);
            Rollno = (TextView) itemView.findViewById(R.id.rollno);
            Id = (TextView) itemView.findViewById(R.id.id);

        }
    }
}
