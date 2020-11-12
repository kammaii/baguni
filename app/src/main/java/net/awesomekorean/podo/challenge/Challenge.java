package net.awesomekorean.podo.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import net.awesomekorean.podo.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Challenge extends AppCompatActivity {

    FragmentPagerAdapter adapter;
    ArrayList<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.benefits_ads);
        imageList.add(R.drawable.benefits_lessons);
        imageList.add(R.drawable.benefits_progress);
        imageList.add(R.drawable.benefits_points);

        ViewPager viewPager = findViewById(R.id.viewPager);
        adapter = new ChallengeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }
}
