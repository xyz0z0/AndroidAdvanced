package xyz.xyz0z0.androidadvanced.proxy;

import android.util.Log;

/**
 * Author: Cheng
 * Date: 2021/6/10 16:52
 * Description: xyz.xyz0z0.androidadvanced.proxy
 */
class TakeawayBrother implements IBuy {

    private final IBuy buy;


    public TakeawayBrother(IBuy buy) {
        this.buy = buy;
    }


    @Override public int buyDumplings() {
        int m = buy.buyDumplings() + 5;
        Log.d("TAG", "开始购买饺子，总价 " + m);
        return m;
    }

}
