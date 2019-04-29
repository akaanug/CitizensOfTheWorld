import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class PlayerInfo extends JPanel {

   // private variables
   JLabel playerName;
   JLabel currentMoney;
   JLabel revenue;
   JLabel location;
   public final JLabel NATIONALITY;
   
   // Constructor to setup the GUI components
   public PlayerInfo( Player p, Country nationality ) 
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      
      playerName = new JLabel( "Nickname: " + p.getName() );
      NATIONALITY = new JLabel( "Nationality: " + nationality.getName() );
      currentMoney = new JLabel( "Current Money: " + p.getMoney() );
      revenue = new JLabel( "Revenue: " + p.getRevenue() );
      
      
      add( playerName );
      add( NATIONALITY );
      add( currentMoney );
      add( revenue );
      
      setVisible( false );
      setSize(300, 200);
   }
   
   // Methods
   public void setCurrentMoney( int money )
   {
      this.currentMoney.setText( "Money: " + money  );
   }
   
   public void setRevenue( int revenue )
   {
      this.revenue.setText( "Revenue: " + revenue );
   }
   
   public void handleChanges( Player p )
   {
      setRevenue( p.getRevenue() );
      setCurrentMoney( p.getMoney() );
   }
   
}