package com.example.hp.boradcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
//배터리 리시버, 알림
public class MainActivity extends AppCompatActivity {
            BatterWatchBr mBatterWatchBr;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mBatterWatchBr = new BatterWatchBr();

            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_BATTERY_LOW);
          // filter.addAction(Intent.ACTION_BATTERY_CHANGED);

            registerReceiver(mBatterWatchBr, filter);

        }
    protected void onDestroy(){
            super.onDestroy();
            unregisterReceiver(mBatterWatchBr);
    }
}
