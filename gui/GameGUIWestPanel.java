package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers
import mainCode.*;
import util.*;

public class GameGUIWestPanel extends JPanel 
{
   // properties
   JPanel shadowButtonPanel;
   JPanel shadowPlayerInfo;
   int buttonPanelWidth;
   int playerInfoWidth;
   
   // constructors
   public GameGUIWestPanel( )
   {
      createComponents();
   }
   
   // Methods
   
   public void createComponents()
   {
      setOpaque( false );
      
      shadowButtonPanel = new JPanel();
      shadowButtonPanel.setOpaque( false );
      add( shadowButtonPanel );
      
      shadowPlayerInfo = new JPanel();
      shadowPlayerInfo.setOpaque( false );
      shadowPlayerInfo.setVisible( false );
      add( shadowPlayerInfo );
   }
   
   public void setButtonPanelSize( int width )
   {
      shadowButtonPanel.setPreferredSize( new Dimension( width, 1 ) );
   }
   
   public void setPlayerInfoSize( int width )
   {
      shadowPlayerInfo.setPreferredSize( new Dimension( width, 1 ) );
   }
   
   public void changePlayerInfoVisibility( boolean b )
   {
      shadowPlayerInfo.setVisible( b );
   }
}