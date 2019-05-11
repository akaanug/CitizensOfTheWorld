package gui;

import java.awt.event.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;

public class GameOver extends javax.swing.JPanel implements Observer{
   Game game;
   public GameOver( Game game ) 
   {
       initComponents();
       this.game = game;
       
       game.addObserver( this );
       
       handleActionListeners();
       
       setVisible( false );        
    }
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {

        exitButton = new javax.swing.JButton();
        congText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 153));


        exitButton.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));;

        congText.setEditable(false);
        congText.setBackground(new java.awt.Color(255, 0, 0));
        congText.setFont(new java.awt.Font("Gisha", 1, 50)); // NOI18N
        congText.setForeground(new java.awt.Color(255, 255, 0));
        congText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        congText.setText("GAME OVER :(");
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
   }
   private void moneyFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {                                                  
      // TODO add your handling code here:
   }                                                 
   
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
   
   public void update( Observable obs, Object obj )
   {
      Game game = (Game)obs;
      
      setVisible( game.getStage().equals( "game over" ) );
   }
   
   
   // Variables declaration - do not modify                     
   private javax.swing.JTextField congText;
   private javax.swing.JButton exitButton;
   private javax.swing.JLabel imgLabel;
   private javax.swing.JTextField moneyField;
   private javax.swing.JTextField refText;
}