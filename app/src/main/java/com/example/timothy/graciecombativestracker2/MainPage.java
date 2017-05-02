package com.example.timothy.graciecombativestracker2;

import android.app.Activity;
import android.app.TabActivity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ToggleButton;
import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.widget.TabHost;
import android.widget.FrameLayout;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.graphics.Color;

public class MainPage extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("course_tracker").setIndicator("Course Tracker").setContent(new Intent(this, course_tracker.class)));
        mTabHost.addTab(mTabHost.newTabSpec("reflex_development").setIndicator("Reflex Development").setContent(new Intent(this, reflex_development.class)));
        mTabHost.addTab(mTabHost.newTabSpec("student_info").setIndicator("Student Info").setContent(new Intent(this, student_info.class)));
        mTabHost.setCurrentTab(2);
        mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#3d3d3d"));
        mTabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#3d3d3d"));
        mTabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#3d3d3d"));
        mTabHost.getTabWidget().getChildAt(0).setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        mTabHost.getTabWidget().getChildAt(1).setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        mTabHost.getTabWidget().getChildAt(2).setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        ShareData.data().belt1 = 0;
        ShareData.data().belt2 = 0;
        ShareData.data().belt3 = 0;
        ShareData.data().belt4 = 0;
        ShareData.data().name = "Joshua Stanford";
        ShareData.data().ttlcr = 0;
        ShareData.data().ttlrd = 0;
    }
}

