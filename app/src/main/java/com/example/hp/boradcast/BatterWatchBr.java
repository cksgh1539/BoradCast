package com.example.hp.boradcast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by hp on 2017-12-06.
 */

public class BatterWatchBr extends BroadcastReceiver {
    Context mContext;
    final int NOTI_ID = 100;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

       IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,0);

        Toast.makeText(context,"ACTION_BATTERY_LOW: level = "+level,Toast.LENGTH_SHORT).show();


  /*Intent aIntent = new Intent(context,BatteryDetailActivity.class);
        PendingIntent contentIntent
                = PendingIntent.getActivity(
                context,
                0,
                aIntent, // 작업 요청할 명시적 인텐트
                PendingIntent.FLAG_UPDATE_CURRENT);
        initChannel(); //API26에서도 실행 되게 해주는 메소드
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context,"default")
                        .setSmallIcon(R.drawable.ic_battery_alert_black_24dp)
                        .setContentTitle("배터리 경고")
                        .setContentText("전원을 연결하세요 ")
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)
                        .setWhen(System.currentTimeMillis())
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setDefaults(Notification.DEFAULT_ALL); //진동 , 소리 ,불빛 전부 알림

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(NOTI_ID, mBuilder.build());
    }

    private void initChannel() {
        if (android.os.Build.VERSION.SDK_INT >=26) {
            // The id of the channel.
            String id = "default";

            // The user-visible name of the channel.
            CharSequence name = mContext.getString(R.string.channel_name);

            // The user-visible description of the channel.
            String description = mContext.getString(R.string.channel_description);

            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(id, name, importance);

            // Configure the notification channel.

            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.BLUE);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            NotificationManager mNotificationManager =
                    (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);
        }*/
    }

}
