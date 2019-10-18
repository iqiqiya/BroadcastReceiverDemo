package iqiqiya.lanlana.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String MY_ACTION = "iqiiqya.lanlana";
    public static final String broadcast_content = "broadcast_content";
    private BroadcastReceiverTest broadcastReceiverTest;
    private EditText minputEditText;
    private Button msendBroadcastButton;
    public TextView mresultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // 新建一个广播接收器
        broadcastReceiverTest = new BroadcastReceiverTest(mresultTextView);

        // 要接收哪些广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        //intentFilter.addDataScheme("package");
        intentFilter.addAction(MY_ACTION);

        //intentFilter.addAction(Intent.ACTION_BATTERY_LOW);

        // 注册广播接收器
        registerReceiver(broadcastReceiverTest,intentFilter);

        msendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 新建广播
                Intent intent = new Intent(MY_ACTION);
                // 放入广播需要携带的数据
                intent.putExtra(broadcast_content,minputEditText.getText());
                sendBroadcast(intent);
            }
        });
    }

    private void initView() {
        minputEditText = findViewById(R.id.inputEditText);
        msendBroadcastButton = findViewById(R.id.sendBroadcastButton);
        mresultTextView = findViewById(R.id.resultTextView);


    }

    protected void onDestroy(){
        super.onDestroy();
        // 取消注册广播接收器
        if (broadcastReceiverTest != null){
            unregisterReceiver(broadcastReceiverTest);
        }
    }
}
