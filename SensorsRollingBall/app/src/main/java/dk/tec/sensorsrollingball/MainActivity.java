package dk.tec.sensorsrollingball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
{
    FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        layout.addView(new MyGraphics(this),0);

        Matrix matrix = new Matrix(7,15);
        ScreenGraphics screenGraphics = new ScreenGraphics(this, matrix);
        layout.addView(screenGraphics);




    }
}