package xyz.xyz0z0.androidadvanced;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Cheng
 * Date: 2021/6/8 10:35
 * Description: xyz.xyz0z0.androidadvanced
 */
class ThreadTest {

    private final List<String> list = new ArrayList<>();


    public void next(String value) throws InterruptedException {
        Log.d("cxg", "start next");
        synchronized (this) {
            Log.d("cxg", "next sleep");
            Thread.sleep(1000);
            list.add(value);
            Log.d("cxg", "next end");
        }
    }

    public void enqueue(String value) throws InterruptedException {
        Log.d("cxg", "enqueue next");
        synchronized (this) {
            Log.d("cxg", "enqueue sleep");
            Thread.sleep(1000);
            list.add(value);
            Log.d("cxg", "enqueue end");
        }
    }

}
