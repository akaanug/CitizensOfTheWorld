import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class Application extends JFrame {
 
   // Private instance variables
   MainMenu mainMenu;
   Credits credits;
   HowToPlay howToPlay;
   LoadGame loadGame;
   PlayerMenu playerMenu;
   GameGUI gameGui;
   Game game;
   
   // Constructor to setup the GUI components and event handlers
   public Application() 
   {
      setLayout( new BorderLayout() );
      
      playerMenu = new PlayerMenu( this );
      add( playerMenu );
            
      loadGame = new LoadGame( this );
      add( loadGame );
      
      credits = new Credits( this );
      add( credits );
      
      howToPlay = new HowToPlay( this );
      add( howToPlay );
    
      mainMenu = new MainMenu( this );
      add( mainMenu );
      
      setTitle("Citizens Of The World");  // "super" JFrame sets title
      setSize(700, 700);   // "super" JFrame sets initial size
      setVisible(true);    // "super" JFrame shows
      setLocation( 300, 25 );
      
      System.out.println( );
   }
   
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
