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

public class recfragment extends Fragment {

    RecyclerView recview;
    myadapter adapter;


    public recfragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recfragment, container, false);

        recview=(RecyclerView)view.findViewById(R.id.recview);

        recview.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<model> options =
        new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"), model.class)
                .build();

        adapter= new myadapter(options);
        recview.setAdapter(adapter);


        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }


}