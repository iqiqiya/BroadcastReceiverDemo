package iqiqiya.lanlana.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiverTest broadcastReceiverTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 新建一个广播接收器
        broadcastReceiverTest = new BroadcastReceiverTest();

        // 要接收哪些广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");

        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);

        // 注册广播接收器
        registerReceiver(broadcastReceiverTest,intentFilter);
    }

    protected void onDestroy(){
        super.onDestroy();
        // 取消广播接收器
        if (broadcastReceiverTest != null){
            unregisterReceiver(broadcastReceiverTest);
        }
    }
}
