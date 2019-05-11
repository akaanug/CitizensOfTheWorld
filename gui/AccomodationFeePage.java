package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import javax.swing.border.*;
import java.util.Observer;
import java.util.Observable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kaan.uguralp-ug
 */
public class AccomodationFeePage extends javax.swing.JPanel implements Observer 
{     
   Game game;
   
   // Constructor to setup the GUI components
   public AccomodationFeePage() {}
   
   /**
    * Creates new form AccomodationFeePageJ
    */
   public AccomodationFeePage( Game game ) 
   {
       initComponents();
       this.game = game;
       
       game.addObserver( this );
       
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
      
      jTextField1 = new javax.swing.JTextField();
      moneyField = new javax.swing.JTextField();
      exitButton = new javax.swing.JButton();
      
      setBackground(new java.awt.Color(204, 0, 204));
      
      jTextField1.setEditable(false);
      jTextField1.setBackground(new java.awt.Color(204, 0, 204));
      jTextField1.setFont(new java.awt.Font("Gisha", 0, 32)); // NOI18N
      jTextField1.setForeground(new java.awt.Color(0, 255, 255));
      jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      jTextField1.setText("ACCOMODATION FEE:");
      jTextField1.setToolTipText("");
      jTextField1.setBorder(null);
      
      moneyField.setFont(new java.awt.Font("Gisha", 0, 24)); // NOI18N
      moneyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      moneyField.setText("moneyLost");
      moneyField.setBorder(null);
      
      exitButton.setFont(new java.awt.Font("Gisha", 0, 11)); // NOI18N
      exitButton.setText("Exit");
      exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                                .addContainerGap())
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                             .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                             .addComponent(moneyField, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                                                .addGap(89, 89, 89))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                              .addContainerGap(133, Short.MAX_VALUE)
                                              .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(moneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addGap(26, 26, 26)
                                              .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addGap(74, 74, 74))
                             );
   }// </editor-fold>
   
   /*
    * action listener to describe what happens
    * when exit button of accomodation fee page clicked
    */
   public void handleActionListeners()
   {
      exitButton.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            game.lastStage();
         }
      } );
   }
   
   /*
    * updating the money field of accomodation fee page
    */
   public void update( Observable obs, Object obj )
   {
      Game game = (Game)obs;
      
      moneyField.setText( "- " + game.getCurrentLocation().getAccomodationFee() );    
      setVisible( game.getStage().equals( "accomodation fee" ) );
   }
   
   
   // Variables declaration - do not modify                     
   private javax.swing.JButton exitButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField moneyField;
   // End of variables declaration                   
}

