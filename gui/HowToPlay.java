package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import util.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class HowToPlay extends JPanel {

   // private variables
   JLabel text;
   JButton back;
   Application app;
   
   // Constructor to setup the GUI components
   public HowToPlay( Application app ) 
   {
      setLayout( new BorderLayout() );
      
      this.app = app;
      
      text = new JLabel( "Bak karde�im buraya how to play at�yoruzzzz" );      
      add( text );
      
      back = new JButton( "Back" );
      add( back, BorderLayout.SOUTH ); 
      back.addActionListener( new BackBtnListener() );
      
      setVisible( false );
      setSize( app.getSize() );
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