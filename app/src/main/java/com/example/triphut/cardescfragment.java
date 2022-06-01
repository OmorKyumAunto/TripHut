package com.example.triphut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class cardescfragment extends Fragment {
    String Carmodel,Pimage,Liesence,Name,Number,Rent;
    Button back;

    public cardescfragment() {
        // Required empty public constructor
    }
    public cardescfragment(String Carmodel,String Pimage,String Liesence,String Name,String Number,String Rent) {
        this.Carmodel=Carmodel;
        this.Pimage=Pimage;
        this.Liesence=Liesence;
        this.Name=Name;
        this.Number=Number;
        this.Rent=Rent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_cardescfragment, container, false);

        ImageView carimgholder=view.findViewById(R.id.carimgholder);
        TextView modelholder = view.findViewById(R.id.modelholder);
        TextView rentholder = view.findViewById(R.id.rentholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView lieholder = view.findViewById(R.id.lieholder);
        TextView numholder = view.findViewById(R.id.numholder);
        Button back=view.findViewById(R.id.backbutton);
        Button hire=view.findViewById(R.id.hirebutton);
        hire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.carWrapper,new Carbook())
                        .addToBackStack(null).commit();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.carWrapper,new Carrrecfrag())
                        .addToBackStack(null).commit();

            }
        });




        modelholder.setText(Carmodel);
        rentholder.setText("Average Rent/Day :"+Rent+"TK");
        nameholder.setText("Driver Name : "+Name);
        lieholder.setText("Liesence No :"+Liesence);
        numholder.setText("Number : "+Number);
        Glide.with(getContext()).load(Pimage).into(carimgholder);


        return view;
    }


}