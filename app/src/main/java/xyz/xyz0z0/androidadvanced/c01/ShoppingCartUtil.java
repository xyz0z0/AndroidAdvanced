package xyz.xyz0z0.androidadvanced.c01;

import android.util.Log;

/**
 * Author: Cheng
 * Date: 2021/6/1 16:26
 * Description: xyz.xyz0z0.androidadvanced.c01
 */
class ShoppingCartUtil {

    public static void showSize(ShoppingCart<? extends Fruit> list) {
        Log.d("sss", "fruit size " + list.size());
    }

    public static void showSizeSuper(ShoppingCart<? super Fruit> list) {
        Log.d("sss", "fruit size " + list.size());
    }
}
