package gui;

import java.io.*;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.io.Serializable;

/**
 * A GUI program is written as a subclass of Frame - the top-level container
 * This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
 * @author Emin Adem Buran
 * @version 12.05.2019
 */
public class SaveGame extends JPanel{
   
   //properties
   int numberOfSavedGames;
   String[] nameOfSavedFiles;
   Game g;
   GameGUI parent;
   JButton exit;
   JTextField saveGame;
   File savedGames;
   JPanel savedGamesPanel;
   String fileName;
   
   
   //constructors
   public SaveGame( GameGUI parent) 
   {
      fileName = "";
      
      setLayout( new BorderLayout() );
      
      this.parent = parent;
      this.g = parent.game;
            
      numberOfSavedGames = 0;
      
      savedGames = new File("saved games");
      
      nameOfSavedFiles = savedGames.list();
      
      for (File file : savedGames.listFiles()) 
      {
         if (file.isFile()) 
         {
            numberOfSavedGames++;
         }
      }
      
      savedGamesPanel = new JPanel();
      savedGamesPanel.setLayout( new GridLayout( numberOfSavedGames + 1, 1 ) );
      
      
      for( int i = 0; i < numberOfSavedGames; i++ )
      {
         JButton savedFileButton;
         savedFileButton = new JButton( nameOfSavedFiles[i] );
         savedGamesPanel.add( savedFileButton );
      }
      
      JButton savedFileButton2;
      savedFileButton2 = new JButton( "Save New Game" );
      savedGamesPanel.add( savedFileButton2 );
      savedFileButton2.addActionListener( new SavedGameButtoListener() );
      
      exit = new JButton( "Exit" );
      exit.addActionListener( new SaveGamePanelListener());
      
      saveGame = new JTextField(10);
      saveGame.addActionListener( new SaveGamePanelListener());
      add( saveGame, BorderLayout.NORTH ); 
       
      add( savedGamesPanel, BorderLayout.CENTER );
      add(exit, BorderLayout.SOUTH);          
      setVisible(false);
   }
   
   // SaveGamePanel listener
   public class SaveGamePanelListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         if( e.getSource() == saveGame )
         {
            fileName = saveGame.getText();
         }
         else
         {
            setVisible( false );
         }
      }
   }
   
   // SavedGameButton listener
   public class SavedGameButtoListener implements ActionListener
   {
      public void actionPerformed( ActionEvent evt)
      {
         JButton sb = ( JButton )evt.getSource();
         g.saveGame( fileName );
         sb.setBackground(Color.RED);
         
      }
   }
}