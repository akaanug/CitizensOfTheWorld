package gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;

/*
 * PlayerLeftPage class creates the the panel of Game over after leaving or losing game
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class PlayerLeftPage extends JPanel implements Observer
{
   // properties
   Game game;
   
   // constructors
   public PlayerLeftPage( Game game ) 
   {      
       this.game = game;      
       game.addObserver( this );
       
       initComponents();
       handleActionListeners();       
    }
   
   // methods
   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {

        exitButton = new JButton();
        congText = new JTextField();
        moneyField = new JTextField();
        refText = new JTextField();
        
        setBackground(new Color(153, 255, 153));

        exitButton.setFont(new Font("Gisha", 0, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));;

        congText.setEditable(false);
        congText.setBackground(new Color(255, 0, 0));
        congText.setFont(new Font("Gisha", 1, 50)); // NOI18N
        congText.setForeground(new Color(255, 255, 0));
        congText.setHorizontalAlignment( JTextField.CENTER );
        congText.setText("GAME OVER :(");
        congText.setBorder(null);
        
        moneyField.setEditable(false);
        moneyField.setBackground(new Color(255, 0, 0));
        moneyField.setFont(new Font("Gisha", 1, 50)); // NOI18N
        moneyField.setForeground(new Color(255, 255, 0));
        moneyField.setHorizontalAlignment( JTextField.CENTER );
        moneyField.setText("money field");
        moneyField.setBorder(null);
        
        refText.setEditable(false);
        refText.setBackground(new Color(255, 0, 0));
        refText.setFont(new Font("Gisha", 1, 50)); // NOI18N
        refText.setForeground(new Color(255, 255, 0));
        refText.setHorizontalAlignment( JTextField.CENTER );
        refText.setText("refText");
        refText.setBorder(null);

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
   }
   private void moneyFieldInputMethodTextChanged(InputMethodEvent evt) {                                                  
      // TODO add your handling code here:
   }                                                 
   
   public void handleActionListeners()
   {
      exitButton.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            game.nextTurn();
         }
      } );
   }
   
   public void update( Observable obs, Object obj )
   {
      setVisible( game.getStage().equals( "player left" ) );
   }
   
   
   // Variables declaration - do not modify                     
   private JTextField congText;
   private JButton exitButton;
   private JLabel imgLabel;
   private JTextField moneyField;
   private JTextField refText;
}