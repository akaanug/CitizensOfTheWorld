package mainCode;

import java.util.Observable;
import mainCode.pictureClasses.*;
import java.io.Serializable;

/** 
 * creating player object for game
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class Player extends Observable implements Comparable, Serializable
{
   // properties
   public static final int STARTING_MONEY = 1000;
   int money;
   Countries countries; // vatandaþý olduðumuz ülkeler
   int numberOfCountries; // bu da onlarýn sayýsý
   String name;
   Country currentCountry;
   int playerNo;
   int revenue;
   boolean isPlaying;
   boolean hasTurn;
   Avatar avatar;
   
   // constructors
   public Player()
   {
      countries = new Countries( Route.COUNTRY_NUMBER );
      numberOfCountries = 0;
      money = STARTING_MONEY;
      name = "";
      playerNo = 0;
      revenue = 0;
      isPlaying = true;
   }
   
   public Player( String name, int location, Avatar avatar, int playerNo )
   {
      countries = new Countries( Route.COUNTRY_NUMBER );
      numberOfCountries = 0;
      money = STARTING_MONEY;
      this.name = name;
      this.currentCountry = Route.getCountry( location );
      this.avatar = avatar;
      this.playerNo = playerNo;
      revenue = 0;
      isPlaying = true;
   }
   
   // methods
   
   /*
    * get player no
    * @return the player no
    */
   public int getPlayerNo()
   {
      return playerNo;
   }
   
   /*
    * get name of player
    * @return the name of player
    */
   public String getName()
   {
      return name;
   }
   
   /*
    * get number of countries player has citizenship
    * @return number of countries player has citizenship
    */
   public int getNumberOfCountries()
   {
      return numberOfCountries;
   }
   
   /*
    * return current country of player
    * @return current country of player
    */
   public Country getCurrentCountry()
   {
      return currentCountry;
   }
   
   /*
    * return the current money of player
    * @return the current money of player
    */
   public int getMoney()
   {
      return money;
   }
   
   /*
    * return the revenue of player
    * @return the revenue of player
    */
   public int getRevenue()
   {
      return revenue;
   }
   
   //return the avatar character of player
   public Avatar getAvatar()
   {
      return avatar;
   }
   
   //return the country list player has citizenship
   public Countries getCountries()
   {
      return countries;
   }
   
   //return the last country player has citizenship
   public Country getLastCountry()
   {
      return countries.get( countries.getNumberOfCountries() - 1 );
   }
   
   //whether player is currently playing or not
   public boolean isPlaying()
   {
      return isPlaying;
   }
   
   //whether player has a money or not
   public boolean hasMoney()
   {
      return money > 0;
   }
   
   //whether player has a turn to play
   public boolean hasTurn()
   {
      return hasTurn;
   }
   
   //updating the playing situation of player currently
   protected void setHasTurn( boolean tf )
   {
      hasTurn = tf;
      
      notifier( "next turn" );
   }
   
   //setting playerNo with given value
   protected void setPlayerNo( int playerNo )
   {
      this.playerNo = playerNo;
   }
   
   //leave game operations for player
   protected void leaveGame()
   {
      isPlaying = false;
      setHasTurn( false );
   }
   
   protected boolean equals( Player p )
   {
      return this.getPlayerNo() == p.getPlayerNo();
   }
   
   // throwing dices for turn of player and return sum of the dices
   protected int rollDice( Dice dice )
   {
      return dice.rollDice();
   }
   
   // paying accomodatin fee for player considering the country player enter
   protected void payAccomodationFee( Country c )
   {
      money = money - c.getAccomodationFee();
      
      notifier( "money changed" );
   }
   
   // adding new country to citizenships of player
   protected void addCitizenship( Country c )
   {
      countries.add( c );
      numberOfCountries++;
      
      revenue = revenue + c.getTax();
      
      notifier( "money changed" );
   }
   
   // add revenue for the player's money
   protected void addRevenue()
   {
      money = money + revenue;      
      notifier( "money changed" );
   }
   
   // paying fee for questions
   protected void payQuestionFee()
   {
      money = money - Question.QUESTION_FEE;      
      notifier( "money changed" );
   }
   
   // paying travel fee for player in the turn
   protected void payTravelFee( )
   {
      money = money - Route.TRAVEL_CHARGE;
      notifier( "money changed" );
   }
   
   // setting the location of player
   protected void setLocation( Country c )
   {
      currentCountry = c;      
      notifier( "country changed" );
   }
   
   // comparing the citizenships of player with given object
   // if there is equality comparison with money of player and given object 
   public int compareTo( Object o )
   {
      Player p = (Player)o;
      
      if ( this.numberOfCountries > p.numberOfCountries )
      {
         return 1;
      }
      else if ( this.numberOfCountries < p.numberOfCountries )
      {
         return -1;
      }
      else
      {
         if ( this.money > p.money )
         {
            return 1;
         }
         else if ( this.money < p.money )
         {
            return -1;
         }
         else 
         {
            return 0;
         }
      }
   }
   
   // Notifiers
   protected void notifier()
   {
      setChanged();
      notifyObservers();
   }
   
   protected void notifier( String s )
   {
      setChanged();
      notifyObservers( s );
   }
}   