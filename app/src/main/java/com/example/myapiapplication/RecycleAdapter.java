package com.example.myapiapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<com.example.myapiapplication.RecycleAdapter.MyViewHolder> {

    private Context mContext;
    private List<WeatherObject> cData;
    Bitmap temp;
    public RecycleAdapter(Context mContext, List<WeatherObject> cdata) {
        this.mContext = mContext;
        this.cData = cdata;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.recycleweather,parent,false);

        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvDate.setText(cData.get(position).getDate());
        holder.tvMaxTemp.setText(cData.get(position).getMax_temp());
        holder.tvMinTemp.setText(cData.get(position).getMin_temp());
        holder.imageView.setImageBitmap(cData.get(position).getBitmap());
    }
    @Override
    public int getItemCount()
    {
        return cData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate, tvMaxTemp, tvMinTemp;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvMaxTemp = (TextView) itemView.findViewById(R.id.tvMaxTemp);
            tvMinTemp = (TextView) itemView.findViewById(R.id.tvMinTemp);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
