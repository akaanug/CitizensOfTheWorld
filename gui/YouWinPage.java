package gui;

import mainCode.*;
import javax.swing.border.*;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kaan.uguralp-ug
 */
public class YouWinPage extends javax.swing.JPanel implements Observer {
   
   /**
    * Creates new form YouWinPage
    */
   GameGUI parent;
   
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
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {

        moneyField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        refText = new javax.swing.JTextField();
        congText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 153));

        moneyField.setEditable(false);
        moneyField.setFont(new java.awt.Font("Gisha", 0, 48)); // NOI18N
        moneyField.setForeground(new java.awt.Color(51, 204, 51));
        moneyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        refText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        refText.setText("You got real estate investment!");
        refText.setBorder(null);

        congText.setEditable(false);
        congText.setBackground(new java.awt.Color(153, 255, 153));
        congText.setFont(new java.awt.Font("Gisha", 1, 36)); // NOI18N
        congText.setForeground(new java.awt.Color(204, 0, 204));
        congText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        congText.setText("CONGRATULATIONS!");
        congText.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(congText, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(refText, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(moneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(congText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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
   
   
   // Variables declaration - do not modify                     
   private javax.swing.JTextField congText;
   private javax.swing.JButton exitButton;
   private javax.swing.JLabel imgLabel;
   private javax.swing.JTextField moneyField;
   private javax.swing.JTextField refText;
   // End of variables declaration                   
}
