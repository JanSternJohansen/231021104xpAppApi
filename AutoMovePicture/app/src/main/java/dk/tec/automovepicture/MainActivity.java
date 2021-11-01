package dk.tec.automovepicture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout);
        MyGraphics mc = new MyGraphics(this);
        layout.addView(mc);

        Thread t1 = new Thread(mc);
        t1.start();

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run()
//            {
//                for(int i=0; i<10; i++)
//                {
//                    Log.d("Thread: ",  "T2 Counter: " + i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e){}
//                }
//            }
//        });
//        t2.start();
//
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run()
//            {
//                for(int i=0; i<10; i++) {
//                    Log.d("Thread: ", "T3 Counter: " + i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        });
//        t3.start();

    }
}