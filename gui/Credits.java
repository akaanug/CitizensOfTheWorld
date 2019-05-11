package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import util.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class Credits extends JPanel {

   //properties
   JLabel text;
   JButton back;
   Application app;
   
   //constructors
   public Credits( Application app ) 
   {
      setLayout( new BorderLayout() );
      
      this.app = app;
      
      text = new JLabel( "Bak kardeşim buraya credits atıyoruzzzz" );      
      add( text );
      
      back = new JButton( "Back" );
      add( back, BorderLayout.SOUTH ); 
      back.addActionListener( new BackBtnListener() );
      
      setVisible( false );
      setSize( app.getSize() );
   }
   
   // methods
   
   /*
    * BackBtnListener to describe what happens when 
    * user clicks the back from Credits
    */
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
