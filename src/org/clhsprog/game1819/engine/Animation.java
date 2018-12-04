package org.clhsprog.game1819.engine;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Animation
{
    private ArrayList<Sprite> frames;
    private int frameIndex;
    
    public Animation( String spriteSheetFilename, int framesPerRow, int totalFrames, int frameWidth, int frameHeight )
    {
        try {
            BufferedImage sheet = ImageIO.read( getClass().getResource( spriteSheetFilename ) );
            frames = new ArrayList<Sprite>();
            frameIndex = 0;
            for( int i = 0; i < totalFrames; i++ )
                frames.add( new Sprite( getSpriteFromSheet( sheet, i, framesPerRow, frameWidth, frameHeight ) ) );
        } catch( FileNotFoundException e ) {
            System.err.println( "Spritesheet not found: \"" + spriteSheetFilename + "\"" );
        } catch( IOException e ) {
            System.err.println( "ERROR while attempting to parse spritesheet \"" + spriteSheetFilename + "\": " + e.toString() );
        }
    }
    
    public static BufferedImage getSpriteFromSheet( BufferedImage sheet, int frameIndex, int framesPerRow, int frameWidth, int frameHeight )
    {
        int frameX = ( frameIndex % framesPerRow ) * frameWidth;
        int frameY = ( frameIndex / framesPerRow ) * frameHeight;
        
        return sheet.getSubimage( frameX, frameY, frameWidth, frameHeight );
    }
    
    /**
     * Advances the Animation to the next frame
     */
    public void advanceFrame()
    {
        frameIndex = ++frameIndex % frames.size();
    }
    
    /**
     * Resets the Animation back to the first frame
     */
    public void reset()
    {
        frameIndex = 0;
    }
    
    /**
     * Advances the Animation to the next frame and returns it
     * @return the next frame
     */
    public Sprite nextFrame()
    {
        advanceFrame();
        return getFrame();
    }
    
    /**
     * @return the current frame of this Animation
     */
    public Sprite getFrame()
    {
        if( frameIndex == 0 || frameIndex >= frames.size() )
            return null; //something is very wrong
        else
            return frames.get( frameIndex );
    }
}
