package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;
import java.util.ArrayList;

public class GameGUIEastPanel extends JPanel
{
   // properties
   GameGUI parent;
   JPanel westPanel;
   JPanel eastPanel;
   Game game;
   ArrayList<OpenCloseJButton> eastPanelButtons;
   ArrayList<JPanel> westPanelInfos;
   JButton save;
   JButton exit;
   
   // constructors
   public GameGUIEastPanel( GameGUI parent )
   {
      this.parent = parent;
      game = parent.game;
      
      createComponents();
      handleActionListeners();
   }
   
   // Methods
   
   public void createComponents()
   {
      eastPanel = new JPanel();
      eastPanel.setLayout( new BoxLayout( eastPanel, BoxLayout.Y_AXIS ) );
      westPanel = new JPanel();
      westPanel.setLayout( new FlowLayout() );
      
      // Declaring East Panel Buttons and West Panel Infos
      eastPanelButtons = new ArrayList<OpenCloseJButton>();
      westPanelInfos = new ArrayList<JPanel>();
      
      for ( int n = 0; n < game.getNumberOfPlayers(); n++ )
      {
         eastPanelButtons.add( new OpenCloseJButton( game.getPlayer( n ).getName() ) );
         westPanelInfos.add( new PlayerInfo( game, n ) );
      }                         
      eastPanelButtons.add( new OpenCloseJButton( "Leadership Table" ) );
      westPanelInfos.add( new LeadershipTablePanel( game.getLeadershipTable() ) );
      
      for( int n = 0; n < eastPanelButtons.size(); n++ )
      {
         eastPanel.add( eastPanelButtons.get( n ) );
         westPanel.add( westPanelInfos.get( n ) );
      }
      
      // Save Game
      save = new JButton( "Save" );
      eastPanel.add( save );
      
      // Exit Game
      exit = new JButton( "Exit" );
      eastPanel.add( exit );
      
      add( westPanel );
      add( eastPanel );
   }
   
   public void handleActionListeners()
   {
      // Button Listeners for Player Infos and Leadership Table
      for( int n = 0; n < eastPanelButtons.size(); n++ )
      {       
         int m = n; 
         
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
      
      // Exit Button Listener
      exit.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            parent.app.gameGui.setVisible( false );
            parent.app.mainMenu.setVisible( true );
         }
      });
   }
   
   // returns if the method closed any info panels or not
   public boolean closeOpenedWestPanelInfo()
   {
      for ( int n = 0; n < eastPanelButtons.size(); n++ )
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
   
   public PlayerInfo getPlayerInfo( int playerNo )
   {
      return (PlayerInfo) westPanelInfos.get( playerNo );
   }
}