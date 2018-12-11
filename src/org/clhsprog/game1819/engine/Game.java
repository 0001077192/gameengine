package org.clhsprog.game1819.engine;

import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * @author 0001077192
 * Represents a Game instance
 */
public class Game
{
    public final int VERSION_MAJOR = 0;
    public final int VERSION_MINOR = 1;
    public final int VERSION_PATCH = 0;
    public final String VERSION = VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH;
    
    /**
     * A reference to the game window
     */
    private JFrame window;
    
    /**
     * Manages drawing tasks
     */
    private GameCanvas canvas;
    
    /**
     * Singleton
     */
    private static Game instance;
    
    /**
     * Contains all of the rooms in the game
     */
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    
    /**
     * Displays a blank game
     */
    public static void main( String[] args )
    {
        Game.start( "Test Game", 300, 300 );
    }
    
    public Game()
    {
        window = new JFrame();
        window.setFocusable( true );
        
        canvas = new GameCanvas();
        window.add( canvas );
        
        if( instance == null )
        {
            instance = this;
            System.out.println( "Game engine v" + VERSION + " initialized!" );
        } else
            throw new IllegalStateException( "A Game instance is already running!" );
    }
    
    public static JFrame getWindow()
    {
        Game.ensureSingleton();
        return instance.window;
    }
    
    public static void start( String name, int width, int height )
    {
        Game.ensureSingleton();
        instance.window.setTitle( name );
        instance.window.setSize( width, height );
        instance.window.setResizable( false );
        instance.window.setLocationRelativeTo( null );
        //instance.window.setUndecorated( true );
        Input.bindTo( instance.window );
        instance.window.setVisible( true );
        instance.canvas.play();
        System.out.println( "Game started!" );
    }
    
    public static void setRoom( Room r )
    {
        Game.ensureSingleton();
        if( rooms.contains( r ) )
            instance.canvas.setRoom( r );
        else {
            registerRoom( r );
            instance.canvas.setRoom( r );
        }
        System.out.println( "Room changed: " + r.NAME );
    }
    
    public static void setRoom( String roomName )
    {
        Game.ensureSingleton();
        for( Room room: rooms )
            if( room.NAME.equals( roomName ) )
            {
                instance.canvas.setRoom( room );
                System.out.println( "Room changed: " + roomName );
                return;
            }
        throw new IllegalArgumentException( "Nonexistant or unregistered room: \"" + roomName + "\"" );
    }
    
    
    public static Room getRoom( String roomName )
    {
        Game.ensureSingleton();
        for( Room room: rooms )
            if( room.NAME.equals( roomName ) )
                return room;
        return null;
    }
    
    public static void registerRoom( Room r )
    {
        for( Room room: rooms )
            if( room.NAME.equals( r.NAME ) )
                throw new IllegalArgumentException( "A room with the name \"" + r.NAME + "\" has already been registered! All rooms must have unique names." );
        rooms.add( r );
        System.out.println( "Room registered: " + r.NAME );
        if( instance != null && rooms.size() == 1 )
        {
            instance.canvas.setRoom( r );
            System.out.println( "Room set: " + r.NAME );
        }
    }
    
    private static void ensureSingleton()
    {
        if( instance == null )
            instance = new Game();
    }
    
    /**
     * Continues the rendering loop
     */
    public static void play()
    {
        Game.ensureSingleton();
        instance.canvas.play();
        System.out.println( "Game played." );
    }
    
    /**
     * Pauses the rendering loop
     * CAUTION: Stops updating all rooms! Use sparingly.
     */
    public static void pause()
    {
        Game.ensureSingleton();
        instance.canvas.pause();
        System.out.println( "Game paused." );
    }
}
