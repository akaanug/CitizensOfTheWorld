import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class CountryInfo extends JPanel {

   // private variables
   GameGUI parent;
   JLabel countryName;
   JLabel accomodationFee;
   JLabel citizenshipFee;
   JLabel income;
   JLabel citizens;
   JPanel infoPanel;
   JPanel buttonPanel;
   JButton payAccomodationFee;
   JButton getCitizenship;
   Player p; // We will have only one country info panel in gamegui, and we need this for accomodation fee payment, so we need to keep this.
   Country c;
   
   // Constructor to setup the GUI components
   public CountryInfo( Country c, Player p, GameGUI parent ) 
   {
      setLayout( new BorderLayout() );
      
      this.parent = parent;
      this.p = p; 
      this.c = c;
      
      // Information of Country
      infoPanel = new JPanel();
      infoPanel.setLayout( new BoxLayout( infoPanel, BoxLayout.Y_AXIS ) );
      
      countryName = new JLabel( c.getName() );
      accomodationFee = new JLabel( "Accomodation Fee: " + c.getAccomodationFee()  );
      citizenshipFee = new JLabel( "Citizenship Fee: 30" );
      income = new JLabel( "Income: " + c.getTax() );
      
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
      payAccomodationFee.addActionListener( new PayAccomodationFeeBtnListener() );
         
         // Get Citizenship Button
      getCitizenship = new JButton( "Get Citizenship" );
      buttonPanel.add( getCitizenship );
      getCitizenship.addActionListener( new GetCitizenshipBtnListener() ); 
      
      add( buttonPanel, BorderLayout.SOUTH );
      
      setVisible( false );
      
   }
   
   // Listener Classes 
   
   // Pay Accomodation Fee Button Listener 
   public class PayAccomodationFeeBtnListener implements ActionListener
   { 
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         p.payAccomodationFee( c );  
         parent.northPanelRefresher();
         
         setVisible( false );
         parent.accomodationFeePage.refresh( c.getAccomodationFee() ); 
      }
   }
   
   // Get Citizenship Button Listener 
   public class GetCitizenshipBtnListener implements ActionListener
   { 
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         p.payQuestionFee();
         parent.northPanelMoneyRefresher();
         
         parent.questionPage.totallyNewQuestions( p, c );
         
         setVisible( false );
         parent.questionPage.setVisible( true );  
      }
   }

   // Methods   
   public void setCountryName( String countryName )
   {
      this.countryName.setText( countryName );
   }
   
   public void setAccomodationFee( int accomodationFee )
   {
      this.accomodationFee.setText( "Accomodation Fee: " + accomodationFee  );
   }
   
   public void setCitizenshipFee( int citizenshipFee )
   {
      this.citizenshipFee.setText( "Citizenship Fee: " + citizenshipFee  );
   }
   
   public void setIncome( int income )
   {
      this.income.setText( "Income: " + income );
   }
   
   public void uploadNewCountry( Country c, Player p )
   {
      this.c = c;
      this.p = p;

      setCountryName( c.getName() );
      setAccomodationFee( c.getAccomodationFee() );
      setCitizenshipFee( 30 );
      setIncome( c.getTax() );

      setVisible( true );
   }   
}