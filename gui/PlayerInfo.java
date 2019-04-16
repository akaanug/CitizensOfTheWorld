package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class PlayerInfo extends JPanel implements Observer{

   // private variables
   Player p;
   Game game;
   JLabel playerName;
   JLabel currentMoney;
   JLabel revenue;
   JLabel location;
   JLabel nationality;
   JPanel countriesPanel;
   ArrayList<JPanel> countries;
   
   // Constructor to setup the GUI components
   public PlayerInfo( Game game, int playerNo ) 
   {     
      this.game = game;
      p = game.getPlayer( playerNo );
      
      p.addObserver( this );
      
      createComponents();
      
      setVisible( false );
   }
   
   // Methods   
   public void createComponents()
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
            
      playerName = new JLabel( "Nickname: " + p.getName() );
      nationality = new JLabel( "Nationality: " + game.getLocationOfPlayer( p ).getName() );
      
      countries = new ArrayList<JPanel>();
      countriesPanel = new JPanel();
      countriesPanel.setLayout( new BoxLayout( countriesPanel, BoxLayout.Y_AXIS  ) );
      
      currentMoney = new JLabel( );
      revenue = new JLabel( );
      
      add( playerName );
      add( nationality );
      add( countriesPanel );
      add( currentMoney );
      add( revenue );
      
      setSize(300, 200);
   }
   
   public void createCountryPanel( Country c )
   {
      JPanel panel = new JPanel();
      
      panel.add( new JLabel( c.getName() ) );
      panel.add( new JLabel( c.getTax() + "" ) );
      
      countries.add( panel );
      countriesPanel.add( panel );
   }
   
   public void update( Observable obs, Object obj )
   {
      currentMoney.setText( "Money: " + p.getMoney()  );
      revenue.setText( "Revenue: " + p.getRevenue() );
      
      if ( countries.size() < p.getNumberOfCountries() )
      {
         createCountryPanel( p.getLastCountry() );
      }
   }
}
