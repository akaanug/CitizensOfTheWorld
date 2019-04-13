package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.Observer;
import java.util.Observable;

public class GameGUINorthPanel extends JPanel implements Observer
{
   // properties
   JLabel playerOfTurn; // normally we will put an icon of current player but it is name for now
   JLabel playersMoney; // current player's money 
   JLabel location; // player's location and the four country after this.  
   JButton leaveGame;
   GameGUI parent;
   Game game;
   
   // constructors
   public GameGUINorthPanel( GameGUI parent )
   {
      this.parent = parent;
      this.game = parent.game;
      
      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         game.getPlayer( n ).addObserver( this );
      }
      
      createComponents();    
   }
   
   // methods
   public class LeaveGameBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         game.leaveGame();
         parent.nextTurn.doClick(); // Bunu kaldýrmamýz lazým aslýnda bakýcam bi ara 
      }
   }
   
   public void createComponents()
   {
      Player currentPlayer = game.getCurrentPlayer();
      
      playerOfTurn = new JLabel( currentPlayer.getName() );
      add( playerOfTurn );
      
      playersMoney = new JLabel( currentPlayer.getMoney() + "" );
      add( playersMoney );  
      
      location = new JLabel( game.getCurrentLocation().getName() );
      add( location );
      
      leaveGame = new JButton( "Leave Game" );
      leaveGame.addActionListener( new LeaveGameBtnListener() );
      add( leaveGame );
   }
   
   public void update( Observable obs, Object obj )
   {
      Player currentPlayer = (Player)obs;
      
      playerOfTurn.setText( currentPlayer.getName() );
      playersMoney.setText( currentPlayer.getMoney() + "" );
      location.setText( game.getCurrentLocation().getName() );
   }
}