package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.ArrayList;

/**
 * A Swing GUI application inherits from top-level container javax.swing.JFrame
 * @author Emin Adem Buran
 * @version 12.05.2019
*/ 
public class Application extends JFrame {
    
    // Private instance variables
    MainMenu mainMenu;
    PlayerMenu playerMenu;
    LoadGame loadGame;
    HowToPlay howToPlay;
    Credits credits;
    GameGUI gameGui;
    ArrayList<JPanel> panels;
    Game game;
    MusicPlayer musicPlayer;
    
    // Constructor to setup the GUI components and event handlers
    public Application() 
    {
        // Set the frame size and vs vs..
        setLayout( new BorderLayout() );           
        setExtendedState( JFrame.MAXIMIZED_BOTH ); 
        setUndecorated( true );
        setVisible(true);    // "super" JFrame shows
        setLocation( 0, 0 );
        
        try { 
            
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
        
        // Add main panels to the frame.
        panels = new ArrayList<JPanel>();
        
        mainMenu = new MainMenu( this );
        panels.add( mainMenu );
        
        playerMenu = new PlayerMenu( this );
        panels.add( playerMenu );
        
        loadGame = new LoadGame( this );
        panels.add( loadGame );
        
        howToPlay = new HowToPlay( this );
        panels.add( howToPlay );
        
        credits = new Credits( this );
        panels.add( credits );
        
        for ( int n = 0; n < panels.size(); n++ )
        {
            add( panels.get( n ) );
        }  
        
        musicPlayer = new MusicPlayer ( GameFileReader.getMusics() );
    }
    
    // methods
    
    // The entry main() method
    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Application();
            }
        });
    }
}