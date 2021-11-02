package dk.tec.automovepicture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyGraphics2 extends View
{

    public MyGraphics2(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(200, 500, 200, paint);
    }
}
