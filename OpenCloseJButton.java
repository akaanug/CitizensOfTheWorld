import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

// This class has been created to add buttons some functionality 
// For example: Player info button can close the player info if you click it when player info is open.
public class OpenCloseJButton extends JButton
{
   // properties
   boolean opened;
   
   // constructors
   public OpenCloseJButton( String text)
   {
      super( text );
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
}