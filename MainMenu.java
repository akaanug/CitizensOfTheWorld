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
      newGame.addActionListener( new MainMenuBtnListener() );
      
      loadGame = new JButton( "Load Game" );
      add( loadGame );
      loadGame.addActionListener( new MainMenuBtnListener() );
      
      howToPlay = new JButton( "How To Play" );
      add( howToPlay );
      howToPlay.addActionListener( new MainMenuBtnListener() );
      
      credits = new JButton( "Credits" );
      add( credits );
      credits.addActionListener( new MainMenuBtnListener() );
      
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
   
   // Methods
   
   // A listener for all buttons in Main Menu except exit button. 
   // Basicly closes the main menu panel and opens the new panel according to the clicked button
   public class MainMenuBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         setVisible( false );
         
         if( evt.getSource() == newGame )
         {
            app.playerMenu.setVisible( true );
         }
         else if( evt.getSource() == loadGame )
         {
            app.loadGame.setVisible( true );
         }
         else if( evt.getSource() == howToPlay )
         {
            app.howToPlay.setVisible( true );
         }
         else 
         {
            app.credits.setVisible( true );
         }
      }
   }
}