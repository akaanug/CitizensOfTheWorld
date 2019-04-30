package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import mainCode.pictures.*;
import util.*;
import java.util.Observer;
import java.util.Observable;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class CountryInfo extends JPanel implements Observer {

   // private variables
   Game game;
   JLabel countryName;
   JLabel accomodationFee;
   JLabel citizenshipFee;
   JLabel income;
   JLabel citizens;
   JPanel infoPanel;
   JPanel buttonPanel;
   JButton payAccomodationFee;
   JButton getCitizenship;
   ResizablePicture countryPicture;
      
   // Constructor to setup the GUI components
   public CountryInfo( Game game ) 
   {     
      this.game = game;
      
      // Add Observer
      for ( int n = 0; n < Route.COUNTRY_NUMBER; n++ )
      {
         Route.COUNTRIES_ON_ROUTE.get( n ).addObserver( this );
      }
      
      createComponents();
      handleActionListeners();
      
      setVisible( false );
      
   }
   
   // Listener Classes 
   
   // Pay Accomodation Fee Button Listener 
   public class PayAccomodationFeeBtnListener implements ActionListener
   { 
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         game.payAccomodationFee();  
         
         setVisible( false );
      }
   }
   
   // Get Citizenship Button Listener 
   public class GetCitizenshipBtnListener implements ActionListener
   { 
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         game.getCitizenship();
         
         setVisible( false );
      }
   }

   // Methods 
   public void createComponents()
   {
      setLayout( new BorderLayout() );
            
      // Country Picture
      countryPicture = new CountryPicture();
      add( countryPicture, BorderLayout.NORTH );
      
      // Information of Country
      infoPanel = new JPanel();
      infoPanel.setLayout( new BoxLayout( infoPanel, BoxLayout.Y_AXIS ) );
      
      countryName = new JLabel();
      accomodationFee = new JLabel();
      citizenshipFee = new JLabel();
      income = new JLabel();
      citizens = new JLabel( "Citizens: " );
      
      infoPanel.add( countryName );
      infoPanel.add( accomodationFee );
      infoPanel.add( citizenshipFee );
      infoPanel.add( income );
      
      add( infoPanel, BorderLayout.CENTER );
      
      // Buttons
      buttonPanel = new JPanel();
      buttonPanel.setLayout( new FlowLayout() );
      
         // Pay Accomodation Fee Button
      payAccomodationFee = new JButton( "Pay Accomodation Fee" );
      buttonPanel.add( payAccomodationFee );
         
         // Get Citizenship Button
      getCitizenship = new JButton( "Get Citizenship" );
      buttonPanel.add( getCitizenship );
      
      add( buttonPanel, BorderLayout.SOUTH );
   }
   
   public void handleActionListeners()
   {
      payAccomodationFee.addActionListener( new PayAccomodationFeeBtnListener() );
      getCitizenship.addActionListener( new GetCitizenshipBtnListener() );
   }
   
   public void update( Observable obs, Object obj )
   {
      Country c = (Country)obs;

      countryName.setText( c.getName() );
      accomodationFee.setText( "Accomodation Fee: " + c.getAccomodationFee()  );
      citizenshipFee.setText( "Citizenship Fee: " + 30 );
      income.setText( "Income: " + c.getTax() );
      countryPicture.setPicture( c.getPicture() );
      
//      if ( countries.size() < p.getNumberOfCountries() )
//      {
//         createCountryPanel( p.getLastCountry() );
//      }
      
      setVisible( true );
   }   
}