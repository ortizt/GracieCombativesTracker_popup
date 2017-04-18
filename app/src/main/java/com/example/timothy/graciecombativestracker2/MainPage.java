package com.example.timothy.graciecombativestracker2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ToggleButton;
import android.content.Intent;
import android.content.ActivityNotFoundException;



public class MainPage extends AppCompatActivity {

    private ProgressBar beltstripe1 = null;
    private ProgressBar beltstripe2 = null;
    private ProgressBar beltstripe3 = null;
    private ProgressBar beltstripe4 = null;
    private ToggleButton c1button1 = null;
    private ToggleButton c1button2 = null;
    private ToggleButton c2button1 = null;
    private ToggleButton c2button2 = null;
    private ToggleButton c3button1 = null;
    private ToggleButton c3button2 = null;
    private ToggleButton c4button1 = null;
    private ToggleButton c4button2 = null;
    private ToggleButton cs1 = null;
    private ToggleButton cs2 = null;
    private ToggleButton cs3 = null;
    private ToggleButton cs4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        findViewById(R.id.c1button1).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c1button2).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c2button1).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c2button2).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c3button1).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c3button2).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c4button1).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c4button2).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c1_traproll).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c1_leghook).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c2_americana).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c2_clinch).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c3_pos).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c3_body).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c4_take).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c4_clinch).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c1).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c2).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c3).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.c4).setOnClickListener(mGlobal_OnClickListener);
        beltstripe1 = (ProgressBar)findViewById(R.id.beltstripe1);
        beltstripe2 = (ProgressBar)findViewById(R.id.beltstripe2);
        beltstripe3 = (ProgressBar)findViewById(R.id.beltstripe3);
        beltstripe4 = (ProgressBar)findViewById(R.id.beltstripe4);
        c1button1 = (ToggleButton)findViewById(R.id.c1button1);
        c1button2 = (ToggleButton)findViewById(R.id.c1button2);
        c2button1 = (ToggleButton)findViewById(R.id.c2button1);
        c2button2 = (ToggleButton)findViewById(R.id.c2button2);
        c3button1 = (ToggleButton)findViewById(R.id.c3button1);
        c3button2 = (ToggleButton)findViewById(R.id.c3button2);
        c4button1 = (ToggleButton)findViewById(R.id.c4button1);
        c4button2 = (ToggleButton)findViewById(R.id.c4button2);
        cs1 = (ToggleButton)findViewById(R.id.c1);
        cs2 = (ToggleButton)findViewById(R.id.c2);
        cs3 = (ToggleButton)findViewById(R.id.c3);
        cs4 = (ToggleButton)findViewById(R.id.c4);

    }

    void openUrlInChrome(String url) {
        try {
            try {
                Uri uri = Uri.parse("googlechrome://navigate?url="+ url);
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            } catch (ActivityNotFoundException e) {
                Uri uri = Uri.parse(url);
                // Chrome is probably not installed
                // OR not selected as default browser OR if no Browser is selected as default browser
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        } catch (Exception ex) {
        }
    }

    //Global On click listener for all views
    final OnClickListener mGlobal_OnClickListener = new OnClickListener() {
        public void onClick(final View v) {
                int progress1 = beltstripe1.getProgress();
                int progress2 = beltstripe2.getProgress();
                int progress3 = beltstripe3.getProgress();
                int progress4 = beltstripe4.getProgress();
            switch(v.getId()) {
                case R.id.c1button1:
                    if(c1button1.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c1button1.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c1button1.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c1button1.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c1button1.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c1button1.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c1button1.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c1button1.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }

                    if(c1button1.isChecked() && c1button2.isChecked()){
                        cs1.setBackgroundResource(R.drawable.classcheck0);
                        cs1.setClickable(true);
                    }
                    else {
                        cs1.setBackgroundResource(R.drawable.bordershape);
                        cs1.setClickable(false);
                    }
                    break;

                case R.id.c1button2:
                    if(c1button2.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c1button2.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c1button2.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c1button2.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c1button2.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c1button2.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c1button2.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c1button2.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }

                    if(c1button1.isChecked() && c1button2.isChecked()){
                        cs1.setBackgroundResource(R.drawable.classcheck0);
                        cs1.setClickable(true);
                    }
                    else {
                        cs1.setBackgroundResource(R.drawable.bordershape);
                        cs1.setClickable(false);
                    }
                    break;

                case R.id.c1:
                    if(cs1.isChecked()){
                        cs1.setBackgroundResource(R.drawable.classcheck1);
                    }
                    else if (!cs1.isChecked()){
                        cs1.setBackgroundResource(R.drawable.classcheck0);
                    }

                    if(cs1.isChecked() && progress1 < 100){
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(cs1.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(cs1.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(cs1.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!cs1.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs1.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!cs1.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs1.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    break;

                case R.id.c1_traproll:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=MhEfILAfdnhgTBe9W6i%2bPQ%3d%3d");
                    break;

                case R.id.c1_leghook:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=dkG2PaKrWHkbW%2bHxxa7%2bXA%3d%3d");
                    break;

                case R.id.c2button1:
                    if(c2button1.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c2button1.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c2button1.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c2button1.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c2button1.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c2button1.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c2button1.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c2button1.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c2button1.isChecked() && c2button2.isChecked()){
                        cs2.setBackgroundResource(R.drawable.classcheck0);
                        cs2.setClickable(true);
                    }
                    else {
                        cs2.setBackgroundResource(R.drawable.bordershape);
                        cs2.setClickable(false);
                    }
                    break;

                case R.id.c2button2:
                    if(c2button2.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c2button2.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c2button2.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c2button2.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c2button2.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c2button2.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c2button2.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c2button2.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c2button1.isChecked() && c2button2.isChecked()){
                        cs2.setBackgroundResource(R.drawable.classcheck0);
                        cs2.setClickable(true);
                    }
                    else {
                        cs2.setBackgroundResource(R.drawable.bordershape);
                        cs2.setClickable(false);
                    }
                    break;

                case R.id.c2:
                    if(cs2.isChecked()){
                        cs2.setBackgroundResource(R.drawable.classcheck1);
                    }
                    else if (!cs2.isChecked()){
                        cs2.setBackgroundResource(R.drawable.classcheck0);
                    }

                    if(cs2.isChecked() && progress1 < 100){
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(cs2.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(cs2.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(cs2.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!cs2.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs2.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!cs2.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs2.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    break;

                case R.id.c2_americana:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=E34hsiuYxJBoYG1ZYMYFqg%3d%3d");
                    break;

                case R.id.c2_clinch:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=Hr2JJ9XHJ4SOr78tucuRHQ%3d%3d");
                    break;

                case R.id.c3button1:
                    if(c3button1.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c3button1.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c3button1.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c3button1.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c3button1.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c3button1.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c3button1.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c3button1.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c3button1.isChecked() && c3button2.isChecked()){
                        cs3.setBackgroundResource(R.drawable.classcheck0);
                        cs3.setClickable(true);
                    }
                    else {
                        cs3.setBackgroundResource(R.drawable.bordershape);
                        cs3.setClickable(false);
                    }
                    break;

                case R.id.c3button2:
                    if(c3button2.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c3button2.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c3button2.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c3button2.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c3button2.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c3button2.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c3button2.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c3button2.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c3button1.isChecked() && c3button2.isChecked()){
                        cs3.setBackgroundResource(R.drawable.classcheck0);
                        cs3.setClickable(true);
                    }
                    else {
                        cs3.setBackgroundResource(R.drawable.bordershape);
                        cs3.setClickable(false);
                    }
                    break;

                case R.id.c3:
                    if(cs3.isChecked()){
                        cs3.setBackgroundResource(R.drawable.classcheck1);
                    }
                    else if (!cs3.isChecked()){
                        cs3.setBackgroundResource(R.drawable.classcheck0);
                    }

                    if(cs3.isChecked() && progress1 < 100){
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(cs3.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(cs3.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(cs3.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!cs3.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs3.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!cs3.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs3.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    break;

                case R.id.c3_pos:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=%2fK0yibt2OqvBNyMjUfU2MQ%3d%3d");
                    break;

                case R.id.c3_body:
                    openUrlInChrome("http://www.gracieuniversity.com/mobile/lessons.aspx?enc=0A0xm2Fjkj%2bhWYfuqYtD6A%3d%3d");
                    break;

                case R.id.c4button1:
                    if(c4button1.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c4button1.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c4button1.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c4button1.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c4button1.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c4button1.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c4button1.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c4button1.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c4button1.isChecked() && c4button2.isChecked()){
                        cs4.setBackgroundResource(R.drawable.classcheck0);
                        cs4.setClickable(true);
                    }
                    else {
                        cs4.setBackgroundResource(R.drawable.bordershape);
                        cs4.setClickable(false);
                    }
                    break;

                case R.id.c4button2:
                    if(c4button2.isChecked() && progress1 < 100) {
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(c4button2.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(c4button2.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(c4button2.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!c4button2.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c4button2.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!c4button2.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!c4button2.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    if(c4button1.isChecked() && c4button2.isChecked()){
                        cs4.setBackgroundResource(R.drawable.classcheck0);
                        cs4.setClickable(true);
                    }
                    else {
                        cs4.setBackgroundResource(R.drawable.bordershape);
                        cs4.setClickable(false);
                    }
                    break;

                case R.id.c4:
                    if(cs4.isChecked()){
                        cs4.setBackgroundResource(R.drawable.classcheck1);
                    }
                    else if (!cs4.isChecked()){
                        cs4.setBackgroundResource(R.drawable.classcheck0);
                    }

                    if(cs4.isChecked() && progress1 < 100){
                        beltstripe1.incrementProgressBy(5);
                    }
                    else if(cs4.isChecked() && progress1 == 100 && progress2 < 100) {
                        beltstripe2.incrementProgressBy(5);
                    }
                    else if(cs4.isChecked() && progress2 == 100 && progress3 < 100) {
                        beltstripe3.incrementProgressBy(5);
                    }
                    else if(cs4.isChecked() && progress3 == 100 && progress4 < 100) {
                        beltstripe4.incrementProgressBy(5);
                    }
                    else if(!cs4.isChecked() && progress1 > 0 && progress1 <=100 && progress2 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs4.isChecked() && progress2 > 0 && progress2 <=100 && progress3 == 0) {
                        beltstripe2.incrementProgressBy(-5);
                    }
                    else if(!cs4.isChecked() && progress3 > 0 && progress3 <=100 && progress4 == 0) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    else if(!cs4.isChecked() && progress4 > 0 && progress4 <=100) {
                        beltstripe1.incrementProgressBy(-5);
                    }
                    break;

                case R.id.c4_take:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=d9COFgiEGp0ucINiM6G08w%3d%3d");
                    break;
                case R.id.c4_clinch:
                    openUrlInChrome("www.gracieuniversity.com/mobile/lessons.aspx?enc=Ki5CHRbu984jOKpGeVjNQQ%3d%3d");
                    break;
            }
        }
    };

}
