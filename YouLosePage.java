import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class YouLosePage extends JPanel {

   // private variables
   JLabel header;
   JLabel money;
   JButton exit;
   GameGUI parent;
   
   // Constructor to setup the GUI components
   public YouLosePage( GameGUI parent ) 
   {
      setLayout( new BorderLayout() );
      
      this.parent = parent;
      
      header = new JLabel( "You Lose" );
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
            parent.nextTurn.setVisible( true );
         }
      } );
      
      setVisible( false );
   }

   // Methods  
   public void refresh( int questionNumber  )
   {
      money.setText( "- " + ( 10 * ( questionNumber + 1 ) ) );
      
      setVisible( true );
   }
}