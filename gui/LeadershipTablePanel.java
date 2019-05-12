package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.Observer;
import java.util.Observable;

/**
 * A Swing GUI application inherits from top-level container javax.swing.JFrame
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class LeadershipTablePanel extends JPanel implements Observer {
   
   // Private instance variables
   LT[] playerInfos;
   LeadershipTable leadershipTable;
   JLabel lt;
   
   // Constructor to setup the GUI components and event handlers
   public LeadershipTablePanel( LeadershipTable leadershipTable ) 
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );        
      
      this.leadershipTable = leadershipTable;
      leadershipTable.addObserver( this );
      
      createComponents();
      
      setSize(250, 700); 
      setBackground(new java.awt.Color(102, 255, 255));
      setVisible( false );   
   }   
   
   // methods
   
   //creating the components of Leadership table
   public void createComponents()
   {
      lt = new JLabel();
      lt.setBackground(new java.awt.Color(102, 255, 255));
      lt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      lt.setForeground(new java.awt.Color(255, 0, 0));
      lt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lt.setText("LEADERSHIP TABLE");
      lt.setOpaque(true);
      add(lt);
      
      playerInfos = new LT[ leadershipTable.size() ];
      
      for( int n = 0; n < leadershipTable.size(); n++ )
      {
         playerInfos[n] = new LT( leadershipTable.get( n ) );
         add( playerInfos[n] );
      }
   }
   
   // update of LeadershipTable
   public void update( Observable obs, Object obj )
   {
      removeAll();
      
      for ( int n = 0; n < playerInfos.length; n++ )
      {
         playerInfos[ leadershipTable.get( n ).getPlayerNo() ].setRank( n + 1 );
         add( playerInfos[ leadershipTable.get( n ).getPlayerNo() ] );
      }
   }
}