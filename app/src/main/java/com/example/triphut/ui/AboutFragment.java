package com.example.triphut.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.triphut.R;
import com.example.triphut.profile_fragment;

public class AboutFragment extends Fragment implements View.OnClickListener{
//    private TextView mproname,mproemail,mpronid,mprophone;
//    private Button mprologout,contact;
//    private FirebaseAuth firebaseAuth;
//    private FirebaseUser user;
//    private DatabaseReference reference;
//    private String userID;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.about_fragment,container,false);

        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.aboutwrapper, new profile_fragment());
        ft.commit();


        return view;



    }

    @Override
    public void onClick(View view) {


//        if(view == mprologout){
//            firebaseAuth.signOut();
//            Intent intent = new Intent(getActivity(), login.class);
//            startActivity(intent);
//        }
//        if(view==contact){
//
//            AppCompatActivity activity = (AppCompatActivity)getContext();
//            activity.getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.aboutwrapper,new AboutUs())
//                    .addToBackStack(null).commit();
//        }

    }
}