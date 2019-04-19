package com.hie2j.materialdesign_viewpagertallayout;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private MyFragmentAdapter adapter;

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initfragmentArrayList();
        viewPager = findViewById(R.id.viewpager);
        adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentArrayList);
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                switch (i){
                    case 0:
                        txt1.setBackgroundColor(Color.RED);
                        txt2.setBackgroundColor(Color.GREEN);
                        txt3.setBackgroundColor(Color.GREEN);
                        txt4.setBackgroundColor(Color.GREEN);
                        break;
                    case 1:
                        txt1.setBackgroundColor(Color.GREEN);
                        txt2.setBackgroundColor(Color.RED);
                        txt3.setBackgroundColor(Color.GREEN);
                        txt4.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        txt1.setBackgroundColor(Color.GREEN);
                        txt2.setBackgroundColor(Color.GREEN);
                        txt3.setBackgroundColor(Color.RED);
                        txt4.setBackgroundColor(Color.GREEN);
                        break;
                    case 3:
                        txt1.setBackgroundColor(Color.GREEN);
                        txt2.setBackgroundColor(Color.GREEN);
                        txt3.setBackgroundColor(Color.GREEN);
                        txt4.setBackgroundColor(Color.RED);
                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        initTabLayout();
    }

    private void initTabLayout() {
        tabLayout = findViewById(R.id.tl_tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt1.setBackgroundColor(Color.RED);
        txt2.setBackgroundColor(Color.GREEN);
        txt3.setBackgroundColor(Color.GREEN);
        txt4.setBackgroundColor(Color.GREEN);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });
    }

    private void initfragmentArrayList() {
        MessageFragment messageFragment = new MessageFragment();
        ContentFragment contentFragment = new ContentFragment();
        FindFragment findFragment = new FindFragment();
        MyFragment myFragment = new MyFragment();
        fragmentArrayList.add(messageFragment);
        fragmentArrayList.add(contentFragment);
        fragmentArrayList.add(findFragment);
        fragmentArrayList.add(myFragment);
    }


}
