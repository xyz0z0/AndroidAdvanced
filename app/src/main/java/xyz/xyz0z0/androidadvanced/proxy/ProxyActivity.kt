package xyz.xyz0z0.androidadvanced.proxy

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import xyz.xyz0z0.androidadvanced.R
import java.io.FileOutputStream
import java.lang.reflect.Proxy


class ProxyActivity : AppCompatActivity() {

    private lateinit var btnFirst: Button
    private lateinit var btnSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxy)
        btnFirst = findViewById(R.id.btnFirst)
        btnSecond = findViewById(R.id.btnSecond)

        btnFirst.setOnClickListener {
            val me = Me("Jack")
            val takeawayBrother = TakeawayBrother(me)
            val m = takeawayBrother.buyDumplings()
            Log.d("TAG", "完成购买饺子，支付 $m")
        }

        btnSecond.setOnClickListener {
            val me = Me("Tommy")
            val buy: IBuy = Proxy.newProxyInstance(
                IBuy::class.java.classLoader,
                arrayOf(IBuy::class.java), BuyInvocationHandler(me)
            ) as IBuy
            buy.buyDumplings()


//            val name: String = IBuy::class.java.name + "\$Proxy0"
//            //生成代理指定接口的Class数据
//            val bytes: ByteArray = ProxyGenerator.generateProxyClass(name, arrayOf<Class<*>>(IBuy::class.java))
//            val fos = FileOutputStream("lib/$name.class")
//            fos.write(bytes)
//            fos.close()
        }
    }
}