import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
 
// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class GameBoard extends JFrame {
 
   // Private instance variables
   // ......
 
   // Constructor to setup the GUI components and event handlers
   public GameBoard() 
   {
      add( new MainMenu() );
 
      setTitle("......");  // "super" JFrame sets title
      setSize(700, 700);   // "super" JFrame sets initial size
      setVisible(true);    // "super" JFrame shows
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Run GUI codes in Event-Dispatching thread for thread-safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new GameBoard();  // Let the constructor do the job
         }
      });
   }
}