package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import java.util.ArrayList;
import util.*;
import java.util.Observer;
import java.util.Observable;

/**
 * A Swing GUI application inherits from top-level container javax.swing.JFrame
 * @author Burak Öçalan
 * @version 12.05.2019
 */ 
public class GameGUI extends JPanel implements Observer {
 
   // properties
   Game game;
   GameGUINorthPanel northPanel; 
   PlayerInfo currentPlayersInfo; 
   GameGUIWestPanel westPanel;
   GameGUIEastPanel eastPanel;
   JPanel southPanel;  
   JButton rollDice; 
   JButton nextTurn; 
   JPanel centerPanel;
   CountryInfo countryInfo; 
   QuestionPage questionPage;
   YouWinPage youWinPage;
   YouLosePage youLosePage;
   SaveGame saveGame;
   AccomodationFeePage accomodationFeePage;
   PlayerLeftPage playerLeftPage;
   DicePanel dicePanel;
   Application app;
   int n; // used in for loops
   
   // constructors
   public GameGUI( Application application, Game game ) 
   {        
      this.game = game;
      this.app = application;
      
      game.addObserver( this );
      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         game.getRoute().getPawn( n ).addObserver( this );
      }
      
      createComponents();
      game.startGame();
      
      handleActionListeners();
   }
   
   //methods
   
   /*
    * creation of components of GameGuý page
    */
   public void createComponents()
   {
      setLayout( new BorderLayout() );
      setSize( app.getSize() );
      
      // Center Panel
      centerPanel = new JPanel();
      centerPanel.setLayout( new GridBagLayout() );
      centerPanel.setOpaque( false );
      add( centerPanel );
      
      saveGame = new SaveGame( this);
      centerPanel.add( saveGame );
      
      countryInfo = new CountryInfo( game ); 
      centerPanel.add( countryInfo );
      
      youWinPage = new YouWinPage( game );
      centerPanel.add( youWinPage );
      
      youLosePage = new YouLosePage( game );
      centerPanel.add( youLosePage );
      
      accomodationFeePage = new AccomodationFeePage( game );
      centerPanel.add( accomodationFeePage );
      
//      playerLeftPage = new PlayerLeftPage( game );
//      centerPanel.add( playerLeftPage );
      
      questionPage = new QuestionPage( game );
      centerPanel.add( questionPage );
      
      dicePanel = new DicePanel( game );
      centerPanel.add( dicePanel );
      
      // North panel
      northPanel = new GameGUINorthPanel( this );      
      add( northPanel, BorderLayout.NORTH );
      
      // West Panel -- to be able to make center panels exactly at center.
      westPanel = new GameGUIWestPanel();
      add( westPanel, BorderLayout.WEST );
      
      // East Panel 
      eastPanel = new GameGUIEastPanel( westPanel, this );
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
      southPanel.add( nextTurn );
      
      add( southPanel, BorderLayout.SOUTH );
   }
   
   /*
    * adding action listener for rollDice and nextTurn 
    */
   public void handleActionListeners()
   {
      rollDice.addActionListener( new RollDiceBtnListener() );
      nextTurn.addActionListener( new NextTurnBtnListener() );
   }
   
   // Roll Dice Button Listener and what it does 
   public class RollDiceBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {                  
         game.rollDice();
      }
   }
   
   // Next Turn Button Listener and what it does 
   public class NextTurnBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {        
         game.nextTurn();
      }
   }
   
   // Adding Background photo and image of pawns
   @Override
   protected void paintComponent( Graphics g ) 
   {
      super.paintComponent( g );
      
      Graphics2D g2 = ( Graphics2D ) g.create();
      
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\Background Photos\\Game Table.jpeg" ) ).getImage();
      g2.drawImage( bg, 0, 0, getWidth(), getHeight(), this );

      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         if ( game.getPlayer( n ).isPlaying() )
         {
            game.getRoute().getPawn( n ).draw( g, this );
         }
      }
      
      g2.dispose();
   }
   
   /*
    * updates on game 
    */
   public void update( Observable obs, Object obj )
   {
      repaint();
      
      if ( game.getStage().equals( "game over" ) )
      {
         eastPanel.exit.doClick();
      }       
      nextTurn.setVisible( game.getStage().equals( "last stage" ) );
      rollDice.setVisible( game.getStage().equals( "new player" ) );
   }
}