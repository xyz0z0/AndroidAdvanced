package xyz.xyz0z0.androidadvanced.c02;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import xyz.xyz0z0.androidadvanced.R;

public class Chapter02Activity extends AppCompatActivity {

    @Autowired("name")
    public String mName;
    @Autowired("age")
    public int mAge;
    @Autowired("student")
    public Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter02);
        try {
            AutowiredUtils.init(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Log.d("cxg-extra", "=== " + mName);
        Log.d("cxg-extra", "=== " + mAge);
        Log.d("cxg-extra", "=== " + student.toString());
    }
}