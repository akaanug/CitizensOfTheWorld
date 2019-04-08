import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class YouWinPage extends JPanel {

   // private variables
   JLabel money;
   JLabel all;
   JButton exit;
   GameGUI parent;
   ImageIcon image;
   
   // Constructor to setup the GUI components
   public YouWinPage( GameGUI p ) 
   {
      all = new JLabel();
      
      all.setLayout(null);
      
      this.parent = p;
      
      all.setPreferredSize( new Dimension(  481, 567 ) );
      money = new JLabel( "money" );
      
      money.setBounds( 150, 470, 170, 69 );
      money.setFont( new Font("Arial", Font.BOLD, 48) );
      money.setOpaque(true);
      money.setBackground(Color.white);
      all.add( money );
      
      exit = new JButton( "Exit" );
      add( exit, BorderLayout.SOUTH );
      exit.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            setVisible( false );
            parent.nextTurn.setVisible( true );
         }
      } );
      
      all.add(exit);
      add(all);
      setVisible( false );
   }

   // Methods  
   public void refresh( int countryIncome )
   {
      money.setText( "+ " + countryIncome );
      
      setVisible( true );
   }
   
   public void paintComponent(Graphics page)
   {
      super.paintComponent (page);
         
      image = new ImageIcon ("Background Photos\\WinFrame.gif");
      image.paintIcon (this, page, 0, 0);
   }
   
   //test için belki sonra kullanılır baboş
//   public static void main (String[] args)
//   {
//      JFrame f = new JFrame();
//      YouWinPage p = new YouWinPage();
//      f.add(p);
//      f.setResizable(false);
//      f.setSize( 481, 567 );
//      f.setVisible( true );
//   }
}
