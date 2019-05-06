package gui;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.BorderFactory;
import mainCode.*;
import mainCode.pictureClasses.Avatar;
import util.GameFileReader;

public class PlayerMenu extends JPanel {
   
   // Variables declaration - do not modify 
   int numberOfPlayers;
   ArrayList<String> listedCountries; // countries that are listed as in the game ( the usage explained above the method )
   String[] alphabeticalCountries; // we need alphabetical list of countries in scroll panes
   Avatar[] avatars;
   Application app;                        
   private JList avatarList1;
   private JList avatarList2;
   private JList avatarList3;
   private JList avatarList4;
   private JButton back;
   private JList countryList1;
   private JList countryList2;
   private JList countryList3;
   private JList countryList4;
   private JRadioButton fourCheck;
   private JLabel jLabel1;
   private JTextField p3Name;
   private JTextField p4Name;
   private JRadioButton oneCheck;
   private JScrollPane p1Avatar;
   private JScrollPane p1Country;
   private JTextField p1Name;
   private JPanel p1Panel;
   private JScrollPane p2Avatar;
   private JScrollPane p2Country;
   private JTextField p2Name;
   private JPanel p2Panel;
   private JScrollPane p3Avatar;
   private JScrollPane p3Country;
   private JPanel p3Panel;
   private JScrollPane p4Avatar;
   private JScrollPane p4Country;
   private JPanel p4Panel;
   private JButton start;
   private JRadioButton threeCheck;
   private JRadioButton twoCheck;
   // End of variables declaration  
   
   /**
    * Creates new form PlayerMenu
    */
   public PlayerMenu( Application app ) {
      
      this.app = app;
      
      alphabeticalCountries = GameFileReader.getAlphabeticalCountriesArray(); // will be needed in country lists
      avatars = GameFileReader.getAvatarsArray(); // will be needed in avatar lists   
      listedCountries = GameFileReader.getListedCountries(); // will be needed when the game is starting
      
      initComponents();
      
      p1Panel.setVisible(false);
      p2Panel.setVisible(false);
      p3Panel.setVisible(false);
      p4Panel.setVisible(false);
      
      setSize( app.getSize() );   // "super" JFrame sets initial size
      setVisible( false );    // "super" JFrame shows
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      
      jLabel1 = new JLabel();
      p1Panel = new JPanel();
      p1Name = new JTextField();
      p1Country = new JScrollPane();
      countryList1 = new JList();
      p1Avatar = new JScrollPane();
      avatarList1 = new JList();
      p2Panel = new JPanel();
      p2Name = new JTextField();
      p2Country = new JScrollPane();
      countryList2 = new JList();
      p2Avatar = new JScrollPane();
      avatarList2 = new JList();
      p3Panel = new JPanel();
      p3Name = new JTextField();
      p3Country = new JScrollPane();
      countryList3 = new JList();
      p3Avatar = new JScrollPane();
      avatarList3 = new JList();
      p4Panel = new JPanel();
      p4Name = new JTextField();
      p4Country = new JScrollPane();
      countryList4 = new JList();
      p4Avatar = new JScrollPane();
      avatarList4 = new JList();
      oneCheck = new JRadioButton();
      twoCheck = new JRadioButton();
      threeCheck = new JRadioButton();
      fourCheck = new JRadioButton();
      back = new JButton();
      start = new JButton();
      
      setBackground(new java.awt.Color(102, 255, 255));
      
      jLabel1.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
      jLabel1.setText("Choose Player Number");
      
      p1Panel.setBackground(new java.awt.Color(153, 255, 153));
      
      p1Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p1Name.setForeground(new java.awt.Color(0, 102, 0));
      p1Name.setText("Enter Nickname");
      
      p1Country.setBackground(new java.awt.Color(204, 255, 204));
      p1Country.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p1Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList1.setModel(new AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p1Country.setViewportView(countryList1);
      
      p1Avatar.setBackground(new java.awt.Color(204, 255, 204));
      p1Avatar.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList1.setModel(new AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p1Avatar.setViewportView(avatarList1);
      avatarList1.setVisibleRowCount( 3 );
      avatarList1.setLayoutOrientation( JList.HORIZONTAL_WRAP );
      
      GroupLayout p1PanelLayout = new GroupLayout(p1Panel);
      p1Panel.setLayout(p1PanelLayout);
      p1PanelLayout.setHorizontalGroup(
                                       p1PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addGroup(p1PanelLayout.createSequentialGroup()
                                                       .addContainerGap()
                                                       .addComponent(p1Name, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                       .addGap(58, 58, 58)
                                                       .addComponent(p1Country, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                       .addGap(18, 18, 18)
                                                       .addComponent(p1Avatar, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                                                       .addContainerGap())
                                      );
      p1PanelLayout.setVerticalGroup(
                                     p1PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(p1PanelLayout.createSequentialGroup()
                                                     .addGap(69, 69, 69)
                                                     .addComponent(p1Name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, p1PanelLayout.createSequentialGroup()
                                                     .addContainerGap()
                                                     .addGroup(p1PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                  .addComponent(p1Avatar)
                                                                  .addComponent(p1Country, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                                                     .addContainerGap())
                                    );
      
      p2Panel.setBackground(new java.awt.Color(255, 255, 153));
      
      p2Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p2Name.setForeground(new java.awt.Color(102, 102, 0));
      p2Name.setText("Enter Nickname");
      
      p2Country.setBackground(new java.awt.Color(255, 255, 204));
      p2Country.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p2Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList2.setModel(new AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p2Country.setViewportView(countryList2);
      
      p2Avatar.setBackground(new java.awt.Color(255, 255, 204));
      p2Avatar.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList2.setModel(new AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p2Avatar.setViewportView(avatarList2);
      avatarList2.setVisibleRowCount( 3 );
      avatarList2.setLayoutOrientation( JList.HORIZONTAL_WRAP );
      
      GroupLayout p2PanelLayout = new GroupLayout(p2Panel);
      p2Panel.setLayout(p2PanelLayout);
      p2PanelLayout.setHorizontalGroup(
                                       p2PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addGroup(p2PanelLayout.createSequentialGroup()
                                                       .addContainerGap()
                                                       .addComponent(p2Name, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                       .addGap(59, 59, 59)
                                                       .addComponent(p2Country, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                                       .addGap(18, 18, 18)
                                                       .addComponent(p2Avatar, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                                                       .addContainerGap())
                                      );
      p2PanelLayout.setVerticalGroup(
                                     p2PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, p2PanelLayout.createSequentialGroup()
                                                     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                     .addComponent(p2Name, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                     .addGap(74, 74, 74))
                                        .addGroup(GroupLayout.Alignment.TRAILING, p2PanelLayout.createSequentialGroup()
                                                     .addContainerGap()
                                                     .addGroup(p2PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                  .addComponent(p2Avatar)
                                                                  .addComponent(p2Country, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                                     .addContainerGap())
                                    );
      
      p3Panel.setBackground(new java.awt.Color(255, 153, 153));
      
      p3Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p3Name.setForeground(new java.awt.Color(153, 0, 0));
      p3Name.setText("Enter Nickname");
      
      p3Country.setBackground(new java.awt.Color(255, 204, 204));
      p3Country.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p3Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList3.setModel(new AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p3Country.setViewportView(countryList3);
      
      p3Avatar.setBackground(new java.awt.Color(255, 204, 204));
      p3Avatar.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList3.setModel(new AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p3Avatar.setViewportView(avatarList3);
      avatarList3.setVisibleRowCount( 3 );
      avatarList3.setLayoutOrientation( JList.HORIZONTAL_WRAP );
      
      GroupLayout p3PanelLayout = new GroupLayout(p3Panel);
      p3Panel.setLayout(p3PanelLayout);
      p3PanelLayout.setHorizontalGroup(
                                       p3PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addGroup(p3PanelLayout.createSequentialGroup()
                                                       .addContainerGap()
                                                       .addComponent(p3Name, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                       .addGap(53, 53, 53)
                                                       .addComponent(p3Country, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                       .addGap(18, 18, 18)
                                                       .addComponent(p3Avatar, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                                                       .addContainerGap())
                                      );
      p3PanelLayout.setVerticalGroup(
                                     p3PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, p3PanelLayout.createSequentialGroup()
                                                     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                     .addComponent(p3Name, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                     .addGap(71, 71, 71))
                                        .addGroup(p3PanelLayout.createSequentialGroup()
                                                     .addContainerGap()
                                                     .addGroup(p3PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                  .addComponent(p3Avatar)
                                                                  .addComponent(p3Country, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                                                     .addContainerGap())
                                    );
      
      p4Panel.setBackground(new java.awt.Color(153, 153, 255));
      
      p4Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p4Name.setForeground(new java.awt.Color(102, 0, 153));
      p4Name.setText("Enter Nickname");
      
      p4Country.setBackground(new java.awt.Color(204, 204, 255));
      p4Country.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p4Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList4.setModel(new AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p4Country.setViewportView(countryList4);
      
      p4Avatar.setBackground(new java.awt.Color(204, 204, 255));
      p4Avatar.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList4.setModel(new AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p4Avatar.setViewportView(avatarList4);
      avatarList4.setVisibleRowCount( 3 );
      avatarList4.setLayoutOrientation( JList.HORIZONTAL_WRAP );
      
      GroupLayout p4PanelLayout = new GroupLayout(p4Panel);
      p4Panel.setLayout(p4PanelLayout);
      p4PanelLayout.setHorizontalGroup(
                                       p4PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addGroup(p4PanelLayout.createSequentialGroup()
                                                       .addContainerGap()
                                                       .addComponent(p4Name, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                       .addComponent(p4Country, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                       .addGap(18, 18, 18)
                                                       .addComponent(p4Avatar, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
                                                       .addContainerGap())
                                      );
      p4PanelLayout.setVerticalGroup(
                                     p4PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(p4PanelLayout.createSequentialGroup()
                                                     .addGap(72, 72, 72)
                                                     .addComponent(p4Name, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, p4PanelLayout.createSequentialGroup()
                                                     .addContainerGap()
                                                     .addGroup(p4PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                  .addComponent(p4Avatar)
                                                                  .addComponent(p4Country, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                                     .addContainerGap())
                                    );
      
      oneCheck.setBackground(new java.awt.Color(0, 204, 51));
      oneCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      oneCheck.setText("P1");
      oneCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            oneCheckActionPerformed(evt);
         }
      });
      
      twoCheck.setBackground(new java.awt.Color(255, 255, 51));
      twoCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      twoCheck.setText("P2");
      twoCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            twoCheckActionPerformed(evt);
         }
      });
      
      threeCheck.setBackground(new java.awt.Color(255, 51, 0));
      threeCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      threeCheck.setText("P3");
      threeCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            threeCheckActionPerformed(evt);
         }
      });
      
      fourCheck.setBackground(new java.awt.Color(102, 102, 255));
      fourCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      fourCheck.setText("P4");
      fourCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            fourCheckActionPerformed(evt);
         }
      });
      
      back.setBackground(new java.awt.Color(255, 255, 255));
      back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      back.setForeground(new java.awt.Color(204, 0, 0));
      back.setText("Back");
      back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      back.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      back.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            backActionPerformed(evt);
         }
      });
      
      start.setBackground(new java.awt.Color(255, 255, 255));
      start.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      start.setForeground(new java.awt.Color(0, 153, 102));
      start.setText("Start");
      start.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      start.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      start.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            startActionPerformed(evt);
         }
      });
      
      GroupLayout layout = new GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                             .addComponent(threeCheck)
                                                             .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                          .addGroup(layout.createSequentialGroup()
                                                                                       .addComponent(back, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                                                                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                       .addComponent(start, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
                                                                          .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(twoCheck)
                                                                                                    .addComponent(fourCheck)
                                                                                                    .addComponent(oneCheck))
                                                                                       .addGap(198, 198, 198)
                                                                                       .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(p4Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(p2Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(p1Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(p3Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                                .addContainerGap(837, Short.MAX_VALUE))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                           .addGroup(layout.createSequentialGroup()
                                                                        .addGap(70, 70, 70)
                                                                        .addComponent(p1Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                           .addGroup(layout.createSequentialGroup()
                                                                        .addGap(27, 27, 27)
                                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(81, 81, 81)
                                                                        .addComponent(oneCheck)))
                                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                           .addGroup(layout.createSequentialGroup()
                                                                        .addGap(90, 90, 90)
                                                                        .addComponent(twoCheck)
                                                                        .addGap(169, 169, 169)
                                                                        .addComponent(threeCheck)
                                                                        .addGap(162, 162, 162)
                                                                        .addComponent(fourCheck))
                                                           .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(p2Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(13, 13, 13)
                                                                        .addComponent(p3Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(11, 11, 11)
                                                                        .addComponent(p4Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                           .addComponent(start, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(back, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                              .addGap(27, 27, 27))
                             );
   }// </editor-fold>    
   
   public void toggle( JRadioButton r, JPanel p ) {
      if( r.isSelected() == true ) {
         p.setVisible(true);
      }
      else
         p.setVisible(false);
   }
   
   private void oneCheckActionPerformed(java.awt.event.ActionEvent evt) {                                         
      // TODO add your handling code here:
      toggle( oneCheck, p1Panel );
      numberOfPlayers = 1;
   }                                        
   
   private void twoCheckActionPerformed(java.awt.event.ActionEvent evt) {                                         
      // TODO add your handling code here:
      toggle( twoCheck, p2Panel );
      if( oneCheck.isSelected() == false ) {
         p2Panel.setVisible(false);
      }
      
      if( p2Panel.isVisible() ) {
         numberOfPlayers = 2;
      }
      else
         numberOfPlayers = 1;
   }                                        
   
   private void threeCheckActionPerformed(java.awt.event.ActionEvent evt) {                                           
      // TODO add your handling code here:
      toggle( threeCheck, p3Panel );
      if( twoCheck.isSelected() == false ) {
         p3Panel.setVisible(false);
      }
      
      if( p3Panel.isVisible() ) {
         numberOfPlayers = 3;
      }
      else
         numberOfPlayers = 2;
   }                                          
   
   private void fourCheckActionPerformed(java.awt.event.ActionEvent evt) {                                          
      // TODO add your handling code here:
      toggle( fourCheck, p4Panel );
      if( threeCheck.isSelected() == false ) {
         p4Panel.setVisible(false);
      }
      
      if( p4Panel.isVisible() ) {
         numberOfPlayers = 4;
      }
      else
         numberOfPlayers = 3;
   }                                         
   
   private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
      // TODO add your handling code here:
      setVisible( false );
      app.mainMenu.setVisible( true );
      
   }
   
   private void startActionPerformed(java.awt.event.ActionEvent evt) {                                      
      // TODO add your handling code here:
      String[] namesOfPlayers;
      int[] locationsOfPlayers;
      Avatar[] avatarsOfPlayers;
      String country;
      
      namesOfPlayers = new String[ numberOfPlayers ];
      locationsOfPlayers = new int[ numberOfPlayers ];
      avatarsOfPlayers = new Avatar[ numberOfPlayers ];
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         namesOfPlayers[ n ] = getPlayerName( n );
         locationsOfPlayers[ n ] = getSelectedCountry( n );
         avatarsOfPlayers[ n ] = getSelectedAvatar( n );
      }
      
      app.gameGui = new GameGUI( app, new Game( numberOfPlayers, locationsOfPlayers, namesOfPlayers, avatarsOfPlayers ) ); 
      app.add( app.gameGui );
      setVisible( false );
   }                                     
   
   public String getPlayerName( int playerNo ) {
      if( playerNo == 0 ) {
         return p1Name.getText();
      }
      
      else if( playerNo == 1 ) {
         return p2Name.getText();
      }
      
      else if( playerNo == 2 ) {
         return p3Name.getText();
      }
      
      else
         return p4Name.getText();
   }
   
   public int getSelectedCountry( int playerNo ) {
      if( playerNo == 0 ) {
         return listedCountries.indexOf( countryList1.getSelectedValue().toString() );
      }
      
      else if( playerNo == 1 ) {
         return listedCountries.indexOf( countryList2.getSelectedValue().toString() );
      }
      
      else if( playerNo == 2 ) {
         return listedCountries.indexOf( countryList3.getSelectedValue().toString() );
      }
      
      else
         return listedCountries.indexOf( countryList4.getSelectedValue().toString() );
   }
   
   public Avatar getSelectedAvatar( int playerNo )
   {
      if( playerNo == 0 ) {
         return (Avatar)avatarList1.getSelectedValue();
      }
      
      else if( playerNo == 1 ) {
         return (Avatar)avatarList2.getSelectedValue();
      }
      
      else if( playerNo == 2 ) {
         return (Avatar)avatarList3.getSelectedValue();
      }
      
      else
         return (Avatar)avatarList4.getSelectedValue();
   }              
}
