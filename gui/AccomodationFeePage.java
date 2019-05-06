package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;

public class AccomodationFeePage extends JPanel implements Observer {
   
   // Variables declaration - do not modify                     
   private JButton exitButton;
   private JLabel jLabel1;
   private JTextField jTextField1;
   private JTextField moneyField;
   GameGUI parent;
   // End of variables declaration  
   
   // Constructor to setup the GUI components
   public AccomodationFeePage() {}
   
   /**
    * Creates new form AccomodationFeePageJ
    */
   public AccomodationFeePage( GameGUI parent ) {
      this.parent = parent;
      
      parent.game.addObserver( this );
      initComponents();
      
      handleActionListeners();
      
      setVisible( false );
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      
      jTextField1 = new JTextField();
      moneyField = new JTextField();
      exitButton = new JButton();
      
      setBackground(new java.awt.Color(204, 0, 204));
      
      jTextField1.setEditable(false);
      jTextField1.setBackground(new java.awt.Color(204, 0, 204));
      jTextField1.setFont(new java.awt.Font("Gisha", 0, 32)); // NOI18N
      jTextField1.setForeground(new java.awt.Color(0, 255, 255));
      jTextField1.setHorizontalAlignment(JTextField.CENTER);
      jTextField1.setText("ACCOMODATION FEE:");
      jTextField1.setToolTipText("");
      jTextField1.setBorder(null);
      
      moneyField.setFont(new java.awt.Font("Gisha", 0, 24)); // NOI18N
      moneyField.setHorizontalAlignment(JTextField.CENTER);
      moneyField.setText("moneyLost");
      moneyField.setBorder(null);
      
      exitButton.setFont(new java.awt.Font("Gisha", 0, 11)); // NOI18N
      exitButton.setText("Exit");
      exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      
      GroupLayout layout = new GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                                .addContainerGap())
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                             .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                             .addComponent(moneyField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                                                .addGap(89, 89, 89))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                              .addContainerGap(133, Short.MAX_VALUE)
                                              .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(moneyField, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                              .addGap(26, 26, 26)
                                              .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                              .addGap(74, 74, 74))
                             );
   }// </editor-fold>
   
   
   public void handleActionListeners()
   {
      exitButton.addActionListener( new ActionListener() { 
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
         moneyField.setText( "+ " + game.getCurrentLocation().getAccomodationFee() );
         
         setVisible( true );
      }
   }               
}
