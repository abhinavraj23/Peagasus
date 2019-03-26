package com.example.peagasus;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class example_activity_homepage extends AppCompatActivity {

    TabLayout tabLayout;
    View v;
    TextView tab;
    ImageView img;

    int greyImg[] = {R.drawable.ic_house_grey,R.drawable.ic_bulb_grey,R.drawable.ic_calender_grey};
    int blueImg[] = {R.drawable.ic_house_blue,R.drawable.ic_bulb_blue,R.drawable.ic_calender_blue};

    ImageButton clickbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_homepage);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        setTitle("");


        tabLayout =  findViewById(R.id.tabLayout);
        setupTabIcons();

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow popupwindow_obj = popupDisplay();
                popupwindow_obj.showAsDropDown(clickbtn,clickbtn.getLeft(), 0 , Gravity.TOP); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);
                //popupwindow_obj.showAsDropDown(findViewById(R.id.base));
            }
        });

    }

    public PopupWindow popupDisplay(){

        final PopupWindow popupWindow = new PopupWindow(this);

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.popup_menu, null);

        Button item = view.findViewById(R.id.button2);

        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);

        return popupWindow;
    }

    private void setupTabIcons() {
        tabLayout.setSelectedTabIndicator(R.color.transparent);
        v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab = v.findViewById(R.id.tab);
        img = v.findViewById(R.id.tabIco);
        tab.setText("Rooms");
        tab.setTextColor(getResources().getColor(R.color.blue));
        img.setImageDrawable(getDrawable(R.drawable.ic_house_blue));
        tabLayout.getTabAt(0).setCustomView(v);
        //set recycler view adapter here




        View v1 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tab1 = v1.findViewById(R.id.tab);
        ImageView img1 = v1.findViewById(R.id.tabIco);
        tab1.setText("Appliances");
        img1.setImageDrawable(getDrawable(R.drawable.ic_bulb_grey));
        tabLayout.getTabAt(1).setCustomView(v1);



        View v2 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tab2 = v2.findViewById(R.id.tab);
        ImageView img2 = v2.findViewById(R.id.tabIco);
        tab2.setText("Schedule");
        img2.setImageDrawable(getDrawable(R.drawable.ic_calender_grey));
        tabLayout.getTabAt(2).setCustomView(v2);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View selectedView = tab.getCustomView();
                TextView txt = selectedView.findViewById(R.id.tab);
                ImageView img = selectedView.findViewById(R.id.tabIco);
                txt.setTextColor(getResources().getColor(R.color.blue));
                img.setImageDrawable(getDrawable(blueImg[tab.getPosition()]));
                //update recycler view adapter here
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View selectedView = tab.getCustomView();
                TextView txt = selectedView.findViewById(R.id.tab);
                ImageView img = selectedView.findViewById(R.id.tabIco);
                txt.setTextColor(getResources().getColor(R.color.grey_secondary));
                img.setImageDrawable(getDrawable(greyImg[tab.getPosition()]));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

}


