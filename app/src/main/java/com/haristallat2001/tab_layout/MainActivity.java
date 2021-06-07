package com.haristallat2001.tab_layout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.icu.text.CaseMap;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
Explore_Flag explore_flag;
Flight_flag flight_flag;
Travel_flag travel_flag;
TabLayout tabLayout;
ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        viewpager=findViewById(R.id.viewpager);
        tabLayout= findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewpager);

        setSupportActionBar(toolbar);
        explore_flag= new Explore_Flag();
flight_flag= new Flight_flag();
travel_flag= new Travel_flag();

ViewPagerAdopter viewPagerAdopter= new ViewPagerAdopter(getSupportFragmentManager(), 0);
viewPagerAdopter.addFragment(explore_flag, "Explore");
viewPagerAdopter.addFragment(flight_flag,"Flight");
viewPagerAdopter.addFragment(travel_flag, "Travel");
 
        viewpager.setAdapter(viewPagerAdopter);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_explore_24);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_flight_24);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_train_24);

    }
    public class ViewPagerAdopter extends FragmentPagerAdapter
    {
List<Fragment> fragments= new ArrayList<>();
List<String> titles= new ArrayList<>();

        public ViewPagerAdopter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
public  void addFragment(Fragment fragment, String title)
{
    fragments.add(fragment);
    titles.add(title);
}

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}


