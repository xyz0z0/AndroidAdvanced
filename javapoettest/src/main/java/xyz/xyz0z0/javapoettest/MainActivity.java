package xyz.xyz0z0.javapoettest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import xyz.xyz0z0.javapoetlib.MainTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // generateHelloWorld();
    }


    private void generateHelloWorld() {
        try {
            MainTest mainTest = new MainTest();
            mainTest.generateHelloWorld();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}