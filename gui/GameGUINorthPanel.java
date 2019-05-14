package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import mainCode.pictureClasses.*;
import util.*;
import java.util.Observer;
import java.util.Observable;

/*
 * GameGUINorthPanel class creates the components located in the Northern part of GUIPanel
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class GameGUINorthPanel extends JPanel implements Observer, ActionListener
{
   // properties
   final int MUTE_BTN_SIZE = 30;
   JLabel playerOfTurn; // normally we will put an icon of current player but it is name for now
   Avatar playerAvatar;
   JLabel playersMoney; // current player's money 
   JLabel location; // player's location and the four country after this.  
   JButton leaveGame;
   JButton muteBtn;
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
   
   //action performed method
   @Override
   public void actionPerformed( ActionEvent evt )
   {
      if ( evt.getSource() == leaveGame )
      {
         int selectedOption = JOptionPane.showConfirmDialog(null, 
                                                            "Do you wanna leave the game?", 
                                                            "Leave the game", 
                                                            JOptionPane.YES_NO_OPTION); 
         if (selectedOption == JOptionPane.YES_OPTION) {
            game.leaveGame();
         }
      }
      else if ( evt.getSource() == muteBtn )
      {        
         parent.app.musicPlayer.mute();
      }
   }
   
   //creating the components of GameGuýNorth panel
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
      secondPanel.setLayout( new BorderLayout() );
      
      
      // Inside the second panel, center panel
      JPanel centerPanel = new JPanel();
      centerPanel.setBackground( Color.yellow );
      
      location = new JLabel( game.getCurrentLocation().getName() );
      location.setFont( new Font( "", Font.BOLD, 32 ) );
      centerPanel.add( location );
      
      leaveGame = new JButton( "Leave Game" );
      leaveGame.addActionListener( this );
      centerPanel.add( leaveGame );
      
      // Inside the second panel, east panel
      JPanel eastPanel = new JPanel();
      eastPanel.setBackground( Color.yellow );
      
      muteBtn = new JButton();
      muteBtn.add( parent.app.musicPlayer.getIcon() );
      
      //button properties
      muteBtn.setBackground( Color.yellow );
      muteBtn.setBorderPainted(false);
      muteBtn.addActionListener( this );
      eastPanel.add( muteBtn );
      
      secondPanel.add( centerPanel, BorderLayout.CENTER );
      secondPanel.add( eastPanel, BorderLayout.EAST );
      
      add(secondPanel);
   }
   
   //updating the image of GameGuýNorth panel considering new operations
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