package iqiqiya.lanlana.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Author: iqiqiya
 * Date: 2019/10/18
 * Time: 16:11
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class BroadcastReceiverTest extends BroadcastReceiver {

    TextView mTextView;
    public BroadcastReceiverTest(){

    }

    public BroadcastReceiverTest(TextView textView){
        mTextView = textView;
    }

    private static final String TAG = "BroadcastReceiverTest";
    @Override
    public void onReceive(Context context, Intent intent) {
        // 接收广播
        if (intent != null){
            // 接收到的是什么广播
            String action = intent.getAction();
            Log.d(TAG, "onReceive: "+ action);

            // 判断是否是自己发送的广播
            if (TextUtils.equals(action, MainActivity.MY_ACTION)){
                // 获取广播携带的内容
                String content = intent.getStringExtra(MainActivity.broadcast_content);
                if (mTextView != null){
                    mTextView.setText("接收到的action是："+ action+"\n接收到的内容是：\n"+content);
                }
            }
        }
    }
}
