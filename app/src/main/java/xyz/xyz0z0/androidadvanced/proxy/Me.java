package xyz.xyz0z0.androidadvanced.proxy;

import android.util.Log;

/**
 * Author: Cheng
 * Date: 2021/6/10 16:50
 * Description: xyz.xyz0z0.androidadvanced.proxy
 */
class Me implements IBuy {

    private final String name;


    public Me(String name) {
        this.name = name;
    }


    @Override public int buyDumplings() {
        int m = 20;
        Log.d("TAG", name + "需要购买饺子，总价 "+m);
        return m;
    }

}
