import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import util.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class LoadGame extends JPanel {

   // private variables
   JButton back;
   Application app;
   
   // Constructor to setup the GUI components
   public LoadGame( Application app ) 
   {      
      setLayout( new BorderLayout() );
      
      this.app = app;
      
      back = new JButton( "Back" );
      add( back, BorderLayout.SOUTH ); 
      back.addActionListener( new BackBtnListener() );
      
      setVisible( false );
      setSize( 1366, 768 );
   }
   
   // methods
   
   // Back Button Listener
   public class BackBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         setVisible( false );
         app.mainMenu.setVisible( true );
      }
   }
}