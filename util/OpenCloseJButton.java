package util;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.pictureClasses.*;
import java.util.Observer;
import java.util.Observable;
import mainCode.*;

/** 
 * This class has been created to add buttons some functionality 
 * For example: Player info button can close the player info if you click it when player info is open.
 * @author Burak Öçalan
 * @version 12.05.2019
 */
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
   
   /*
    * return whether button is open or not
    * @return whether button is opened or no
    */
   public boolean isOpened()
   {
      return opened;
   }
   
   //changing the current situation of button open - close or close open
   public void changeOpened()
   {
      opened = !opened;
   }
   
   /*
    * updating the buttons
    * @param Observable obs
    * @param Object obj
    */
   public void update( Observable obs, Object obj )
   {
      if ( obj == null || ( (String)obj ).equals( "next turn" ) )
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
}