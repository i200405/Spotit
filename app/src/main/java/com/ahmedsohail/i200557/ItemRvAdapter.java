package com.ahmedsohail.i200557;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemRvAdapter extends RecyclerView.Adapter<ItemRvAdapter.MyViewHolder> {

    List<Items> ls;
    Context c;


    
    public ItemRvAdapter(List<Items> ls, Context c) {
        this.c=c;
        this.ls=ls;
    }

    @NonNull
    @Override
    public ItemRvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(c).inflate(R.layout.item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRvAdapter.MyViewHolder holder, int position) {

        holder.itemName.setText(ls.get(position).getItemName());
        holder.price.setText(ls.get(position).getPrice());
        holder.location.setText(ls.get(position).getLocation());
        holder.date.setText(ls.get(position).getDate());

       /* holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(c, item.class);

                // Pass data to the new activity if needed
               // intent.putExtra("key", ls.get(position).getItemName());

                // Start the new activity
                c.startActivity(intent);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, date, price, location;
        LinearLayout l1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.itemName);
            price=itemView.findViewById(R.id.price);
            location=itemView.findViewById(R.id.location);
            date=itemView.findViewById(R.id.date);

            //l1=itemView.findViewById(R.id.l1);

        }
    }
}
