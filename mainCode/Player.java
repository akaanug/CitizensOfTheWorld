package mainCode;

import java.util.Observable;
import mainCode.pictures.*;

// buraya bi comment atýver
public class Player extends Observable implements Comparable
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
   
   // bu guide biyerde lazým onun içün yazýyorum.
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
   
   // methods ( javadoclarý yazýnýz lütfen )
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
   
   // zar sallama olayý, locationunu deðiþtiriyosun ( burda geçen yazdýðýmýz dice þeysini kullanabilirsin )
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
   
   // citizenship kazanýrsa citizen arrayine ekle
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