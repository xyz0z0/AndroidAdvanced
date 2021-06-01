package xyz.xyz0z0.androidadvanced.c02;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Author: Cheng
 * Date: 2021/6/1 8:32
 * Description: xyz.xyz0z0.androidadvanced.c02
 */

class AutowiredUtils {

    public static void init(Activity activity) throws IllegalAccessException {
        Class<?> clazz = activity.getClass();
        Intent intent = activity.getIntent();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Log.d("cxg", "filed " + field.getName());
            if (field.isAnnotationPresent(Autowired.class)) {
                Autowired autowired = field.getAnnotation(Autowired.class);
                if (autowired == null) {
                    continue;
                }
                String value = autowired.value();
                if (field.getType().equals(String.class)) {
                    Log.d("cxg", "equals1");
                    String extra = intent.getStringExtra(value);
                    field.set(activity, extra);
                    continue;
                }
                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    Log.d("cxg", "equals2");
                    int extra = intent.getIntExtra(value, 0);
                    field.set(activity, extra);
                    continue;
                }
                if (Serializable.class.isAssignableFrom(field.getType())) {
                    Log.d("cxg", "equals3");
                    Object extra = intent.getSerializableExtra(value);
                    field.set(activity, extra);
                    continue;
                }
            }
        }
    }

}
