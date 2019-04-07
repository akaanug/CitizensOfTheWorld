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
   JPanel eastPanel; // includes all variables until west panel
   OpenCloseJButton playerOneButton; // when clicked, the information of player appears or disappears 
   OpenCloseJButton playerTwoButton;
   OpenCloseJButton playerThreeButton;
   OpenCloseJButton playerFourButton;
   OpenCloseJButton leadershipTableButton; // when clicked, leadership table appears
   ArrayList<OpenCloseJButton> eastPanelButtons;
   JButton save;
   JButton exit;
   JPanel westPanel; // this panel is temporary, when you click a button in east panel, the info appears in there. 
   PlayerInfo playerOneInfo; 
   PlayerInfo playerTwoInfo;
   PlayerInfo playerThreeInfo;
   PlayerInfo playerFourInfo;
   PlayerInfo currentPlayersInfo; // to change player infos easily.
   LeadershipTable leadershipTable;
   ArrayList<JPanel> westPanelInfos;
   JPanel southPanel; // includes two hardest button. 
   JButton rollDice; // rolls dice, moves current player, gets travel money, arranges north panel and player info accordingly, open the country info page
   JButton nextTurn; // changes the current player, uploads its informations into the related panels.
   JPanel centerPanel;
   CountryInfo countryInfo; 
   QuestionPage questionPage;
   YouWinPage youWinPage;
   YouLosePage youLosePage;
   AccomodationFeePage accomodationFeePage;
   ThreeSimplePages simplePages;
   Application app;
   int n; // used in for loops
   int m;
   
   // Constructor to setup the GUI components and event handlers
   public GameGUI( Application application, Game game ) 
   {  
      if ( game != null ) // For null pointer exception.
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
         
         simplePages = new ThreeSimplePages( this );
         centerPanel.add( simplePages );
         
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
         
         // East Panel and West Panel
         eastPanel = new JPanel( );
         eastPanel.setLayout( new BoxLayout( eastPanel, BoxLayout.Y_AXIS ) );
         westPanel = new JPanel( );
         westPanel.setLayout( new FlowLayout() );
         
            // Declaring East Panel Buttons and West Panel Infos
         eastPanelButtons = new ArrayList<OpenCloseJButton>();
         westPanelInfos = new ArrayList<JPanel>();
         
         playerOneButton = new OpenCloseJButton( game.getPlayer( 0 ).getName() );
         eastPanelButtons.add( playerOneButton );
         
         playerOneInfo = new PlayerInfo( game.getPlayer( 0 ), game.getLocationOfPlayer( game.getPlayer( 0 ) ) );
         westPanelInfos.add( playerOneInfo );
         
         if ( numberOfPlayers >= 2 )
         {
            playerTwoButton = new OpenCloseJButton( game.getPlayer( 1 ).getName() );
            eastPanelButtons.add( playerTwoButton );
            
            playerTwoInfo = new PlayerInfo( game.getPlayer( 1 ), game.getLocationOfPlayer( game.getPlayer( 1 ) ) );
            westPanelInfos.add( playerTwoInfo );
         }
         
         if ( numberOfPlayers >= 3 )
         {
            playerThreeButton = new OpenCloseJButton( game.getPlayer( 2 ).getName() );
            eastPanelButtons.add( playerThreeButton );
            
            playerThreeInfo = new PlayerInfo( game.getPlayer( 2 ), game.getLocationOfPlayer( game.getPlayer( 2 ) ) );
            westPanelInfos.add( playerThreeInfo );
         }
         
         if ( numberOfPlayers == 4 )
         {
            playerFourButton = new OpenCloseJButton( game.getPlayer( 3 ).getName() );
            eastPanelButtons.add( playerFourButton );
            
            playerFourInfo = new PlayerInfo( game.getPlayer( 3 ), game.getLocationOfPlayer( game.getPlayer( 3 ) ) );
            westPanelInfos.add( playerFourInfo );
         }
         
         leadershipTableButton = new OpenCloseJButton( "Leadership Table" );
         eastPanelButtons.add( leadershipTableButton );
         
         leadershipTable = new LeadershipTable( game.getLeadershipTable() );
         westPanelInfos.add( leadershipTable );
         
            // Adding buttons and game infos to east and west panels
         for( n = 0; n < eastPanelButtons.size(); n++ )
         {
            eastPanel.add( eastPanelButtons.get( n ) );
            westPanel.add( westPanelInfos.get( n ) );
            
            m = n; // cool, I wasnt expecting this works. ( if we directly put n instead of m's, it didnt work )
            
            eastPanelButtons.get( m ).addActionListener( new ActionListener() { 
               @Override
               public void actionPerformed( ActionEvent evt )
               {
                  if( eastPanelButtons.get( m ).isOpened() )
                  {
                     westPanelInfos.get( m ).setVisible( false );
                  }
                  else
                  {
                     closeOpenedWestPanelInfo();
                     westPanelInfos.get( m ).setVisible( true );
                  }
                  eastPanelButtons.get( m ).changeOpened();
               }
            } );
         }
         
            // TODO: Save Game
         save = new JButton( "Save" );
         eastPanel.add( save );
         
            // Exit Game
         exit = new JButton( "Exit" );
         eastPanel.add( exit );
         exit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               app.gameGui.setVisible( false );
               app.mainMenu.setVisible( true );
            }
         });
                  
         add( eastPanel, BorderLayout.EAST );
         add( westPanel, BorderLayout.WEST );
         
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
         
         setVisible( true );
         setSize( app.getSize() );
      }
   }
   
   // Methods
   
   // Roll Dice Button Listener ( TODO: must be clickable only one time for each player )
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
         
         currentPlayersInfo = getPlayerInfo( currentPlayer.getPlayerNo() );
         currentPlayersInfo.handleChanges( currentPlayer );
         leadershipTable.refresh( game.getLeadershipTable() );
         
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
      return (PlayerInfo) westPanelInfos.get( playerNo );
   }
   
   // returns if the method closed any info panels or not
   public boolean closeOpenedWestPanelInfo()
   {
      for ( n = 0; n < eastPanelButtons.size(); n++ )
      {         
         if ( eastPanelButtons.get( n ).isOpened() )
         {
            westPanelInfos.get( n ).setVisible( false );
            eastPanelButtons.get( n ).changeOpened();
            return true;
         }
      }
      
      return false;
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