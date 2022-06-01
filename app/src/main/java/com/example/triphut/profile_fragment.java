package com.example.triphut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile_fragment extends Fragment implements View.OnClickListener{
    private TextView mproname,mproemail,mpronid,mprophone;
    private Button mprologout,contact;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    public profile_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){

            Intent intent = new Intent(getActivity(), login.class);
            startActivity(intent);
        }



        user = FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();

        mproname =(TextView)view.findViewById(R.id.proname);
        mproemail =(TextView)view.findViewById(R.id.proemail);
        mpronid =(TextView)view.findViewById(R.id.pronid);
        mprophone =(TextView)view.findViewById(R.id.prophone);

        mprologout = (Button)view.findViewById(R.id.prologout);
        contact= (Button)view.findViewById(R.id.contactus);
        mprologout.setOnClickListener(this);
        contact.setOnClickListener(this);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile !=null){
                    String name = userProfile.name;
                    String email = userProfile.email;
                    String nid = userProfile.nid;
                    String phone = userProfile.phone;

                    mproname.setText("Welcome\n"+ name +" ");
                    mproemail.setText(email);
                    mpronid.setText("NID "+nid);
                    mprophone.setText(phone);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),"Somthing Wrong Happend!", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == mprologout){
            firebaseAuth.signOut();
            Intent intent = new Intent(getActivity(), login.class);
            startActivity(intent);
        }
        if(view==contact){

            AppCompatActivity activity = (AppCompatActivity)getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.aboutwrapper,new AboutUs())
                    .addToBackStack(null).commit();
        }

    }
}