package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Main_menu extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
//    private ImageView imhome, immessage, imoldpeople, imfacility;
//    private TextView txhome, txmessage, txoldpeople, txfacility;
    private LinearLayout llhome, llmessage, lloldpeople, llfacility, llcurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initPager();
        initTabView();
    }

    public void initPager(){
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("1"));
        fragments.add(BlankFragment.newInstance("2"));
        fragments.add(BlankFragment.newInstance("3"));
        fragments.add(BlankFragment.newInstance("4"));
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    public void initTabView(){
//        imhome = findViewById(R.id.home);
//        immessage = findViewById(R.id.message);
//        imoldpeople = findViewById(R.id.old_people);
//        imfacility = findViewById(R.id.facility);
//        txhome = findViewById(R.id.text_home);
//        txmessage = findViewById(R.id.text_message);
//        txoldpeople = findViewById(R.id.text_old_people);
//        txfacility = findViewById(R.id.text_facility);

        llcurrent = llhome = findViewById(R.id.tab_home);
        llhome.setOnClickListener(this::onClick);
        llmessage = findViewById(R.id.tab_message);
        llmessage.setOnClickListener(this);
        lloldpeople = findViewById(R.id.tab_old_people);
        lloldpeople.setOnClickListener(this);
        llfacility = findViewById(R.id.tab_facility);
        llfacility.setOnClickListener(this);

        findViewById(R.id.home).setSelected(true);
        findViewById(R.id.text_home).setSelected(true);
    }

    public void changeTab(int position){
        setLLSelected(llcurrent, false);
        switch (position){
            case R.id.tab_home:
                viewPager.setCurrentItem(0);
            case 0:
                setLLSelected(llhome, true);
                llcurrent = llhome;
                break;
            case R.id.tab_message:
                    viewPager.setCurrentItem(1);
            case 1:
                setLLSelected(llmessage, true);
                llcurrent = llmessage;
                break;
            case R.id.tab_old_people:
                viewPager.setCurrentItem(2);
            case 2:
                setLLSelected(lloldpeople, true);
                llcurrent = lloldpeople;
                break;
            case R.id.tab_facility:
                viewPager.setCurrentItem(3);
            case 3:
                setLLSelected(llfacility, true);
                llcurrent = llfacility;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        LinearLayout ll = (LinearLayout) view;
        if(llcurrent != ll){
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat((ImageView)ll.getChildAt(0), "ScaleX", (float) 1.0, (float)1.17, (float)1.0);
            objectAnimator1.setDuration(500);
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((ImageView)ll.getChildAt(0), "ScaleY", (float) 1.0, (float)1.17, (float)1.0);
            objectAnimator2.setDuration(500);
            objectAnimator1.start();
            objectAnimator2.start();
        }
        changeTab(view.getId());
    }

    void setLLSelected(LinearLayout ll, boolean condition){
        for (int i = 0; i < ll.getChildCount(); i++){
            ll.getChildAt(i).setSelected(condition);
        }
    }
}