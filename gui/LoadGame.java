package gui;

import mainCode.*;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.Serializable;

/**
 * A GUI program is written as a subclass of Frame - the top-level container
 * This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
 * @author Emin Adem Buran
 * @version 12.05.2019
 */
public class LoadGame extends JPanel{
   
   // private variables
   int numberOfSavedGames;
   File savedGames;
   JPanel savedGamesPanel;
   JButton back;
   String[] nameOfSavedFiles;
   JButton load;
   Application app;
   Game g;
//   JTextField loadGameField;
   
   // Constructor to setup the GUI components
   public LoadGame( Application app ) 
   {    
      setLayout( new BorderLayout() );
      setVisible( false );
      setSize( app.getSize() );
      
      this.app = app;
      
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
      
      if( numberOfSavedGames == 0)
      {
         JLabel noSavedFileLabel;
         noSavedFileLabel = new JLabel( "There is no saved games" );
         savedGamesPanel.add( noSavedFileLabel );
      }
      else
      {
         for( int i = 0; i < numberOfSavedGames; i++ )
         {
            JButton savedFileButton;
            savedFileButton = new JButton( nameOfSavedFiles[i] );
            savedGamesPanel.add( savedFileButton );
            savedFileButton.addActionListener( new SavedGameButtoListener() );
         }
      }
      
      JPanel p = new JPanel();
      g = new Game();
      
      back = new JButton( "Back" );
      back.addActionListener( new BackBtnListener() );
      
      load = new JButton( "load" );
      load.addActionListener( new LoadBtnListener() );
      
      p.add(load);
      p.add(back);
      add( p, BorderLayout.SOUTH);
           
      add( savedGamesPanel, BorderLayout.CENTER );
   }
   
   // methods
   
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
   
   // Load Button Listener
   public class LoadBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         if( numberOfSavedGames > 0)
         {
            app.gameGui = new GameGUI( app, g ); 
            app.add( app.gameGui );
            setVisible( false );
         }
         
      }
   }
   
   // Saved Game ButtonListener 
   public class SavedGameButtoListener implements ActionListener
   {
      public void actionPerformed( ActionEvent evt)
      {
         JButton sb = ( JButton )evt.getSource();
         String fileName = sb.getText();
         g = g.loadGame( fileName );
         sb.setBackground(Color.RED);
      }
   }
}