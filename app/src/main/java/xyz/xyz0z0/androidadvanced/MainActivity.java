package xyz.xyz0z0.androidadvanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import xyz.xyz0z0.androidadvanced.c02.Chapter02Activity;
import xyz.xyz0z0.androidadvanced.c02.Student;

public class MainActivity extends AppCompatActivity {

    private Button btnC02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnC02 = findViewById(R.id.btnC02);
        btnC02.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Chapter02Activity.class);
                intent.putExtra("name", "Jack");
                intent.putExtra("age", 20);
                intent.putExtra("student", new Student("Li"));
                startActivity(intent);
            }
        });
    }
}