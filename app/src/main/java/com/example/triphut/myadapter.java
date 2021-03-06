package com.example.triphut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {


    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

        holder.placetext.setText(model.getPlace());
        holder.hoteltext.setText(model.getHotel());
        holder.duratext.setText(model.getDuration());
        holder.costtext.setText(model.getCost());
        Glide.with(holder.img.getContext()).load(model.gettimage()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper,new descfragment(model.getPlace(),model.getHotel(),model.getCost(),model.getDuration(),model.getBrif()))
                        .addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{


        ImageView img;
        TextView placetext,hoteltext,duratext,costtext;




        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img= itemView.findViewById(R.id.tourimg);
            placetext= itemView.findViewById(R.id.placetext);
            hoteltext= itemView.findViewById(R.id.hoteltext);
            duratext= itemView.findViewById(R.id.duratext);
            costtext= itemView.findViewById(R.id.costtext);


        }
    }










}
