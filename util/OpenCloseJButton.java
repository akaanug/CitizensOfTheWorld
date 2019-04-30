package util;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.pictures.*;
import java.util.Observer;
import java.util.Observable;
import mainCode.*;

// This class has been created to add buttons some functionality 
// For example: Player info button can close the player info if you click it when player info is open.
public class OpenCloseJButton extends JButton implements Observer
{
   // properties
   boolean opened;
   
   // constructors
   public OpenCloseJButton( String text, int size )
   {
      super( text );
      setBackground( Color.cyan );
      setPreferredSize( new Dimension( size, size ) );
      
      opened = false;
   }
   
   public OpenCloseJButton( Player p, int size )
   {
      setLayout( new FlowLayout( FlowLayout.CENTER ) );
      setPreferredSize( new Dimension( size, size ) );
      
      p.addObserver( this );
      add( new JLabel( new Avatar( ( p.getAvatar().getAvatarName() ), size - 20 ) ) );
      
      opened = false;
   }
   
   // methods
   public boolean isOpened()
   {
      return opened;
   }
   
   public void changeOpened()
   {
      opened = !opened;
   }
   
   public void update( Observable obs, Object obj )
   {
      if ( ( (Player)obs ).hasTurn() )
      {
         setBackground( Color.orange );
      }
      else
      {
         setBackground( Color.cyan );
      }
   }
}