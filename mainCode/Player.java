package mainCode;

import java.util.Observable;
import mainCode.pictures.*;

// buraya bi comment at�ver
public class Player extends Observable
{
   // properties
   public static final int STARTING_MONEY = 1000;
   public static final int TRAVEL_CHARGE = 5;
   int money;
   Countries countries; // vatanda�� oldu�umuz �lkeler
   int numberOfCountries; // bu da onlar�n say�s�
   String name;
   int location;
   int playerNo;
   int revenue;
   boolean isPlaying;
   Avatar avatar;
   
   // constructors
   
   // bu guide biyerde laz�m onun i��n yaz�yorum.
   public Player()
   {
      countries = new Countries();
      numberOfCountries = 0;
      money = STARTING_MONEY;
      name = "";
      location = 0;
      playerNo = 0;
      revenue = 0;
      isPlaying = true;
   }
   
   public Player( String name, int location, Avatar avatar, int playerNo )
   {
      countries = new Countries();
      numberOfCountries = 0;
      money = STARTING_MONEY;
      this.name = name;
      this.location = location;
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
   
   public int getLocation()
   {
      return location;
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
      return countries.get( countries.size() - 1 );
   }
   
   public boolean isPlaying()
   {
      return isPlaying;
   }
   
   public void notifier()
   {
      setChanged();
      notifyObservers();
   }
   
   public void leaveGame()
   {
      isPlaying = false;
      
      notifier();
   }
   
   public boolean equals( Player p )
   {
      return this.getPlayerNo() == p.getPlayerNo();
   }
   
   // zar sallama olay�, locationunu de�i�tiriyosun ( burda ge�en yazd���m�z dice �eysini kullanabilirsin )
   public void rollDice()
   {
      int dice1;
      int dice2;
      
      dice1 = (int)( Math.random() * 6 ) + 1;
      dice2 = (int)( Math.random() * 6 ) + 1;     
      money = money - ( dice1 + dice2 ) * TRAVEL_CHARGE;
      location = ( location + dice1 + dice2 ) % 60;
      
      notifier();
   }
   
   public void payAccomodationFee( Country c )
   {
      money = money - c.getAccomodationFee();
      
      notifier();
   }
   
   // citizenship kazan�rsa citizen arrayine ekle
   public void addCitizenship( Country c )
   {
      countries.add( c );
      numberOfCountries++;
      
      revenue = revenue + c.getTax();
      
      notifier();
   }
   
   public void addRevenue()
   {
      money = money + revenue;
      
      notifier();
   }
   
   public void payQuestionFee()
   {
      money = money - Question.QUESTION_FEE;
      
      notifier();
   }
   
   public int compareTo( Player p )
   {
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
}
   
   
   