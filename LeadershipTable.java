import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class LeadershipTable extends JPanel {
 
   // Private instance variables
   JPanel[] playerInfos;
   
   // Constructor to setup the GUI components and event handlers
   public LeadershipTable( Player[] leadershipTable ) 
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );        
     
      add( new Label( "Leadership Table" ) );
          
      playerInfos = new JPanel[ leadershipTable.length ];
      for( int n = 0; n < playerInfos.length; n++ )
      {
          playerInfos[n] = new JPanel();
      }
      
      for( int n = 0; n < playerInfos.length; n++ )
      {
         playerInfos[n].add( new JLabel( ( n + 1 ) + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getName() + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getNumberOfCountries() + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getMoney() + "" ) );
         add( playerInfos[n] );
      }                   
      
      setSize(250, 700);   // "super" JFrame sets initial size
      setVisible( false );    // "super" JFrame shows
   }   
   
   // methods
   public void refresh( Player[] leadershipTable )
   {
      removeAll( );
      
      add( new Label( "Leadership Table" ) );
      
      playerInfos = new JPanel[ leadershipTable.length ];
      for( int n = 0; n < playerInfos.length; n++ )
      {
          playerInfos[n] = new JPanel();
      }
      
      for( int n = 0; n < playerInfos.length; n++ )
      {
         playerInfos[n].add( new JLabel( ( n + 1 ) + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getName() + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getNumberOfCountries() + "     " ) );
         playerInfos[n].add( new JLabel( leadershipTable[n].getMoney() + "" ) );
         add( playerInfos[n] );
      }
   }    
}