package org.clhsprog.game1819.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Manages drawing tasks
 * @author 0001077192
 */
public class GameCanvas extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Timer repainter = new Timer( 1000 / 60, ( evt ) -> repaint() );
    private Room room;
    
    @Override
    public void paint( Graphics graphics )
    {
        Graphics2D g = ( Graphics2D ) graphics;
        if( room != null )
            room.draw( g );
    }
    
    public void play()
    {
        if( room == null )
            new DummyRoom();
        repainter.start();
    }
    
    public void pause()
    {
        repainter.stop();
    }
    
    public void setFPS( int fps )
    {
        repainter.setDelay( 1000 / fps );
    }
    
    public void setRoom( Room r )
    {
        room = r;
    }
}
