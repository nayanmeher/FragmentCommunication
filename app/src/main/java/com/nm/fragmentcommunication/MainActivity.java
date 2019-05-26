package com.nm.fragmentcommunication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    EditText editText;
    Button sendF1;
    Button sendF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tabLayout= findViewById(R.id.tabs);
         viewPager= findViewById(R.id.viewPager);

         tabLayout.addTab(tabLayout.newTab().setText("Frag1"));
         tabLayout.addTab(tabLayout.newTab().setText("Frag2"));
         tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

         MyViewPagerAdepter adepter= new MyViewPagerAdepter(getSupportFragmentManager(), this, tabLayout.getTabCount());
         viewPager.setAdapter(adepter);

         viewPager. addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 viewPager.setCurrentItem(tab.getPosition());
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });

         editText= findViewById(R.id.ma_ipText);
         sendF1= findViewById(R.id.btn_ma_sendtoact);
         sendF2= findViewById(R.id.btn_ma_sendtofrg);
         String iPTxt= editText.getText().toString();
         final Bundle bundle= new Bundle();
         bundle.putString("msg", iPTxt);
         sendF1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                Fragment1 f1= new Fragment1();
                f1.setArguments(bundle);
             }
         });



    }
}
