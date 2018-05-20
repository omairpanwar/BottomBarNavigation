package com.umairpanwar.bottombarnavigation.activites;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.umairpanwar.bottombarnavigation.R;
import com.umairpanwar.bottombarnavigation.fragments.FragmentOne;
import com.umairpanwar.bottombarnavigation.fragments.FragmentThree;
import com.umairpanwar.bottombarnavigation.fragments.FragmentTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    @BindView(R.id.main_bottom_nav)
    BottomNavigationView bottomNavigationView;

    private FragmentOne fragment1;
    private FragmentTwo fragment2;
    private FragmentThree fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragment1 = new FragmentOne();
        fragment2 = new FragmentTwo();
        fragment3 = new FragmentThree();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayot,fragment1)
                .commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_favorites:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayot,fragment1)
                                .commit();
                        return true;
                    }
                    case  R.id.action_schedules:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayot,fragment2)
                                .commit();
                        return true;
                    }

                    case R.id.action_music:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayot,fragment3)
                                .commit();
                        return true;
                    }

                }
                return false;
            }
        });
    }
}
