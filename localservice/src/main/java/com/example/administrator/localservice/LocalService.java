package com.example.administrator.localservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

/**
 * 类名 LocalService</br>
 * 创建日期 2016/4/23</br>
 * @author LinQiaogeng</br>
 * Email 501923913@qq.com</br>
 * 更新时间 2016/4/23 11:17</br>
 * 最后更新者 linqiaogeng</br>
 *
 * 说明 类的描述
 */
public class LocalService extends Service {


    public IBinder onBind(Intent intent)
    {
        return null;
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "定时输出时间,10秒一次");
            }
        }).start();
        AlarmManager manager=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        long time= SystemClock.elapsedRealtime()+10*1000;
        Intent i=new Intent(this,AlarmReciever.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,pi);
        return super.onStartCommand(intent,flags,startId);
    }
}
