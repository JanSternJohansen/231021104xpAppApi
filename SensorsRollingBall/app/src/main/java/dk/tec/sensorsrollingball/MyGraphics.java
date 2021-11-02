package dk.tec.sensorsrollingball;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;

public class MyGraphics extends View implements SensorEventListener
{
    SensorManager sensorManager;
    Drawable kugle;
    double kugleWidth, kugleHeight;

    double x = 100, y = 100;
    double xDelta = 0.0, yDelta = 0.0;

    public MyGraphics(MainActivity context)
    {
        super(context);
        sensorManager = (SensorManager) context.getSystemService(Activity.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                100000);

        kugle = getResources().getDrawable(R.drawable.kugle);
        kugleWidth = kugle.getIntrinsicWidth();
        kugleHeight = kugle.getIntrinsicHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        kugle.setBounds((int)x, (int)y, (int)(x + kugleWidth), (int)(y + kugleHeight));
        kugle.draw(canvas);


        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(Color.GREEN);
        Rect rect1 = new Rect(100, 100, 200, 200);
        Rect rect2 = new Rect(250, 250, 350, 350);
        if(Rect.intersects(rect1, rect2))
            canvas.drawText("Der er overlap", 200, 400, paint);
        else
            canvas.drawText("Der er ikke overlap", 200, 400, paint);

        canvas.drawRect(rect2, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(rect1, paint);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            yDelta += sensorEvent.values[1];
            y += yDelta;
            xDelta += -sensorEvent.values[0];
            x += xDelta;
            invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
