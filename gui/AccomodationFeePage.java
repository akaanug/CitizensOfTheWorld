package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import javax.swing.border.*;
import java.util.Observer;
import java.util.Observable;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class AccomodationFeePage extends JPanel implements Observer 
{   
   // private variables
   JPanel container;
   JLabel money;
   JButton exit;
   GameGUI parent;
   
   // Constructor to setup the GUI components
   public AccomodationFeePage() {}
   
   public AccomodationFeePage( GameGUI parent ) 
   {
      this.parent = parent;
      
      parent.game.addObserver( this );
      
      createComponents();
      handleActionListeners();
      
      setVisible( false );
   }
   
   // Methods  
   public void createComponents()
   {       
      setLayout( new BorderLayout() );
      setPreferredSize( new Dimension(  481, 567 ) );
      
      container = new JPanel();
      container.setLayout( new GridLayout( 2, 1 ) );
      container.setOpaque( false );
      
      // Money Label
      money = new JLabel();
      money.setBackground( Color.white );
      money.setOpaque( true );
      money.setBorder( new LineBorder( Color.black, 2 ) );
      money.setPreferredSize( new Dimension ( 184, 75 ) );
      JPanel moneyPanel = new JPanel();
      moneyPanel.add( money );
      moneyPanel.setOpaque( false );
      container.add( moneyPanel );
      
      // Exit Button
      exit = new JButton( "Exit" );
      exit.setPreferredSize( new Dimension ( 130, 60 ) );
      JPanel exitPanel = new JPanel();
      exitPanel.add( exit );
      exitPanel.setOpaque( false );
      container.add( exitPanel );
      
      add( container, BorderLayout.SOUTH );
      
   }
   
   public void handleActionListeners()
   {
      exit.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            setVisible( false );
            parent.nextTurn.setVisible( true );
         }
      } );
   }
   
   public void update( Observable obs, Object obj )
   {
      Game game = (Game)obs;
      
      if( obj.getClass() == this.getClass() )
      {
         money.setText( "+ " + game.getCurrentLocation().getAccomodationFee() );
         
         setVisible( true );
      }
   }
   
   public void paintComponent( Graphics g )
   {
      super.paintComponent(g);
      
      Image image = new ImageIcon(getClass().getResource( "..\\Background Photos\\AccomodationFrame.gif" ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( image, 0,0,getWidth(),getHeight(), this);
      g2.dispose();
   }
}
