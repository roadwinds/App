package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main_menu extends AppCompatActivity implements View.OnClickListener {

    private ImageView imhome, immessage, imoldpeople, imfacility;
    private LinearLayout llhome, llmessage, lloldpeople, llfacility, llcurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initTabView();
    }

    public void initTabView(){
        imhome = findViewById(R.id.home);
        immessage = findViewById(R.id.message);
        imoldpeople = findViewById(R.id.old_people);
        imfacility = findViewById(R.id.facility);

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

    @Override
    public void onClick(View view) {
        for (int i = 0; i < llcurrent.getChildCount(); i++){
            llcurrent.getChildAt(i).setSelected(false);
        }

        LinearLayout ll = (LinearLayout) view;
        if(llcurrent != ll){
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat((ImageView)ll.getChildAt(0), "ScaleX", (float) 1.0, (float)1.17, (float)1.0);
            objectAnimator1.setDuration(500);
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((ImageView)ll.getChildAt(0), "ScaleY", (float) 1.0, (float)1.17, (float)1.0);
            objectAnimator2.setDuration(500);
            objectAnimator1.start();
            objectAnimator2.start();
        }

        for (int i = 0; i < ll.getChildCount(); i++){
            ll.getChildAt(i).setSelected(true);
        }
        llcurrent = ll;
    }
}