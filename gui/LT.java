/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author kaan
 */
public class LT extends javax.swing.JPanel {
   
   /**
    * Creates new form LeadershipTablePanel
    */
   public LT( int num, String names, int numOfCountries, int moneys ) {
      initComponents( num, names, numOfCountries, moneys );
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents( int num, String names, int numOfCountries, int moneys ) {
      
      name = new javax.swing.JLabel();
      noOfCountries = new javax.swing.JLabel();
      money = new javax.swing.JLabel();
      number = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      
      setBackground(new java.awt.Color(102, 255, 255));
      
      name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      name.setText(names);
      
      noOfCountries.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      noOfCountries.setText(numOfCountries + "");
      
      money.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      money.setText( moneys + "" );
      
      number.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      number.setForeground(new java.awt.Color(255, 0, 0));
      number.setText(num + ".");
      
      jLabel1.setOpaque(true);
      
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                          .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGap(22, 22, 22)
                                                                          .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                       .addComponent(noOfCountries, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                          .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())
                                   .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                              .addContainerGap()
                                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                           .addComponent(number)
                                                           .addComponent(name))
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(noOfCountries)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                             );
   }// </editor-fold>                        
   
   public void change( int num, String names, int numOfCountries, int moneys )
   {
      number.setText( num + "" );
      name.setText( names );
      noOfCountries.setText( numOfCountries + "" );
      money.setText( moneys + "" );
      
   }
   
   
   // Variables declaration - do not modify  
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel money;
   private javax.swing.JLabel name;
   private javax.swing.JLabel noOfCountries;
   private javax.swing.JLabel number;
   // End of variables declaration                   
}
