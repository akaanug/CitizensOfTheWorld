package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;


/*
 * MainMenu creates components in the main menu.
 * @author Batuhan Gelgi
 * @version 12.05.2019
 */
public class MainMenu extends JPanel {

   // private variables
   public static final int DEFAULT_X_SIZE = 1366;
   public static final int DEFAULT_Y_SIZE = 736;
   double xSize;
   double ySize;
   JButton newGame;
   JButton credits;
   JButton loadGame;
   JButton howToPlay;
   JButton exit;
   ArrayList<JButton> buttons;
   JPanel namePanel;
   Application app;
   
   // Constructor to setup the GUI components
   public MainMenu( Application application ) 
   {            
      setSize( application.getSize() );
      
      xSize = (double)getWidth() / DEFAULT_X_SIZE;
      System.out.println( getX() );
      ySize = (double)getHeight() / DEFAULT_Y_SIZE;
      System.out.println( xSize );
      
      this.app = application; 
      
      createComponents();
      handleActionListeners();
   }
   
   // methods
   
   // creation of components of MainMenuPage
   public void createComponents()
   {
      GridBagConstraints c;
      GridBagLayout layout;      
      setLayout( new GridBagLayout() );
      c = new GridBagConstraints(); 
      
      // Arrange Button Graphics
      buttons = new ArrayList<JButton>();
      
      newGame = buttonShapeArranger( "New Game", 108, 40, Color.orange );
      buttonLocationArranger( newGame, 0, 277, c );
      buttons.add( newGame );
      
      loadGame = buttonShapeArranger( "Load Game", 68, 33, Color.green );
      buttonLocationArranger( loadGame, 1, 12, c );
      buttons.add( loadGame );
      
      howToPlay = buttonShapeArranger( "How To Play", 62, 25, Color.blue );
      buttonLocationArranger( howToPlay, 2, 10, c );
      buttons.add( howToPlay );      
      
      credits = buttonShapeArranger( "Credits", 62, 25, Color.magenta );
      buttonLocationArranger( credits, 3, 10, c );
      buttons.add( credits );
      
      exit = buttonShapeArranger( "Exit", 62, 25, Color.black );
      buttonLocationArranger( exit, 4, 10, c );
      buttons.add( exit );
   }
   
   /*
    * adding action listeners for MainMenu class
    */
   public void handleActionListeners()
   {
      // Add listeners to the buttons
      for( int n = 0; n < buttons.size(); n++ )
      {
         int m = n;
         
         // Add action listeners
         if ( m < buttons.size() - 1 )
         {
            buttons.get( m ).addActionListener( new ActionListener() { 
               @Override
               public void actionPerformed( ActionEvent evt )
               {
                  setVisible( false );
                  app.panels.get( m + 1 ).setVisible( true );
               }
            } );
         }
         else
         {
            buttons.get( m ).addActionListener( new ActionListener() { 
               @Override
               public void actionPerformed( ActionEvent evt )
               {
                  System.exit( 0 );
               }
            } );
         }
         
         // Add change listeners
         buttons.get( m ).addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            { 
               ButtonModel aModel = buttons.get( m ).getModel();
               
               if ( aModel.isRollover() )
               {
                  buttons.get( m ).setBackground( Color.red );
               }
               else
               {
                  buttons.get( m ).setBackground( Color.white );
               }
            }
         } );
      }
   }
   
   // Button Location Arranger
   public void buttonLocationArranger( JButton button, int gridy, int insetNorth, GridBagConstraints c )
   {
      c.gridy = gridy;
      c.insets = new Insets( (int)( insetNorth * ySize ), 0, 0, 0 );
      
      add( button, c );
   }
   
   // Button Shape Arranger
   public JButton buttonShapeArranger( String name, int y, int font, Color foreground )
   {
      JButton b = new JButton( name );
      
      b.setBackground( Color.white );
      b.setPreferredSize( new Dimension( (int)(343 * xSize), (int)( y * ySize ) ) );
      b.setFont( new Font( name, Font.ITALIC, font ) );
      b.setForeground( foreground );
      b.setBorder( new LineBorder( Color.black, 2 ) );
      
      return b;
   }
   
   // Adding Background photo
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent( g );
      
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\Background Photos\\Main Menu.jpeg" ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, 0,0,getWidth(),getHeight(), this);
      g2.dispose();
   }
}