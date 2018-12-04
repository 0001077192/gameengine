package org.clhsprog.game1819.engine;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class Input implements KeyListener, MouseListener, MouseMotionListener, FocusListener
{
    private static boolean[] keys = new boolean[65535];
    private static boolean[] buttons = new boolean[MouseInfo.getNumberOfButtons()];
    private static Point mousePos = null;
    private static boolean debugKeys = false, debugMouseButtons = false, debugMousePosition = false, debugFocus = false;
    
    public static void bindTo( JFrame frame )
    {
        Input input = new Input();
        frame.addKeyListener( input );
        frame.addMouseListener( input );
        frame.addMouseMotionListener( input );
        frame.addFocusListener( input );
    }
    
    public static void setDebugMode( boolean keyEvents, boolean mouseButtonEvents, boolean mousePositionEvents, boolean focusEvents )
    {
        debugKeys = keyEvents;
        debugMouseButtons = mouseButtonEvents;
        debugMousePosition = mousePositionEvents;
        debugFocus = focusEvents;
    }
    
    public static void setDebugMode( boolean debug )
    {
        Input.setDebugMode( debug, debug, debug, debug );
    }
    
    public static boolean isKeyDown( char key )
    {
        try {
            return keys[KeyStroke.getKeyStroke( key ).getKeyCode()];
        } catch( ArrayIndexOutOfBoundsException e ) {
            throw new IllegalArgumentException( "Invalid key character \'" + key + "\'" );
        }
    }
    
    public static boolean isKeyDown( int keyCode )
    {
        try {
            return keys[keyCode];
        } catch( ArrayIndexOutOfBoundsException e ) {
            throw new IllegalArgumentException( "Invalid KeyCode " + keyCode );
        }
    }
    
    public static boolean isMouseButtonDown( int buttonCode )
    {
        try {
            return buttons[buttonCode];
        } catch( ArrayIndexOutOfBoundsException e ) {
            throw new IllegalArgumentException( "Invalid mouse button code " + buttonCode );
        }
    }
    
    public static Point getMousePosition()
    {
        return mousePos;
    }

    @Override public void mouseClicked( MouseEvent e ) {}

    @Override
    public void mousePressed( MouseEvent e )
    {
        buttons[e.getButton()] = true;
        if( debugMouseButtons )
            System.out.println( "MOUSE PRESS " + e.getButton() );
    }

    @Override
    public void mouseReleased( MouseEvent e )
    {
        buttons[e.getButton()] = false;
        if( debugMouseButtons )
            System.out.println( "MOUSE RELEASE " + e.getButton() );
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
        mousePos = e.getPoint();
        if( debugMousePosition )
            System.out.println( "MOUSE ENTER @ " + e.getPoint().getX() + ", " + e.getPoint().getY() );
    }

    @Override
    public void mouseExited( MouseEvent e )
    {
        mousePos = null;
        if( debugMousePosition )
            System.out.println( "MOUSE EXIT" );
    }

    @Override public void keyTyped( KeyEvent e ) {}

    @Override
    public void keyPressed( KeyEvent e )
    {
        keys[e.getKeyCode()] = true;
        if( debugKeys )
            System.out.println( "KEY PRESS " + e.getKeyCode() );
    }

    @Override
    public void keyReleased( KeyEvent e )
    {
        keys[e.getKeyCode()] = false;
        if( debugKeys )
            System.out.println( "KEY RELEASE " + e.getKeyCode() );
    }

    @Override
    public void mouseDragged( MouseEvent e )
    {
        mousePos = e.getPoint();
        if( debugMousePosition )
            System.out.println( "MOUSE @ " + e.getPoint().getX() + ", " + e.getPoint().getY() );
    }

    @Override
    public void mouseMoved( MouseEvent e )
    {
        mousePos = e.getPoint();
        if( debugMousePosition )
            System.out.println( "MOUSE @ " + e.getPoint().getX() + ", " + e.getPoint().getY() );
    }

    @Override
    public void focusGained( FocusEvent e )
    {
        Game.play();
        if( debugFocus )
            System.out.println( "FOCUS GAINED" );
    }

    @Override
    public void focusLost( FocusEvent e )
    {
        Game.pause();
        if( debugFocus )
            System.out.println( "FOCUS LOST" );
    }
}
