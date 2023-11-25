package com.example.finance;



import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Item> items;


    public MyAdapter(List<Item> items) {
        this.items = items;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1,parent,false)) {
        };
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView title = holder.itemView.findViewById(R.id.title);
        TextView money = holder.itemView.findViewById(R.id.money);
        TextView date = holder.itemView.findViewById(R.id.date);
        ImageView arrow = holder.itemView.findViewById(R.id.arrow_card);
        CardView cardView = holder.itemView.findViewById(R.id.cardwitharrow);
        if(this.items.get(position).getBol()) {
            title.setText(this.items.get(position).getTitle());
            money.setTextColor(Color.parseColor("#14A098"));
            money.setText(String.format("+" + this.items.get(position).getMoney() + " RUB"));
            date.setText(this.items.get(position).getDate());
            cardView.setCardBackgroundColor(Color.parseColor("#14A098"));
            arrow.setImageResource(R.drawable.arrow_up);
        }
        else{
            title.setText(this.items.get(position).getTitle());
            money.setTextColor(Color.parseColor("#CB2D6F"));
            money.setText(String.format("-" + this.items.get(position).getMoney() + " RUB"));
            date.setText(this.items.get(position).getDate());
            cardView.setCardBackgroundColor(Color.parseColor("#CB2D6F"));
            arrow.setImageResource(R.drawable.arrow_down);

        }

    }


    
    @Override
    public int getItemCount() {
        return this.items.size();
    }

}