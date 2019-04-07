import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class ThreeSimplePages extends JPanel {

   // private variables
   JLabel header;
   JLabel money;
   JButton exit;
   GameGUI parent;
   
   // Constructor to setup the GUI components
   public ThreeSimplePages( GameGUI p ) 
   {
      setLayout( new BorderLayout() );
      
      this.parent = p;
      
      header = new JLabel();
      add( header, BorderLayout.NORTH );
      
      money = new JLabel();
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
   public void youWin( int countryIncome )
   {
      header.setText( "Congratulations" );
      money.setText( "+ " + countryIncome );
      
      // Biliyorum iðrenç oldu ama þimdilik elimizden gelen bu 
      parent.currentPlayer.addCitizenship( parent.game.getLocationOfPlayer( parent.currentPlayer ) );
      parent.game.getLocationOfPlayer( parent.currentPlayer ).addToCitizenship( parent.currentPlayer );
      
      setVisible( true );
   }
   
   public void youLose( int questionNumber )
   {
      header.setText( "You Lose" );
      money.setText( "- " + ( 10 * ( questionNumber + 1 ) ) );
      
      setVisible( true );
   }
   
   public void accomodationFee( int accomodationFee )
   {
      header.setText( "Accomodation Fee:" );
      money.setText( "- " + accomodationFee );
      
      setVisible( true );
   }
}