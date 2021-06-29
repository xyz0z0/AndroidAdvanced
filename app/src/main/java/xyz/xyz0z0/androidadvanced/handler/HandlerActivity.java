package xyz.xyz0z0.androidadvanced.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import xyz.xyz0z0.androidadvanced.R;

public class HandlerActivity extends AppCompatActivity {

    private Button btnSend;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        btnSend = findViewById(R.id.btnSend);
        handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override public boolean handleMessage(@NonNull Message msg) {
                Log.d("cxg", "handleMessage " + msg.what);
                return false;
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override public void run() {
                        Looper.prepare();
                        handler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });

    }
}