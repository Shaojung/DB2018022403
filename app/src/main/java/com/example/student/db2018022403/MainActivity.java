package com.example.student.db2018022403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
    }
    public void click1(View v)
    {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i=5;i>=0;i--)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c = i;
                    Log.d("LOG", "倒數:" + i);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(String.valueOf(c));
                        }
                    });

                }
            }
        }.start();

    }
}
