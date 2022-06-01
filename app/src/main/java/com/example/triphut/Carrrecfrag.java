package com.example.triphut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Carrrecfrag extends Fragment {
    RecyclerView Carrecview;
    CarAdapter carAdapter;


    public Carrrecfrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrrecfrag, container, false);

        Carrecview=(RecyclerView)view.findViewById(R.id.Carrecview);

        Carrecview.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<Carmodel> options =
                new FirebaseRecyclerOptions.Builder<Carmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drivers"), Carmodel.class)
                        .build();

        carAdapter= new CarAdapter(options);
        Carrecview.setAdapter(carAdapter);


        return view;
    }

    public void onStart(){
        super.onStart();
        carAdapter.startListening();
    }
    public void onStop(){
        super.onStop();
        carAdapter.stopListening();
    }

}