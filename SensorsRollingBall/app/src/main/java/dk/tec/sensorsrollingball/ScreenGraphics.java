package dk.tec.sensorsrollingball;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class ScreenGraphics extends View
{
    Matrix matrix;

    public ScreenGraphics(Context context, Matrix matrix)
    {
        super(context);
        this.matrix = matrix;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        matrix.drawMatrix(canvas);
    }
}
