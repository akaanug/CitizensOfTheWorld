package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import mainCode.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class PlayerMenu extends JPanel {
 
   // Private instance variables
   JButton back;
   JButton start;
   JButton numberOfPlayersButton; // the "OK" button.
   JPanel backAndStartPanel; // the panel that includes back and start buttons
   JPanel numberOfPlayersPanel; // the panel for the part we choose number of players
   CheckboxGroup numberOfPlayersGroup; 
   JPanel playerChoosePanel; // includes all 4 player selection panels
   JPanel playerOnePanel; // first player can select his name and country inside this
   JPanel playerTwoPanel;
   JPanel playerThreePanel;
   JPanel playerFourPanel;
   JList<String> countriesOne; // country list for every player ( inside scroll pane ) 
   JList<String> countriesTwo;
   JList<String> countriesThree;
   JList<String> countriesFour;
   ArrayList<String> listedCountries; // countries that are listed as in the game ( the usage explained above the method )
   String[] alphabeticalCountries; // we need alphabetical list of countries in scroll panes
   Application app; 
   int numberOfPlayers;
   
   // Constructor to setup the GUI components and event handlers
   public PlayerMenu( Application app ) 
   {
      this.app = app;
      
      createComponents();
      handleActionListeners();
      
      setSize( app.getSize() );   // "super" JFrame sets initial size
      setVisible( false );    // "super" JFrame shows
   }
   
   // Methods
   
   public void createComponents()
   {
      setSize( app.getSize() );
      setLayout( new BorderLayout() );
      
      // Number Of Players
      numberOfPlayersPanel = new JPanel( new FlowLayout() );
      numberOfPlayersGroup = new CheckboxGroup();
      
      numberOfPlayersPanel.add( new Label( "Choose Player Number" ) );
      numberOfPlayersPanel.add( new Checkbox( "1", numberOfPlayersGroup, false ) );
      numberOfPlayersPanel.add( new Checkbox( "2", numberOfPlayersGroup, false ) );
      numberOfPlayersPanel.add( new Checkbox( "3", numberOfPlayersGroup, false ) );
      numberOfPlayersPanel.add( new Checkbox( "4", numberOfPlayersGroup, false ) );
      
      numberOfPlayersButton = new JButton( "OK" );
      numberOfPlayersPanel.add( numberOfPlayersButton );
                               
      add( numberOfPlayersPanel, BorderLayout.NORTH );     
      
      // Players Choices
      playerChoosePanel = new JPanel();
      playerChoosePanel.setLayout( new BoxLayout( playerChoosePanel, BoxLayout.Y_AXIS ) );
      
      alphabeticalCountries = getAlphabeticalCountriesArray(); // will be needed in country lists
      
      countriesOne = playerChoicePanelCreator( playerOnePanel, countriesOne, 0 ); 
      countriesTwo = playerChoicePanelCreator( playerTwoPanel, countriesTwo, 1 ); 
      countriesThree = playerChoicePanelCreator( playerThreePanel, countriesThree, 2 ); 
      countriesFour = playerChoicePanelCreator( playerFourPanel, countriesFour, 3 ); 
      
      add( playerChoosePanel );
      
      // Back and Start Buttons
      backAndStartPanel = new JPanel( new FlowLayout() );
   
      back = new JButton( "Back" );
      backAndStartPanel.add( back ); 
      
      start = new JButton( "Start" );
      backAndStartPanel.add( start ); 
 
      add( backAndStartPanel, BorderLayout.SOUTH );
   }
   
   public void handleActionListeners()
   {
      numberOfPlayersButton.addActionListener( new OkBtnListener() );
      back.addActionListener( new BackBtnListener() );
      listedCountries = getListedCountries(); // will be needed when the game is starting
      start.addActionListener( new StartBtnListener() );
   }
   
   // OK Button listener ( BURAYI OPTÝMÝZE EDEBÝLÝRÝZ )
   private class OkBtnListener implements ActionListener 
   {
      @Override
      public void actionPerformed( ActionEvent evt ) 
      {
         int n;
         
         numberOfPlayers = Integer.parseInt( numberOfPlayersGroup.getSelectedCheckbox().getLabel() );
         
         for( n = 0; n < numberOfPlayers; n++ )
         {
            playerChoosePanel.getComponent( n ).setVisible( true );
         }
         for( n = numberOfPlayers; n < 4; n++ )
         {
            playerChoosePanel.getComponent( n ).setVisible( false );
         }
      }
   }
   
   // Back Button Listener
   public class BackBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         setVisible( false );
         app.mainMenu.setVisible( true );
      }
   }
   
   // Start Button Listener
   private class StartBtnListener implements ActionListener 
   {
      @Override
      public void actionPerformed( ActionEvent evt ) 
      {
         String[] namesOfPlayers;
         int[] locationsOfPlayers;
         String country;
         
         namesOfPlayers = new String[ numberOfPlayers ];
         locationsOfPlayers = new int[ numberOfPlayers ];
         for ( int n = 0; n < numberOfPlayers; n++ )
         {
            namesOfPlayers[ n ] = getPlayerName( n );
            locationsOfPlayers[ n ] = getSelectedCountry( n );
         }
         
         app.gameGui = new GameGUI( app, new Game( numberOfPlayers, locationsOfPlayers, namesOfPlayers ) ); 
         app.add( app.gameGui );
         setVisible( false );
      }
   }
   
   // Player Choice Panel Creator ( each player panel's code are similar, so we do all of them with one method
   public JList<String> playerChoicePanelCreator( JPanel playerPanel, JList<String> countryList, int playerNo )
   {
      playerPanel = new JPanel( new FlowLayout() );
      
      playerPanel.add( new JLabel( ( playerNo + 1 ) + "" ) );      
      playerPanel.add( new JTextField( 10 ) );
      countryList = new JList<String>( alphabeticalCountries );
      playerPanel.add( new JScrollPane( countryList ) );
      
      playerPanel.setVisible( false );
      playerChoosePanel.add( playerPanel ); 
      
      return countryList;
   }
   
   // These two methods are created in order to reach the player name textfields and country selection scrolls easily and in for loop
   public String getPlayerName( int playerNo )
   {
      return ( (JTextField)( (JPanel) playerChoosePanel.getComponent( playerNo ) ).getComponent( 1 ) ).getText();
   }
   
   public int getSelectedCountry( int playerNo )
   {
      if ( playerNo == 0 )
      {
         return listedCountries.indexOf( countriesOne.getSelectedValue().toString() );
      }
      else if ( playerNo == 1 )
      {
         return listedCountries.indexOf( countriesTwo.getSelectedValue().toString() );
      }
      else if ( playerNo == 2 )
      {
         return listedCountries.indexOf( countriesThree.getSelectedValue().toString() );
      }
      else 
      {
         return listedCountries.indexOf( countriesFour.getSelectedValue().toString() );
      }      
   }
   
   // Creates the country arraylist with the order in the game ( to determine the locations of players from the country they chose )
   public ArrayList<String> getAlphabeticalCountries() 
   {
      try
      {
         ArrayList<String> countries;
         FileReader fr;
         BufferedReader br;
         
         countries = new ArrayList<String>();
         fr = new FileReader( "Country Info\\countries alphabetical.txt" );
         br = new BufferedReader( fr );
         for( int n = 0; n < 60; n++ )
         {
            countries.add( br.readLine() );
         }
         
         return countries;
      }
      catch (IOException e)
      {
         return null;
      }
   }
      
   // Creates the country array in alphabetical order ( to make it compatible with JList )
   public String[] getAlphabeticalCountriesArray()
   {
      String[] arrayCountries;
      ArrayList<String> listCountries;
      
      arrayCountries = new String[ 60 ];
      listCountries = getAlphabeticalCountries();
      
      for ( int n = 0; n < 60; n++ )
      {
         arrayCountries[ n ] = listCountries.get( n );
      }
      
      return arrayCountries;
   }
   
   public ArrayList<String> getListedCountries() 
   {
      try
      {
         ArrayList<String> countries;
         FileReader fr;
         BufferedReader br;
         
         countries = new ArrayList<String>();
         fr = new FileReader( "Country Info\\countries listed.txt" );
         br = new BufferedReader( fr );
         for( int n = 0; n < 60; n++ )
         {
            countries.add( br.readLine() );
         }
         
         return countries;
      }
      catch (IOException e)
      {
         return null;
      }
   }
}