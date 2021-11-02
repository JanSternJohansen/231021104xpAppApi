package dk.tec.automovepicture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyGraphics extends View implements Runnable
{
    Drawable einstein;

    int x = 100, y = 200;
    int imageWidth, imageHeight;

    int xDelta = 10;
    int yDelta = 10;

    int screenWidth, screenHeight;

    public MyGraphics(Context context)
    {
        super(context);

        einstein = getResources().getDrawable(R.drawable.einstein);
        imageHeight = einstein.getIntrinsicHeight()/4;
        imageWidth = einstein.getIntrinsicWidth()/4;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        screenWidth = w;
        screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        einstein.setBounds(x, y, x + imageWidth, y + imageHeight);
        einstein.draw(canvas);
    }

    @Override
    public void run()
    {
        while(true)
        {
            x += xDelta;
            y += yDelta;

            if(x < 0 || x + imageWidth > screenWidth)
                xDelta *= -1;
            if(y < 0 || y + imageHeight > screenHeight)
                yDelta *= -1;

            invalidate();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}
