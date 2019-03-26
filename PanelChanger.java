package util;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers

// This class has been created to add buttons some functionality 
// For example: Player info button can close the player info if you click it when player info is open.
public class PanelChanger implements ActionListener
{
   // properties
   JPanel open;
   JPanel close;   
   
   // constructors
   public PanelChanger( JPanel open, JPanel close )
   {
      this.open = open;
      this.close = close;
   }
   
   // methods
   @Override
   public void actionPerformed( ActionEvent evt )
   {
      close.setVisible( false );
      open.setVisible( true );
   }
}