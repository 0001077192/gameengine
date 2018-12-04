package org.clhsprog.game1819.engine;

import java.awt.Graphics2D;

public abstract class Room implements Drawable
{
    public final String NAME;
    
    public Room( String uniqueName )
    {
        NAME = uniqueName;
        Game.registerRoom( this );
    }
    
    @Override
    public abstract void draw( Graphics2D graphics );
}
