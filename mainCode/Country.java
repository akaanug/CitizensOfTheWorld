package mainCode;

import java.util.Observable;
import mainCode.pictureClasses.*;
import java.awt.Point;
import java.io.Serializable;

/** 
 * creating country object and its questions
 * @author Batuhan Gelgi
 * @version 12.05.2019
 */
public class Country extends Observable implements Serializable
{
   // properties
   public static final int QUESTION_NUMBER = 10;
   int tax;
   int accomodationFee;
   String name;
   Questions questions;
   Player[] citizens;
   int numberOfCitizens;
   CountryFlag flag;
   CountryPicture picture;
   Point location;
   int locationOnRoute;
   
   // constructors 
   public Country( String name, int accomodationFee, int tax, Questions questions, int locX, int locY, int locationOnRoute ) 
   {
      this.accomodationFee = accomodationFee;
      this.name = name;
      this.questions = questions;
      citizens = new Player[ Game.MAX_PLAYER_NUMBER ];
      numberOfCitizens = 0;
      this.tax = tax;     
      flag = new CountryFlag( name );
      picture = new CountryPicture( name );
      location = new Point( locX, locY );
      this.locationOnRoute = locationOnRoute;
   }
   
   // methods 
   
   /*
    * return accomodation fee of country
    * @return accomodation fee of this country
    */
   public int getAccomodationFee()
   {
      return accomodationFee;
   }
   
   /*
    * return the name of country
    * @return the name of country
    */
   public String getName()
   {
      return name;
   }
   
   /*
    * return the tax of country
    * @return the tax of country
    */
   public int getTax()
   {
      return tax;
   }
   
   /*
    * return the players having citizenship from this country
    * @return the player list having citizenship
    */
   public Player[] getCitizens()
   {
      return citizens;
   }
   
   /*
    * return the player with given citizenNo
    * @param citizenNo
    * @return the player with citizenNo
    */
   public Player getCitizen( int citizenNo )
   {
      return citizens[ citizenNo ];
   }
   
   /*
    * return the number of citizens of country
    * @return the number of citizens of country
    */
   public int getNumberOfCitizens()
   {
      return numberOfCitizens;
   }
   
   /*
    * return the questions about country
    * @return the questions of country
    */
   public Questions getQuestions()
   {
      return questions;
   }
   
   /*
    * accessing the flag of country
    * @return the flag of country
    */
   public CountryFlag getFlag()
   {
      return flag;
   }
   
   /*
    * accessing the picture of country
    * @return the picture of country
    */
   public CountryPicture getPicture()
   {
      return picture;
   }
   
   /*
    * accesing the location of country
    * @return the location of country
    */
   public Point getLocation()
   {
      return location;
   }
   
   /*
    * accesing the location of country on gameroute
    * @return  the location of country on gameroute
    */
   public int getLocationOnRoute()
   {
      return locationOnRoute;
   }
   
   public void setLocation( int x, int y )
   {
      location = new Point( x, y );
   }
   
   /*
    * select three question among ten question of country randomly and return 
    * @return the selected three questions of country
    */
   protected Questions determineThreeRandomQuestions()
   {
      Questions randomQuestions;
      Questions questionsTemplate;
      int location;
      
      questionsTemplate = new Questions( this.questions );
      randomQuestions = new Questions( 3 );
      
      for ( int n = 0; n < 3; n++ )
      {
         location = (int)( Math.random() * ( 10 - n ) );
         randomQuestions.putToIndex( questionsTemplate.get( location ), n );
         questionsTemplate.putToIndex( questionsTemplate.get( 9 - n ), location );
      }
      
      return randomQuestions;
   }
   
   // adding new player as a citizenship of country
   protected void addToCitizenship( Player p )
   {
      citizens[ numberOfCitizens ] = p;
      numberOfCitizens++;
   }
   
   /*
    * return whether given player is citizenship or not
    * @param Player p
    * @return whether given player is citizenship or not
    */
   public boolean isACitizen( Player p )
   {
      boolean isACitizen;
      int n;
      
      isACitizen = false;
      for( n = 0; n < numberOfCitizens; n++ )
      {
         if ( p.equals( citizens[ n ] ) )
         {
            isACitizen = true;
         }
      }
      
      return isACitizen;
   }
   
   /*
    * return whether given player is first citizenship or not
    * @param Player p
    * @return whether given player is first citizenship or not
    */
   public boolean isTheFirstCitizen( Player p )
   {
      return p.equals( citizens[ 0 ] );
   }
   
   /*
    * return whether country has a citizen or not
    * @return whether country has a citizen or not
    */
   public boolean hasACitizen()
   {
      return numberOfCitizens > 0;
   }
   
   // setting changes and notifying observers
   public void notifier( String s )
   {
      setChanged();
      notifyObservers( s );
   }
}
   
      
      
