package com.example.triphut.Places;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.triphut.R;
import com.example.triphut.SliderAdapter;
import com.example.triphut.dashboard;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Coxbazar extends Fragment {
    SliderView sliderView;
    Button back;
    int[] images = {
            R.drawable.plccoxone,
            R.drawable.plccoxtwo,
            R.drawable.plccoxthree,
            R.drawable.plccoxfour
    };

    public Coxbazar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_coxbazar, container, false);
        sliderView =(SliderView)view.findViewById(R.id.imageslider);


        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);

        sliderView.startAutoCycle();

        back=(Button)view.findViewById(R.id.placeback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_container,new dashboard())
                        .addToBackStack(null).commit();
            }
        });

        return view;
    }
}