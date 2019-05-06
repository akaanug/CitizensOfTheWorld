package gui;

import java.awt.event.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;

public class YouLosePage extends JPanel implements Observer{
   
   /**
    * Creates new form YouLosePageJ
    */
   
   // Variables declaration    
   GameGUI parent;
   private JButton exitButton;
   private JTextField jTextField1;
   private JTextField moneyField;
   // End of variables declaration
   
   public YouLosePage() {}
   
   public YouLosePage( GameGUI parent ) {
      initComponents();
      this.parent = parent;
      
      parent.game.addObserver( this );
      
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
      
      setBackground(new java.awt.Color(255, 0, 0));
      
      jTextField1.setEditable(false);
      jTextField1.setBackground(new java.awt.Color(255, 0, 0));
      jTextField1.setFont(new java.awt.Font("Traditional Arabic", 1, 50)); // NOI18N
      jTextField1.setForeground(new java.awt.Color(255, 255, 0));
      jTextField1.setHorizontalAlignment(JTextField.CENTER);
      jTextField1.setText("YOU LOST");
      jTextField1.setBorder(null);
      
      moneyField.setFont(new java.awt.Font("Gisha", 0, 24)); // NOI18N
      moneyField.setHorizontalAlignment(JTextField.CENTER);
      moneyField.setText("lostMoney");
      moneyField.setBorder(null);
      
      exitButton.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
      exitButton.setText("Exit");
      exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      
      GroupLayout layout = new GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGap(32, 32, 32)
                                                                          .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGap(90, 90, 90)
                                                                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                       .addComponent(moneyField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                                                                       .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addContainerGap(39, Short.MAX_VALUE))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                              .addGap(152, 152, 152)
                                              .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(moneyField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                              .addContainerGap(52, Short.MAX_VALUE))
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
         moneyField.setText( "- " + ( game.getQuiz().getQuestionNumber() + 1 ) * 10 );
         
         setVisible( true );
      }
   }              
}
