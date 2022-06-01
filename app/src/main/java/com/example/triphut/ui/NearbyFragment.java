package com.example.triphut.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triphut.CarAdapter;
import com.example.triphut.Carrrecfrag;
import com.example.triphut.R;

public class NearbyFragment extends Fragment {
    RecyclerView Carrecview;
    CarAdapter carAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nearby_fragment, container, false);
//        Carrecview=(RecyclerView)view.findViewById(R.id.Carrecview);
//        Carrecview.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        FirebaseRecyclerOptions<Carmodel> options =
//                new FirebaseRecyclerOptions.Builder<Carmodel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drivers"),Carmodel.class)
//                        .build();
//
//
//        carAdapter= new CarAdapter(options);
//        Carrecview.setAdapter(carAdapter);
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.carWrapper, new Carrrecfrag());
        ft.commit();

        return view;



    }
//public void onStart(){
//        super.onStart();
//        carAdapter.startListening();
//}
//public void onStop(){
//        super.onStop();
//        carAdapter.stopListening();
//}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}