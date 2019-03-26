import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class MainMenu extends JPanel {

   // private variables
   JButton newGame;
   JButton credits;
   JButton loadGame;
   JButton howToPlay;
   JButton exit;
   JLabel name;
   Application app;
   
   // Constructor to setup the GUI components
   public MainMenu( Application app ) 
   { 
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      
      this.app = app;
      
      name = new JLabel( "CITIZENS OF THE WORLD" );
      name.setLocation( 400,250 );
      add( name );     
      
      newGame = new JButton( "New Game" );
      add( newGame );
      newGame.addActionListener( new PanelChanger( app.playerMenu, this ) );
      
      loadGame = new JButton( "Load Game" );
      add( loadGame );
      loadGame.addActionListener( new PanelChanger( app.loadGame, this ) );
      
      howToPlay = new JButton( "How To Play" );
      add( howToPlay );
      howToPlay.addActionListener( new PanelChanger( app.howToPlay, this ) );
      
      credits = new JButton( "Credits" );
      add( credits );
      credits.addActionListener( new PanelChanger( app.credits, this ) );
      
      exit = new JButton( "Exit" );
      add( exit );
      exit.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            System.exit( 0 );
         }
      } );  
      
      setSize(700, 660);      
   }
}
