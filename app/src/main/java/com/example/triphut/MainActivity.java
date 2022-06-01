package com.example.triphut;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.triphut.ui.AboutFragment;
import com.example.triphut.ui.Events.GalleryFragment;
import com.example.triphut.ui.NearbyFragment;
import com.example.triphut.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity{
    MeowBottomNavigation bottomNav;

    private final int ID_Home = 1;
    private final int ID_Events = 2;
    private final int ID_Map= 3;
    private final int ID_Account=4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bottomNav.add(new MeowBottomNavigation.Model(2,R.drawable.calendar));
        bottomNav.add(new MeowBottomNavigation.Model(3,R.drawable.renticon));
        bottomNav.add(new MeowBottomNavigation.Model(4,R.drawable.user));



        bottomNav.setCount(2,"4");

        bottomNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                if(item.getId()==1){
                    fragment= new HomeFragment();
                }else if(item.getId()==2){
                    fragment = new GalleryFragment();
                }else if (item.getId()==3){
                    fragment = new NearbyFragment();
                }else if(item.getId()==4){
                    fragment = new AboutFragment();
                }
                loadFragment(fragment);

             }
        });

        bottomNav.show(1,true);
        bottomNav.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });

        bottomNav.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container,fragment,null)
                .commit();
    }




    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();

                        System.exit(0);
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}