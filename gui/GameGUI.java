package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import java.util.ArrayList;
import util.*;
import java.util.Observer;
import java.util.Observable;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class GameGUI extends JPanel implements Observer {
 
   // Private instance variables
   Game game;
   GameGUINorthPanel northPanel; // includes all variables until east panel
   PlayerInfo currentPlayersInfo; // to change player infos easily.
   GameGUIEastPanel eastPanel;
   JPanel southPanel; // includes two hardest button. 
   JButton rollDice; // rolls dice, moves current player, gets travel money, arranges north panel and player info accordingly, open the country info page
   JButton nextTurn; // changes the current player, uploads its informations into the related panels.
   JPanel centerPanel;
   CountryInfo countryInfo; 
   QuestionPage questionPage;
   YouWinPage youWinPage;
   YouLosePage youLosePage;
   AccomodationFeePage accomodationFeePage;
   Application app;
   int n; // used in for loops
   
   // Constructor to setup the GUI components and event handlers
   public GameGUI( Application application, Game game ) 
   {        
      this.game = game;
      this.app = application;
      
      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         game.getRoute().getPawn( n ).addObserver( this );
      }
      
      createComponents();
      game.startGame();
      
      handleActionListeners();
      
      setVisible( true );
   }
   
   // Methods
   
   public void createComponents()
   {
      setLayout( new BorderLayout() );
      setSize( app.getSize() );
      
      // Center Panel
      centerPanel = new JPanel();
      centerPanel.setOpaque( false );
      add( centerPanel );
      
      countryInfo = new CountryInfo( game ); 
      centerPanel.add( countryInfo );
      
      youWinPage = new YouWinPage( this );
      centerPanel.add( youWinPage );
      
      youLosePage = new YouLosePage( this );
      centerPanel.add( youLosePage );
      
      accomodationFeePage = new AccomodationFeePage( this );
      centerPanel.add( accomodationFeePage );
      
      questionPage = new QuestionPage( this );
      centerPanel.add( questionPage );
      
      // North panel
      northPanel = new GameGUINorthPanel( this );      
      add( northPanel, BorderLayout.NORTH );
      
      // East Panel 
      eastPanel = new GameGUIEastPanel( this );
      add( eastPanel, BorderLayout.EAST );
      
      // South Panel
      southPanel = new JPanel();
      southPanel.setOpaque( false );
      southPanel.setLayout( new FlowLayout() );
      
      // Roll Dice Button 
      rollDice = new JButton( "Roll Dice" );
      southPanel.add( rollDice );
      
      // Next Turn Button
      nextTurn = new JButton( "Next Turn" );
      nextTurn.setVisible( false );
      southPanel.add( nextTurn );
      
      add( southPanel, BorderLayout.SOUTH );
   }
   
   public void handleActionListeners()
   {
      rollDice.addActionListener( new RollDiceBtnListener() );
      nextTurn.addActionListener( new NextTurnBtnListener() );
   }
   
   // Roll Dice Button Listener 
   public class RollDiceBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {                  
         game.rollDice();
         
         rollDice.setVisible( false );
      }
   }
   
   // Next Turn Button Listener 
   public class NextTurnBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {        
         game.nextTurn();
                 
         nextTurn.setVisible( false );
         rollDice.setVisible( true );
      }
   }
   
   // Adding Background photo
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent( g );
      
      Graphics2D g2 = (Graphics2D) g.create();
      
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\Background Photos\\Game Table.gif" ) ).getImage();
      g2.drawImage( bg, 0,0,getWidth(),getHeight(), this);

      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         game.getRoute().getPawn( n ).draw( g, this );
      }
      
      g2.dispose();
   }
   
   public void update( Observable obs, Object obj )
   {
      repaint();
   }
}