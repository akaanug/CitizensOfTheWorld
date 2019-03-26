import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import util.*;
import java.util.ArrayList;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class MainMenu extends JPanel {

   // private variables
   JButton newGame;
   JButton credits;
   JButton loadGame;
   JButton howToPlay;
   JButton exit;
   ArrayList<JButton> buttons;
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
      
      buttons = new ArrayList<JButton>();
      
      newGame = new JButton( "New Game" );
      buttons.add( newGame );
      
      loadGame = new JButton( "Load Game" );
      buttons.add( loadGame );
      
      howToPlay = new JButton( "How To Play" );
      buttons.add( howToPlay );
      
      credits = new JButton( "Credits" );
      buttons.add( credits );
      
      for( int n = 0; n < buttons.size(); n++ )
      {
         add( buttons.get( n ) );
         buttons.get( n ).addActionListener( new MainMenuBtnListener() );         
//         int m = n;
//         buttons.get( m ).addActionListener( new ActionListener() { 
//            @Override
//            public void actionPerformed( ActionEvent evt )
//            {
//               setVisible( false );
//               app.panels.get( m + 1 ).setVisible( true );
//            }
//         } );
      }
      
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
   
   // methods
   
   // Main Menu Button Listener 
   public class MainMenuBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         for ( int n = 0; n < buttons.size(); n++ )
         {
            if ( evt.getSource() == buttons.get( n ) )
            {
               setVisible( false );
               app.panels.get( n + 1 ).setVisible( true );
            }
         }
      }
   }
}
