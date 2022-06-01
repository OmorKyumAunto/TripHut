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

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class descfragment extends Fragment {

    String place,hotel,cost,duration,details;
    Button back,book;
    ImageView btnCart;

    SliderView sliderView;
    int[] images = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven
    };

    public descfragment() {
        // Required empty public constructor
    }
    public descfragment(String place,String hotel,String cost,String duration,String details) {
        this.place = place;
        this.hotel= hotel;
        this.cost= cost;
        this.duration= duration;
        this.details= details;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descfragment, container, false);
        Button back=view.findViewById(R.id.descbackbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper,new recfragment())
                        .addToBackStack(null).commit();

            }
        });

        Button book =view.findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper,new tripbook())
                        .addToBackStack(null).commit();
            }
        });


        btnCart=(ImageView)view.findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        sliderView =(SliderView)view.findViewById(R.id.imageslider);


        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);

        sliderView.startAutoCycle();



        TextView placeholder = view.findViewById(R.id.placeholder);
        TextView hotelholder = view.findViewById(R.id.hotelholder);
        TextView costholder = view.findViewById(R.id.costholder);
        TextView duraholder = view.findViewById(R.id.duraholder);
        TextView detailsholder = view.findViewById(R.id.detailsholder);

        placeholder.setText(place);
        hotelholder.setText("Resort : "+hotel);
        costholder.setText("Total Cost : "+cost);
        duraholder.setText("Duration : "+duration);
        detailsholder.setText("Short Brif \n"+details);


        return view;
    }

}