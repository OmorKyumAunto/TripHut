package com.example.triphut;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triphut.HelperClasses.adapterphone;
import com.example.triphut.HelperClasses.phonehelper;
import com.example.triphut.Places.Coxbazar;
import com.example.triphut.Places.Ratargul;
import com.example.triphut.Places.SaintMartin;
import com.example.triphut.Places.Sajek;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class dashboard extends Fragment implements adapterphone.ListItemClickListener {
    RecyclerView Recycler;
    RecyclerView.Adapter adapter;
    SliderView sliderView;
    SearchView searchView;
    int[] images = {R.drawable.ofrone,
            R.drawable.ofrtwo,
            R.drawable.ofrthree
    };


    public dashboard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        sliderView = (SliderView) view.findViewById(R.id.homeimageslider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);

        sliderView.startAutoCycle();
        searchView=(SearchView)view.findViewById(R.id.dashsearch);




        LinearLayout btn = (LinearLayout)view.findViewById(R.id.tripbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_container,new BookFragment())
                        .addToBackStack(null).commit();
            }
        });
        LinearLayout btn2 = (LinearLayout)view.findViewById(R.id.caragbtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_container,new BookFragment())
                        .addToBackStack(null).commit();
            }
        });


        Recycler = (RecyclerView) view.findViewById(R.id.my_recycler);
        Recycler();


        return view;
    }

    private void Recycler() {


        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        Recycler.setHasFixedSize(true);
        Recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(gradient1, R.drawable.rccox, "Cox's Bazar"));
        phonelocations.add(new phonehelper(gradient3, R.drawable.rcrata, "Ratargul"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.rcsaint, "Saint Martin"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.rcsajek, "Sajek"));


        adapter = new adapterphone(phonelocations, this);
        Recycler.setAdapter(adapter);
    }


    @Override
    public void onphoneListClick(int clickedItemIndex) {
        Fragment fragment = null;

        if (clickedItemIndex == 0) {
            fragment = new Coxbazar();
        } else if (clickedItemIndex == 1) {
            fragment = new Ratargul();
        } else if (clickedItemIndex == 2) {
            fragment = new SaintMartin();

        } else if (clickedItemIndex == 3) {
            fragment = new Sajek();
        }

        loadFragment(fragment);

    }

    private void loadFragment(Fragment fragment) {

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container, fragment, null)
                .commit();
    }
}