import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

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
      back.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            setVisible( false );
            app.mainMenu.setVisible( true );
         }
      } );
      
      setVisible( false );
      setSize(700, 660);
   }
}