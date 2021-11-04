package dk.tec.sensorsrollingball;

import android.graphics.Rect;

public class Ball
{
    private double xCenter, yCenter;
    private int radius;
    private int color;

    public Ball(double x, double y, int radius, int color)
    {
        this.xCenter = x;
        this.yCenter = y;
        this.radius = radius;
        this.color = color;
    }

    public double getXCenter(){return xCenter;}
    public double getYCenter(){return yCenter;}
    public double getRadius(){return radius;}
    public double getColor(){return color;}

    public void setXCenter(double xCenter)
    {
        this.xCenter = xCenter;
    }

    public void setYCenter(double yCenter)
    {
        this.yCenter = yCenter;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public Rect getNorthRect()
    {
        Rect rect = new Rect((int)xCenter - radius, (int)yCenter - radius * 2,
                (int)xCenter + radius, (int)yCenter - radius);
        return rect;
    }
    public Rect getSouthRect()
    {
        Rect rect = new Rect((int)xCenter - radius, (int)yCenter + radius,
                (int)xCenter + radius, (int)yCenter + radius * 2);
        return rect;
    }
    public Rect getEastRect()
    {
        Rect rect = new Rect((int)xCenter + radius, (int)yCenter - radius,
                (int)xCenter + radius * 2, (int)yCenter + radius);
        return rect;
    }
    public Rect getWestRect()
    {
        Rect rect = new Rect((int)xCenter - radius * 2, (int)yCenter - radius,
                (int)xCenter - radius, (int)yCenter + radius);
        return rect;
    }
}
