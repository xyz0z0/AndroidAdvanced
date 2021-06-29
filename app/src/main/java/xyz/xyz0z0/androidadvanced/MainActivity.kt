package xyz.xyz0z0.androidadvanced

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnC02: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnC02 = findViewById(R.id.btnC02)

        val threadTest = ThreadTest()


        btnC02.setOnClickListener(View.OnClickListener { // Intent intent = new Intent(MainActivity.this, Chapter02Activity.class);
            // intent.putExtra("name", "Jack");
            // intent.putExtra("age", 20);
            // intent.putExtra("student", new Student("Li"));
            // startActivity(intent);
//            val s = "2303"
//            Log.d("cxg", "" + s.toTest())
            Log.d("cxg-time",""+SystemClock.uptimeMillis())
            Thread(Runnable {
                for (i in 1..5) {
                    threadTest.next("111")
                }
            }).start()
            Thread(Runnable {
                for (i in 1..5) {
                    threadTest.enqueue("222")
                }
            }).start()
        })


    }
}