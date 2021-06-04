package xyz.xyz0z0.androidadvanced.c02;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.lang.reflect.Field;
import xyz.xyz0z0.androidadvanced.R;

public class KotlinAnnotationTestActivity extends AppCompatActivity {

    @KotlinFirst(name = "HAHA")
    public String mName;

    @BindView(R.id.tvFirst)
    TextView tvFirst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter02);
        ButterKnife.bind(this);

        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(KotlinFirst.class)) {
                KotlinFirst annotation = field.getAnnotation(KotlinFirst.class);
                Log.d("sss", annotation.name());
            }
        }

    }
}