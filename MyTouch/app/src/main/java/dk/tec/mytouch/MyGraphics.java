package dk.tec.mytouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyGraphics extends View implements View.OnTouchListener
{
    int xCenter = 100, yCenter = 200;
    int xPrev, yPrev;
    int radius = 50;
    Paint paint;
    boolean moving = false;

    public MyGraphics(Context context) {
        super(context);
        this.setOnTouchListener(this);

        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(this.xCenter, this.yCenter, this.radius, paint);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        int xNew = (int)motionEvent.getX();
        int yNew = (int)motionEvent.getY();

        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                // Er cirklen ramt med fingeren?
                if(Math.sqrt(Math.pow(xNew - xCenter, 2) + Math.pow(yNew - yCenter, 2)) < radius)
                {
                   // paint.setColor(Color.RED);
                   // invalidate();

                    moving = true;
                    xPrev = xNew;
                    yPrev = yNew;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if(moving)
                {
                    xCenter += xNew - xPrev;
                    yCenter += yNew - yPrev;
                    xPrev = xNew;
                    yPrev = yNew;
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:


                break;

        }


        return true;
    }
}
