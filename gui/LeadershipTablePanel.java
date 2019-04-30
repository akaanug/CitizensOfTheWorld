package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.Observer;
import java.util.Observable;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class LeadershipTablePanel extends JPanel implements Observer {
 
   // Private instance variables
   JPanel[] playerInfos;
   LeadershipTable leadershipTable;
   
   // Constructor to setup the GUI components and event handlers
   public LeadershipTablePanel( LeadershipTable leadershipTable ) 
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );        
     
      this.leadershipTable = leadershipTable;
      leadershipTable.addObserver( this );
      
      createComponents();
      
      setSize(250, 700);   
      setVisible( false );   
   }   
   
   // methods
   
   public void createComponents()
   {
      add( new Label( "Leadership Table" ) );
          
      playerInfos = new JPanel[ leadershipTable.size() ];
      for( int n = 0; n < playerInfos.length; n++ )
      {
          playerInfos[n] = new JPanel();
      }
      
      for( int n = 0; n < playerInfos.length; n++ )
      {
         playerInfos[n].add( new JLabel( ) );
         playerInfos[n].add( new JLabel( ) );
         playerInfos[n].add( new JLabel( ) );
         playerInfos[n].add( new JLabel( ) );
         add( playerInfos[n] );
      }
   }
   
   public void update( Observable obs, Object obj )
   {      
      for( int n = 0; n < playerInfos.length; n++ )
      {
         ( (JLabel) playerInfos[n].getComponent( 0 ) ).setText( ( n + 1 ) + "     " );
         ( (JLabel) playerInfos[n].getComponent( 1 ) ).setText( leadershipTable.get( n ).getName() + "     " );
         ( (JLabel) playerInfos[n].getComponent( 2 ) ).setText( leadershipTable.get( n ).getNumberOfCountries() + "     " );
         ( (JLabel) playerInfos[n].getComponent( 3 ) ).setText( leadershipTable.get( n ).getMoney() + "" );
      }
   }    
}