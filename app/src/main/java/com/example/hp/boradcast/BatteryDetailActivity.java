package com.example.hp.boradcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_detail);

        String sPlug, sStatus, sHealth ;

        TextView textView1 = findViewById(R.id.BatteryLevel);
        TextView textView2 = findViewById(R.id.BatteryHealth);
        TextView textView3 = findViewById(R.id.BatteryStatus);
        TextView textView4 = findViewById(R.id.BatteryPlugged);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, ifilter);
       // printBatteryStatus(batteryStatus);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int plugged = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, BatteryManager.BATTERY_PLUGGED_AC);
        int health = batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_COLD);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, BatteryManager.BATTERY_STATUS_NOT_CHARGING);



        switch (plugged) {
            case BatteryManager.BATTERY_PLUGGED_AC:
                sPlug = "AC";
                break;
            case BatteryManager.BATTERY_PLUGGED_USB:
                sPlug = "USB";
                break;
            default:
                sPlug = "Battery";
                break;
        }

        switch (status) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                sStatus = "Charging";
                break;
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                sStatus = "Not Charging";
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                sStatus = "Discharging";
                break;
            case BatteryManager.BATTERY_STATUS_FULL:
                sStatus = "Full";
                break;
            default:
                sStatus = "UnKnown";
        }

        switch (health) {
            case BatteryManager.BATTERY_HEALTH_GOOD:
                sHealth = "Good";
                break;
            case BatteryManager.BATTERY_HEALTH_COLD:
                sHealth = "Fail";
                break;
            case BatteryManager.BATTERY_HEALTH_DEAD:
                sHealth = "Dead";
                break;
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                sHealth = "Over Voltage";
                break;
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                sHealth = "Overheat";
                break;

            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                sHealth = "Failed";
                break;
            default:
                sHealth = "Unknown";
        }
        textView1.setText("Battery level = " + level);
        textView2.setText("Battery Health = " + sHealth);
        textView3.setText("Battery Status = " + sStatus);
        textView4.setText("Battery Connetion = " + sPlug);
    }

}
