import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class YouLosePage extends JPanel {
   
   // private variables
   JLabel money;
   JLabel all;
   JButton exit;
   private ImageIcon image;
   GameGUI parent;
   
   // Constructor to setup the GUI components
   public YouLosePage( GameGUI p ) 
   {
      //setBorderLayout();
      
      
      all = new JLabel();
      
      all.setLayout(null);
      
      this.parent = p;
      all.setPreferredSize( new Dimension(  481, 567 ) );
      money = new JLabel( "money" );
      
      money.setBounds( 138, 370, 195, 73 );
      money.setFont( new Font("Arial", Font.BOLD, 48) );
      money.setOpaque(true);
      money.setBackground(Color.white);
      all.add( money );
      
      exit = new JButton( "Exit" );
      exit.setBounds( 10, 0, 450, 30 );
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
   
   //Methods  
   public void refresh( int questionNumber  )
   {
      money.setText( "- " + ( 10 * ( questionNumber + 1 ) ) );
      
      setVisible( true );
   }
   
   public void paintComponent(Graphics page)
   {
      super.paintComponent (page);
         
      image = new ImageIcon ("Background Photos\\LoseFrame.gif");
      image.paintIcon (this, page, 0, 0);
   }
   
}
