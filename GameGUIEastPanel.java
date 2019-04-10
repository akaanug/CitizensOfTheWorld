import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import java.util.ArrayList;
import util.*;

public class GameGUIEastPanel extends JPanel
{
   // properties
   GameGUI parent;
   JPanel westPanel;
   JPanel eastPanel;
   Game game;
   PlayerInfo playerOneInfo; 
   PlayerInfo playerTwoInfo;
   PlayerInfo playerThreeInfo;
   PlayerInfo playerFourInfo;
   LeadershipTable leadershipTable;
   OpenCloseJButton playerOneButton; // when clicked, the information of player appears or disappears 
   OpenCloseJButton playerTwoButton;
   OpenCloseJButton playerThreeButton;
   OpenCloseJButton playerFourButton;
   OpenCloseJButton leadershipTableButton; // when clicked, leadership table appears
   ArrayList<OpenCloseJButton> eastPanelButtons;
   ArrayList<JPanel> westPanelInfos;
   JButton save;
   JButton exit;
   
   // constructors
   public GameGUIEastPanel( GameGUI parent )
   {
      this.parent = parent;
      game = parent.game;
      
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
      
      if ( parent.numberOfPlayers >= 2 )
      {
         playerTwoButton = new OpenCloseJButton( game.getPlayer( 1 ).getName() );
         eastPanelButtons.add( playerTwoButton );
         
         playerTwoInfo = new PlayerInfo( game.getPlayer( 1 ), game.getLocationOfPlayer( game.getPlayer( 1 ) ) );
         westPanelInfos.add( playerTwoInfo );
      }
      
      if ( parent.numberOfPlayers >= 3 )
      {
         playerThreeButton = new OpenCloseJButton( game.getPlayer( 2 ).getName() );
         eastPanelButtons.add( playerThreeButton );
         
         playerThreeInfo = new PlayerInfo( game.getPlayer( 2 ), game.getLocationOfPlayer( game.getPlayer( 2 ) ) );
         westPanelInfos.add( playerThreeInfo );
      }
      
      if ( parent.numberOfPlayers == 4 )
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
      for( int n = 0; n < eastPanelButtons.size(); n++ )
      {
         eastPanel.add( eastPanelButtons.get( n ) );
         westPanel.add( westPanelInfos.get( n ) );
         
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
      
      add( westPanel );
      add( eastPanel );
      
      // Save Game
      save = new JButton( "Save" );
      eastPanel.add( save );
      
      // Exit Game
      exit = new JButton( "Exit" );
      eastPanel.add( exit );
      exit.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            parent.app.gameGui.setVisible( false );
            parent.app.mainMenu.setVisible( true );
         }
      });
   }
   
   // Methods
   
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
   
   public void refresh( Game g )
   {
      ( (PlayerInfo)( westPanelInfos.get( g.getTurnOfPlayer() ) ) ).refresh( g.getCurrentPlayer() );
      leadershipTable.refresh( g.getLeadershipTable() );
   }
}