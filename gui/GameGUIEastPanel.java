package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.ArrayList;

/*
 * GameGUIEastPanel class creates the components located in the Easthern part of GUIPanel
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class GameGUIEastPanel extends JPanel 
{
   // properties
   int buttonSize;
   GameGUI parent;
   GameGUIWestPanel westPanel;
   JPanel buttonPanel;
   JPanel infoPanel;
   Game game;
   ArrayList<OpenCloseJButton> buttons;
   ArrayList<JPanel> infos;
   JButton save;
   JButton exit;
   
   // constructors
   public GameGUIEastPanel( GameGUIWestPanel westPanel, GameGUI parent )
   {
      this.westPanel = westPanel;
      this.parent = parent;
      game = parent.game;
         
      createComponents();
      handleActionListeners();
   }
   
   // methods
   
   /*
    * creating the components of GameGuýEastPanel
    */
   public void createComponents()
   {
      setOpaque( false );
      
      buttonPanel = new JPanel();
      buttonPanel.setOpaque( false );
      buttonPanel.setLayout( new GridLayout( 7, 1 ) );
      
      infoPanel = new JPanel();
      infoPanel.setOpaque( false );
      infoPanel.setLayout( new FlowLayout() );
      
      // Declaring button and info panels
      buttons = new ArrayList<OpenCloseJButton>();
      infos = new ArrayList<JPanel>();
      
      buttonSize = ( parent.getHeight() - 150 ) / 7;
      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         buttons.add( new OpenCloseJButton( game.getPlayer( n ), buttonSize ) );
         infos.add( new PlayerInfo( game, n ) );
      }                         
      buttons.add( new OpenCloseJButton( "Leadership", buttonSize ) );
      infos.add( new LeadershipTablePanel( game.getLeadershipTable() ) );
      
      for( int n = 0; n < buttons.size(); n++ )
      {
         buttonPanel.add( buttons.get( n ) );
         infoPanel.add( infos.get( n ) );
      }
      
      for ( int n = buttons.size(); n < 5; n++ )
      {
         JPanel temporaryPanel = new JPanel();
         temporaryPanel.setOpaque( false );
         buttonPanel.add( temporaryPanel );
      }
      
      // Handling west panel
      westPanel.setButtonPanelSize( buttonSize );
      westPanel.setPlayerInfoSize( (int) PlayerInfo.SIZE.getWidth() );
      
      // Save Game
      save = new JButton( "Save" );
      buttonPanel.add( save );
      
      // Exit Game
      exit = new JButton( "Exit" );
      buttonPanel.add( exit );
      
      add( infoPanel );
      add( buttonPanel );
   }
   
   //adding action listener for probable operations of GameGuýEastPanel
   public void handleActionListeners()
   {
      // Button Listeners for Player Infos and Leadership Table
      for( int n = 0; n < buttons.size(); n++ )
      {       
         int m = n; 
         
         buttons.get( m ).addActionListener( new ActionListener() { 
            @Override
            public void actionPerformed( ActionEvent evt )
            {
               if( buttons.get( m ).isOpened() )
               {
                  infos.get( m ).setVisible( false );
                  westPanel.changePlayerInfoVisibility( false );
               }
               else
               {
                  closeOpenedWestPanelInfo();
                  infos.get( m ).setVisible( true );
                  westPanel.changePlayerInfoVisibility( true );
               }
               buttons.get( m ).changeOpened();
            }
         } );
      }
      
      // Exit Button Listener
      exit.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            parent.app.gameGui.setVisible( false );
            parent.app.mainMenu.setVisible( true );
         }
      });
      
      // Save Button Listener
      save.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            parent.saveGame.setVisible( true );
         }
      });
   }
   
   /*
    * returns if the method closed any info panels or not
    * @return whether any panels closed or not
    */
   public boolean closeOpenedWestPanelInfo()
   {
      for ( int n = 0; n < buttons.size(); n++ )
      {         
         if ( buttons.get( n ).isOpened() )
         {
            infos.get( n ).setVisible( false );
            westPanel.changePlayerInfoVisibility( false );
            
            buttons.get( n ).changeOpened();
            return true;
         }
      }
      
      return false;
   }
   
   /*
    * learn info of player with given playerNo
    * @param1 playerNo
    * @return the info of player( playerNo) 
    */
   public PlayerInfo getPlayerInfo( int playerNo )
   {
      return (PlayerInfo) infos.get( playerNo );
   }
}