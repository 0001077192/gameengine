package org.clhsprog.game1819.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements Drawable
{
    private BufferedImage img;
    
    public Sprite( String filename )
    {
        try {
            img = ImageIO.read( getClass().getResource( filename ) );
        } catch( FileNotFoundException e ) {
            System.err.println( "Image not found: \"" + filename + "\"" );
            img = null;
        } catch( IOException e ) {
            System.err.println( "ERROR while attempting to read image \"" + filename + "\": " + e.toString() );
            img = null;
        }
    }
    
    public Sprite( BufferedImage img )
    {
        this.img = img;
    }
    
    @Override
    public void draw( Graphics2D g )
    {
        if( img != null )
            g.drawImage( img, 0, 0, null );
    }
}
