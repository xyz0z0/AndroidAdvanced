package xyz.xyz0z0.javademo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    // /sdcard/1/dexdemo-release-unsigned.apk
    private final String path = Environment.getExternalStorageDirectory() + File.separator + "1" + File.separator;

    private Button btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                try {
                    String apkPath = path + "dexdemo-release-unsigned.apk";
                    DexClassLoader dexClassLoader = new DexClassLoader(apkPath,
                        getCacheDir().getAbsolutePath(),
                        null,
                        getClassLoader());
                    Class<?> clazz = dexClassLoader.loadClass("xyz.xyz0z0.dexdemo.Test");
                    Method method = clazz.getDeclaredMethod("test");
                    Object object = clazz.newInstance();
                    method.invoke(object,null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        ClassLoader classLoader = getClassLoader();
        while (classLoader != null) {
            Log.e("cxg", "classLoader: " + classLoader);
            classLoader = classLoader.getParent();
        }
        Log.e("cxg", "classLoader: " + Activity.class.getClassLoader());
    }
}