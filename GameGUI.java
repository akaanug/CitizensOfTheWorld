import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import java.util.ArrayList;
import util.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class GameGUI extends JPanel {
 
   // Private instance variables
   Game game;
   int numberOfPlayers; // this will be used a lot so it is better to keep instead of getting from game.
   Player currentPlayer; // this player's turn
   JPanel northPanel; // includes all variables until east panel
   JLabel playerOfTurn; // normally we will put an icon of current player but it is name for now
   JLabel playersMoney; // current player's money 
   JPanel fiveCountryList; // player's location and the four country after this.  
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
      setLayout( new BorderLayout() );
      
      this.game = game;
      this.app = application;
      this.currentPlayer = game.getCurrentPlayer();
      this.numberOfPlayers = game.getNumberOfPlayers();
      
      // Center Panel
      centerPanel = new JPanel();
      add( centerPanel );
      
      countryInfo = new CountryInfo( game.getCountries().getCountry( 0 ), currentPlayer, this ); // this guy was needed to be initialized.
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
      northPanel = new JPanel( new FlowLayout() );
      
      playerOfTurn = new JLabel( currentPlayer.getName() );
      northPanel.add( playerOfTurn );
      
      playersMoney = new JLabel( currentPlayer.getMoney() + "" );
      northPanel.add( playersMoney );  
      
      fiveCountryList = new JPanel();
      for( int n = 0; n < 5; n++ )
      {
         fiveCountryList.add( new JLabel( game.getCountries().getCountry( ( currentPlayer.getLocation() + n ) % 60 ).getName() + "     " ) );
      }              
      northPanel.add( fiveCountryList );
      
      add( northPanel, BorderLayout.NORTH );
      
      // East Panel 
      eastPanel = new GameGUIEastPanel( this );
      add( eastPanel, BorderLayout.EAST );
      
      // South Panel
      southPanel = new JPanel();
      southPanel.setLayout( new FlowLayout() );
      
      // Roll Dice Button 
      rollDice = new JButton( "Roll Dice" );
      southPanel.add( rollDice );
      rollDice.addActionListener( new RollDiceBtnListener() );
      
      // Next Turn Button
      nextTurn = new JButton( "Next Turn" );
      nextTurn.setVisible( false );
      southPanel.add( nextTurn );
      nextTurn.addActionListener( new NextTurnBtnListener() );
      
      add( southPanel, BorderLayout.SOUTH );
      
      setSize( app.getSize() );
      setVisible( true );
   }
   
   // Methods
   
   // Roll Dice Button Listener 
   public class RollDiceBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {                  
         game.rollDice( currentPlayer );
         
         northPanelRefresher();  
         
         countryInfo.uploadNewCountry( game.getLocationOfPlayer( currentPlayer ), currentPlayer );
         countryInfo.setVisible( true );
         
         rollDice.setVisible( false );
      }
   }
   
   // Next Turn Button Listener 
   public class NextTurnBtnListener implements ActionListener
   {      
      @Override
      public void actionPerformed( ActionEvent evt )
      {        
         currentPlayer.addRevenue();
         
         eastPanel.refresh( game );
         
         game.addTurnOfPlayer();
         currentPlayer = game.getCurrentPlayer();
         
         northPanelRefresher();
         
         nextTurn.setVisible( false );
         rollDice.setVisible( true );
      }
   }
   
   // As explained at variable part: to get the player info panels of players easily.
   public PlayerInfo getPlayerInfo( int playerNo )
   {
      return eastPanel.getPlayerInfo( playerNo );
   }
   
   // North Panel Refreshers( there are 2 refreshers, we use what we need, dont refresh the whole panel every time )
   public void northPanelRefresher()
   {
      playerOfTurn.setText( currentPlayer.getName() );
      playersMoney.setText( currentPlayer.getMoney() + "" );
      
      fiveCountryList.removeAll();
      for( int n = 0; n < 5; n++ )
      {
         fiveCountryList.add( new JLabel( game.getCountries().getCountry( ( currentPlayer.getLocation() + n ) % 60 ).getName() + "     " ) );
      }   
   }
   
   public void northPanelMoneyRefresher()
   {
      playersMoney.setText( currentPlayer.getMoney() + "" );
   }
}