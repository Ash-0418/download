package com.example.myapplication16;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ProgressDialog p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=new ProgressDialog(this);

    }//onCreate
    public void start(View v){
        p.setCancelable(true);
        p.setMessage("다운로드 중");
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setProgress(0);
        p.setMax(100);
        p.show();

        Thread t= new Thread(){
            public void run(){
                int time=0;
                while(time<100){
                    try{
                        Thread.sleep(1000);
                        time+=10;
                        p.setProgress(time);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }//while
            }//run
        };//Thread
    }//start

}//class