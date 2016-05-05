package com.example.administrator.localservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 类名 AlarmReciever</br>
 * 创建日期 2016/4/23</br>
 * @author LinQiaogeng</br>
 * Email 501923913@qq.com</br>
 * 更新时间 2016/4/23 12:07</br>
 * 最后更新者 linqiaogeng</br>
 *
 * 说明 类的描述
 */
public class AlarmReciever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        intent=new Intent(context,LocalService.class);
        context.startService(intent);
    }
}
