package xyz.xyz0z0.androidadvanced.proxy;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: Cheng
 * Date: 2021/6/10 17:25
 * Description: xyz.xyz0z0.androidadvanced.proxy
 */
class BuyInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private final Object mObject;


    public BuyInvocationHandler(Object object) {
        this.mObject = object;
    }


    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d("TAG", "开始购买");
        Object o = method.invoke(mObject, args);
        Log.d("TAG", "购买结束");
        return o;
    }
}
