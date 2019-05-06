package gui;

import mainCode.*;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.*;
import javax.swing.*;

public class YouWinPage extends JPanel implements Observer {
   
   // Variables declaration - do not modify        
   /**
    * Creates new form YouWinPage
    */
   GameGUI parent;
   private JTextField congText;
   private JButton exitButton;
   private JLabel imgLabel;
   private JTextField moneyField;
   private JTextField refText;
   // End of variables declaration   
   
   public YouWinPage() {}
   
   public YouWinPage( GameGUI parent ) {
      initComponents();
      this.parent = parent;
      
      parent.game.addObserver( this );
      
      //createComponents();
      handleActionListeners();
      
      setVisible( false );
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      
      moneyField = new JTextField();
      exitButton = new JButton();
      refText = new JTextField();
      congText = new JTextField();
      
      setBackground(new java.awt.Color(153, 255, 153));
      
      moneyField.setEditable(false);
      moneyField.setFont(new java.awt.Font("Gisha", 0, 48)); // NOI18N
      moneyField.setForeground(new java.awt.Color(51, 204, 51));
      moneyField.setHorizontalAlignment(JTextField.CENTER);
      moneyField.setText("$WIN");
      moneyField.setBorder(null);
      moneyField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      moneyField.addInputMethodListener(new java.awt.event.InputMethodListener() {
         public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
         }
         public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            moneyFieldInputMethodTextChanged(evt);
         }
      });
      
      exitButton.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
      exitButton.setText("Exit");
      exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));;
      
      refText.setEditable(false);
      refText.setBackground(new java.awt.Color(153, 255, 153));
      refText.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
      refText.setHorizontalAlignment(JTextField.CENTER);
      refText.setText("You got real estate investment!");
      refText.setBorder(null);
      
      congText.setEditable(false);
      congText.setBackground(new java.awt.Color(153, 255, 153));
      congText.setFont(new java.awt.Font("Gisha", 1, 36)); // NOI18N
      congText.setForeground(new java.awt.Color(204, 0, 204));
      congText.setHorizontalAlignment(JTextField.CENTER);
      congText.setText("CONGRATULATIONS!");
      congText.setBorder(null);
      
      GroupLayout layout = new GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addContainerGap()
                                                                          .addComponent(congText, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                       .addGroup(layout.createSequentialGroup()
                                                                                                    .addGap(51, 51, 51)
                                                                                                    .addComponent(refText, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                                                                                       .addGroup(layout.createSequentialGroup()
                                                                                                    .addGap(71, 71, 71)
                                                                                                    .addComponent(moneyField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                                                          .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())
                                   .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                              .addContainerGap(125, Short.MAX_VALUE)
                                              .addComponent(congText, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(refText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(moneyField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                              .addGap(35, 35, 35)
                                              .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                              .addGap(53, 53, 53))
                             );
   }// </editor-fold>         
   
   private void moneyFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {                                                  
      // TODO add your handling code here:
   }                                                 
   
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
         moneyField.setText( "+ " + game.getCurrentLocation().getTax() );
         
         setVisible( true );
      }
   }        
}
