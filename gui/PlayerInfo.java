package gui;

import java.awt.*;  
import java.awt.event.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import javax.swing.*;

public class PlayerInfo extends JPanel implements Observer{
   
   // Variables declaration - do not modify   
   Player p;
   Game game;
   ArrayList<JPanel> countries;                 
   private JPanel countriesPanel;
   private JLabel currentMoney;
   private JLabel location;
   private JLabel nationality;
   private JLabel playerName;
   private JLabel revenue;
   // End of variables declaration    
   
   /**
    * Creates new form PlayerInfoJ
    */
   
   public PlayerInfo( Game game, int playerNo ) {
      
      this.game = game;
      p = game.getPlayer( playerNo );
      
      p.addObserver( this );
      countries = new ArrayList<JPanel>();
      
      initComponents();
      countriesPanel.setLayout( new BoxLayout( countriesPanel, BoxLayout.Y_AXIS  ) );
      setVisible( false );
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      
      playerName = new JLabel();
      currentMoney = new JLabel();
      revenue = new JLabel();
      nationality = new JLabel();
      countriesPanel = new JPanel();
      location = new JLabel();
      
      setBackground(new java.awt.Color(102, 255, 255));
      
      playerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      playerName.setForeground(new java.awt.Color(0, 0, 102));
      playerName.setHorizontalAlignment(SwingConstants.CENTER);
      playerName.setText( "Nickname: " + p.getName() );
      
      currentMoney.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      currentMoney.setText("currentMoney");
      
      revenue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      revenue.setText("revenue");
      
      nationality.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      nationality.setText( "Nationality: " + game.getLocationOfPlayer( p ).getName() );
      
      countriesPanel.setBackground(new java.awt.Color(102, 255, 255));
      
      GroupLayout countriesPanelLayout = new GroupLayout(countriesPanel);
      countriesPanel.setLayout(countriesPanelLayout);
      countriesPanelLayout.setHorizontalGroup(
                                              countriesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                 .addGap(0, 0, Short.MAX_VALUE)
                                             );
      countriesPanelLayout.setVerticalGroup(
                                            countriesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                               .addGap(0, 72, Short.MAX_VALUE)
                                           );
      
      location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      location.setText("location");
      
      GroupLayout layout = new GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addComponent(playerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(countriesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                             .addComponent(location, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                             .addComponent(revenue, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                             .addComponent(currentMoney, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                                             .addComponent(nationality, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                              .addComponent(playerName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                              .addGap(3, 3, 3)
                                              .addComponent(currentMoney, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(nationality, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(revenue)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(location, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(countriesPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                              .addGap(0, 11, Short.MAX_VALUE))
                             );
   }// </editor-fold>   
   
   public void createCountryPanel( Country c )
   {
      JPanel panel = new JPanel();
      
      panel.add( new JLabel( c.getName() ) );
      panel.add( new JLabel( c.getTax() + "" ) );
      
      countries.add( panel );
      countriesPanel.add( panel );
   }
   
   public void update( Observable obs, Object obj )
   {
      currentMoney.setText( "Money: " + p.getMoney()  );
      revenue.setText( "Revenue: " + p.getRevenue() );
      
      if ( countries.size() < p.getNumberOfCountries() )
      {
         createCountryPanel( p.getLastCountry() );
      }
   }               
}