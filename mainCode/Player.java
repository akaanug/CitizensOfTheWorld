package mainCode;

import java.util.Observable;
import mainCode.pictures.*;

// buraya bi comment at�ver
public class Player extends Observable implements Comparable
{
   // properties
   public static final int STARTING_MONEY = 1000;
   int money;
   Countries countries; // vatanda�� oldu�umuz �lkeler
   int numberOfCountries; // bu da onlar�n say�s�
   String name;
   Country currentCountry;
   int playerNo;
   int revenue;
   boolean isPlaying;
   boolean hasTurn;
   Avatar avatar;
   
   // constructors
   
   // bu guide biyerde laz�m onun i��n yaz�yorum.
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
   
   // methods ( javadoclar� yaz�n�z l�tfen )
   public int getPlayerNo()
   {
      return playerNo;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getNumberOfCountries()
   {
      return numberOfCountries;
   }
   
   public Country getCurrentCountry()
   {
      return currentCountry;
   }
   
   public int getMoney()
   {
      return money;
   }
   
   public int getRevenue()
   {
      return revenue;
   }
   
   public Avatar getAvatar()
   {
      return avatar;
   }
   
   public Countries getCountries()
   {
      return countries;
   }
   
   public Country getLastCountry()
   {
      return countries.get( countries.getNumberOfCountries() - 1 );
   }
   
   public boolean isPlaying()
   {
      return isPlaying;
   }
   
   public boolean hasTurn()
   {
      return hasTurn;
   }
   
   protected void setHasTurn( boolean tf )
   {
      hasTurn = tf;
      
      notifier();
   }
   
   protected void setPlayerNo( int playerNo )
   {
      this.playerNo = playerNo;
   }
   
   protected void leaveGame()
   {
      isPlaying = false;
      
      notifier();
   }
   
   protected boolean equals( Player p )
   {
      return this.getPlayerNo() == p.getPlayerNo();
   }
   
   // zar sallama olay�, locationunu de�i�tiriyosun ( burda ge�en yazd���m�z dice �eysini kullanabilirsin )
   protected int rollDice()
   {
      int dice1;
      int dice2;
      
      dice1 = (int)( Math.random() * 6 ) + 1;
      dice2 = (int)( Math.random() * 6 ) + 1;     
      
      return dice1 + dice2;
   }
   
   protected void payAccomodationFee( Country c )
   {
      money = money - c.getAccomodationFee();
      
      notifier();
   }
   
   // citizenship kazan�rsa citizen arrayine ekle
   protected void addCitizenship( Country c )
   {
      countries.add( c );
      numberOfCountries++;
      
      revenue = revenue + c.getTax();
      
      notifier();
   }
   
   protected void addRevenue()
   {
      money = money + revenue;      
      notifier();
   }
   
   protected void payQuestionFee()
   {
      money = money - Question.QUESTION_FEE;      
      notifier();
   }
   
   protected void payTravelFee( int locationChange )
   {
      money = money - locationChange * Route.TRAVEL_CHARGE;
      notifier();
   }
   
   protected void setLocation( Country c )
   {
      currentCountry = c;      
      notifier();
   }
   
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