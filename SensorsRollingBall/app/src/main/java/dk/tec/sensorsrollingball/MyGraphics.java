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
import android.util.Log;
import android.view.View;

public class MyGraphics extends View implements SensorEventListener
{
    SensorManager sensorManager;
    Drawable kugle;
    double kugleWidth, kugleHeight;

    Ball ball;
    int radius;

    double x = 100, y = 100;
    double xDelta = 0.0, yDelta = 0.0;
    int screenWidth, screenHeight;

    public MyGraphics(MainActivity context)
    {
        super(context);
        sensorManager = (SensorManager) context.getSystemService(Activity.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                50000);

        kugle = getResources().getDrawable(R.drawable.ball22);// 8,
        kugleWidth = kugle.getIntrinsicWidth()/4;
        kugleHeight = kugle.getIntrinsicHeight()/4;

        radius = (int)kugleWidth/2;
        ball = new Ball(100 + radius, 100 + radius, radius, 0 );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.screenWidth = w;
        this.screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //kugle.setBounds((int)x, (int)y, (int)(x + kugleWidth), (int)(y + kugleHeight));
        double xCenter = ball.getXCenter();
        double yCenter = ball.getYCenter();
        double radius = ball.getRadius();

        Log.d("Values", "xCenter: " + xCenter);
        Log.d("Values", "yCenter: " + yCenter);
        Log.d("Values", "radius: " + radius);


        kugle.setBounds((int)(xCenter - radius), (int)(yCenter - radius),
                (int)(xCenter + radius), (int)(yCenter - radius + kugleHeight)); //Fordi billedet er højere end bredt pga skygge

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
            ball.setYCenter(ball.getYCenter() + yDelta);
            xDelta += -sensorEvent.values[0];
            ball.setXCenter(ball.getXCenter() + xDelta);

            double xCenter = ball.getXCenter();
            double yCenter = ball.getYCenter();
            double radius = ball.getRadius();
            if(xCenter - radius < 0)
            {
                xDelta *= -1;
                ball.setXCenter(ball.getXCenter() + xDelta);
                xDelta *= 0.5;
            }
            else if(xCenter + radius > screenWidth)
            {
                xDelta *= -1;
                ball.setXCenter(ball.getXCenter() + xDelta);
                xDelta *= 0.5;
            }
            if(yCenter - radius < 0)
            {
                yDelta *= -1;
                ball.setYCenter(ball.getYCenter() + yDelta);
                yDelta *= 0.5;
            }
            else if(yCenter + radius > screenHeight)
            {
                yDelta *= -1;
                ball.setYCenter(ball.getYCenter() + yDelta);
                yDelta *= 0.5;
            }






            invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
