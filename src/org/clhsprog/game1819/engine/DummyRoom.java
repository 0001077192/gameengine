package org.clhsprog.game1819.engine;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represents an empty room
 * @author 0001077192
 */
public class DummyRoom extends Room
{
    public DummyRoom( String name )
    {
        super( name );
    }
    
    public DummyRoom()
    {
        super( "dummy" );
    }
    
    @Override
    public void draw( Graphics2D graphics )
    {
        graphics.setColor( Color.BLACK );
        graphics.fillRect( 0, 0, Game.getWindow().getWidth(), Game.getWindow().getHeight() );
    }
}
