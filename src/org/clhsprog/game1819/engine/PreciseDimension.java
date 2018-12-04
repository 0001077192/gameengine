package org.clhsprog.game1819.engine;

import java.awt.geom.Dimension2D;

public class PreciseDimension extends Dimension2D
{
    private double width, height;
    
    public PreciseDimension( double width, double height )
    {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getWidth()
    {
        return width;
    }

    @Override
    public double getHeight()
    {
        return height;
    }

    @Override
    public void setSize( double width, double height )
    {
        this.width = width;
        this.height = height;
    }
}
