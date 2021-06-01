package xyz.xyz0z0.androidadvanced.c01;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xyz.xyz0z0.androidadvanced.R;

public class GenericActivity extends AppCompatActivity {

    private final List<String> mNameList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        mNameList.add("Jack");
        List<String> list = Arrays.asList("Jack", "Joe", "David");
        Log.d("sss", "" + mNameList.size());
        Log.d("sss", "" + list.size());
        // ShoppingCart<Fruit> shoppingCart1 = new ShoppingCart<>();
        // shoppingCart1.buy(new Fruit());
        // shoppingCart1.buy(new Apple());
        // ShoppingCart.show(shoppingCart1);
        ShoppingCart<Apple> shoppingCart2 = new ShoppingCart<>();
        shoppingCart2.buy(new Apple());
        ShoppingCartUtil.showSize(shoppingCart2);
        // Log.d("sss", shoppingCart1.getClass().getName());
        // Log.d("sss", shoppingCart2.getClass().getName());
        // Log.d("sss", "" + shoppingCart1.getClass().equals(shoppingCart2.getClass()));// true
    }
}