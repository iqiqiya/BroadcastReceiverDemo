package iqiqiya.lanlana.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Author: iqiqiya
 * Date: 2019/10/18
 * Time: 16:11
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class BroadcastReceiverTest extends BroadcastReceiver {

    private static final String TAG = "BroadcastReceiverTest";
    @Override
    public void onReceive(Context context, Intent intent) {
        // 接收广播
        if (intent != null){
            // 接收到的是什么广播
            String action = intent.getAction();
            Log.d(TAG, "onReceive: "+ action);
        }
    }
}
