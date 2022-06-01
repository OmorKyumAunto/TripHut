package com.example.triphut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class tripbook extends Fragment {



    public tripbook() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_tripbook, container, false);

        Button back=view.findViewById(R.id.tripbackbutton);
        Button book=view.findViewById(R.id.bookbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper,new recfragment())
                        .addToBackStack(null).commit();

            }
        });


         EditText bname=(EditText)view.findViewById(R.id.bookname);
        EditText bnum=(EditText)view.findViewById(R.id.booknum);
        EditText btotal=(EditText)view.findViewById(R.id.booktotal);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("Request");
                BookdataHolder obj= new BookdataHolder(bname.getText().toString(),bnum.getText().toString(),btotal.getText().toString());
                root.child(bnum.getText().toString()).setValue(obj);
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper,new recfragment())
                        .addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Thank You.Successfully Booked a Trip", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}