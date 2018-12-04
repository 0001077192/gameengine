package org.clhsprog.game1819.engine;

import java.awt.geom.Point2D;

public class PrecisePoint extends Point2D
{
    private double x, y;
    
    public PrecisePoint( double x, double y )
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double getX()
    {
        return x;
    }

    @Override
    public double getY()
    {
        return y;
    }

    @Override
    public void setLocation( double x, double y )
    {
        this.x = x;
        this.y = y;
    }
}
