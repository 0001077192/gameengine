package org.clhsprog.game1819.engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public abstract class GameObject implements Drawable
{
    public Dimension2D scale;
    public double rotation;
    public Point2D position;
    
    public GameObject()
    {
        scale = new PreciseDimension( 1.0, 1.0 );
        rotation = 0.0;
        position = new PrecisePoint( 0.0, 0.0 );
    }
    
    @Override
    public final void draw( Graphics2D g )
    {
        AffineTransform oldTf = new AffineTransform( g.getTransform() );
        AffineTransform tf = g.getTransform();
        tf.scale( scale.getWidth(), scale.getHeight() );
        tf.rotate( Math.toRadians( rotation ) );
        tf.translate( position.getX(), position.getY() );
        drawTransformed( g );
        g.setTransform( oldTf );
    }
    
    public abstract void drawTransformed( Graphics2D g );
}
