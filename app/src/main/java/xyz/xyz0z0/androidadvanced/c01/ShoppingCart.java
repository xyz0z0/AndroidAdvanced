package xyz.xyz0z0.androidadvanced.c01;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Cheng
 * Date: 2021/6/1 15:09
 * Description: xyz.xyz0z0.androidadvanced.c01
 */
class ShoppingCart<T> {

    private final List<T> list = new ArrayList<>();


    public void buy(T t) {
        list.add(t);
    }


    public int size() {
        return list.size();
    }

}
