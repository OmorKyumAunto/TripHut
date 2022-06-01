package com.example.triphut.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.triphut.R;
import com.example.triphut.dashboard;

public class HomeFragment extends Fragment {



   public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);
       FragmentTransaction ft = getParentFragmentManager().beginTransaction();
       ft.replace(R.id.homewrapper, new dashboard());
       ft.commit();

        return view;


    }






    @Override
    public void onStart() {

       super.onStart();

    }
    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}