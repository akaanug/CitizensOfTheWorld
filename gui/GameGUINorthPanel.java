package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import mainCode.pictures.Avatar;
import util.*;
import java.util.Observer;
import java.util.Observable;

public class GameGUINorthPanel extends JPanel implements Observer
{
   // properties
   JLabel playerOfTurn; // normally we will put an icon of current player but it is name for now
   Avatar playerAvatar;
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
     
      setLayout( new GridLayout( 1, 2 ) );
      setBackground( Color.black );
      
      // First panel
      JPanel firstPanel = new JPanel();
      firstPanel.setBackground( new Color( 0, 0, 140 ) );
      
      playerAvatar = currentPlayer.getAvatar();
      firstPanel.add( playerAvatar );
      
      playersMoney = new JLabel( currentPlayer.getMoney() + "" );
      playersMoney.setOpaque( true );
      playersMoney.setBackground( Color.white );
      playersMoney.setFont( new Font( "", Font.BOLD, 32 ) );
      firstPanel.add( playersMoney );  
      
      add( firstPanel );
      
      // Second panel
      JPanel secondPanel = new JPanel();
      secondPanel.setBackground( Color.yellow );
      
      location = new JLabel( game.getCurrentLocation().getName() );
      location.setFont( new Font( "", Font.BOLD, 32 ) );
      secondPanel.add( location );
      
      leaveGame = new JButton( "Leave Game" );
      leaveGame.addActionListener( new LeaveGameBtnListener() );
      secondPanel.add( leaveGame );
      
      add( secondPanel );
   }
   
   public void update( Observable obs, Object obj )
   {
      Player currentPlayer = (Player)obs;
      
      if ( currentPlayer.hasTurn() )
      {
         playerAvatar.setPicture( currentPlayer.getAvatar() );
         playersMoney.setText( currentPlayer.getMoney() + "" );
         location.setText( game.getCurrentLocation().getName() );
      }
   }
}