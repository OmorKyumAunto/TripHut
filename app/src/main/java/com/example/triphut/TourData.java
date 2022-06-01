package com.example.triphut;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TourData extends AppCompatActivity {

    private EditText mplace,mduration,mhotel,mbrif,mcost;
    private Button button;
    private ImageView buttonlg;


    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_data);
        mplace = findViewById(R.id.textplace);
        mduration = findViewById(R.id.textDuration);
        mhotel = findViewById(R.id.textHotel);
        mbrif = findViewById(R.id.textdetails);
        mcost = findViewById(R.id.textcost);
        button = findViewById(R.id.btnsend);
        buttonlg= findViewById(R.id.backbtn);


        buttonlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),agent_login.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String place = mplace.getText().toString();
                String duration = mduration.getText().toString();
                String hotel = mhotel.getText().toString();
                String brif = mbrif.getText().toString();
                String cost = mcost.getText().toString();

                if(TextUtils.isEmpty(place)){
                    mplace.setError("Place Is Required");
                    return;
                }

                if(TextUtils.isEmpty(brif)){
                    mbrif.setError("Details Is Required");
                    return;
                }

                HashMap<String , String> userMap = new HashMap<>();
                userMap.put("Place",place);
                userMap.put("Duration",duration);
                userMap.put("Hotel",hotel);
                userMap.put("Details",brif);
                userMap.put("Cost",cost);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(TourData.this, "Tour Data Sent", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });


    }
}