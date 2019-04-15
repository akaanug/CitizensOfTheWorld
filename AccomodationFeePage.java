import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class AccomodationFeePage extends JPanel {

   // private variables
   JLabel header;
   JLabel money;
   JButton exit;
   GameGUI p;
   
   // Constructor to setup the GUI components
   public AccomodationFeePage( GameGUI parent ) 
   {
      setLayout( new BorderLayout() );
      
      this.p = parent;
      
      header = new JLabel( "Accomodation Fee: " );
      add( header, BorderLayout.NORTH );
      
      money = new JLabel( );
      add( money );
      
      exit = new JButton( "Exit" );
      add( exit, BorderLayout.SOUTH );
      exit.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            setVisible( false );
            p.nextTurn.setVisible( true );
         }
      } );
      
      setVisible( false );
   }

   // Methods  
   public void refresh( int accomodationFee )
   {
      money.setText( "- " + accomodationFee );
      
      setVisible( true );
   }
}