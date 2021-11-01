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
    int radius = 50;

    public MyGraphics(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
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

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:


                break;

        }


        return true;
    }
}
