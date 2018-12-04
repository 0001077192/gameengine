package org.clhsprog.game1819.engine;

public class Vector
{
    public double x, y;
    
    public Vector()
    {
        this( 0, 0 );
    }
    
    public Vector( double x, double y )
    {
        this.x = x;
        this.y = y;
    }
    
    public double getMagnitude()
    {
        return Math.sqrt( ( x * x ) + ( y * y ) );
    }
    
    public double getAngle()
    {
        return Math.toDegrees( Math.atan2( y, x ) );
    }
    
    public void add( double x, double y )
    {
        this.x += x;
        this.y += y;
    }
    
    public void add( double amt )
    {
        this.x += amt;
        this.y += amt;
    }
    
    public void subtract( double x, double y )
    {
        this.x -= x;
        this.y -= y;
    }
    
    public void subtract( double amt )
    {
        this.x -= amt;
        this.y -= amt;
    }
    
    public void multiply( double x, double y )
    {
        this.x *= x;
        this.y *= y;
    }
    
    public void multiply( double amt )
    {
        this.x *= amt;
        this.y *= amt;
    }
    
    public void divide( double x, double y )
    {
        this.x /= x;
        this.y /= y;
    }
    
    public void divide( double amt )
    {
        this.x /= amt;
        this.y /= amt;
    }
    
    public static Vector getFromRotation( double magnitude, double angleInDegrees )
    {
        double angle = Math.toRadians( angleInDegrees );
        return new Vector( Math.cos( angle ) * magnitude, Math.sin( angle ) * magnitude );
    }
}
