package mainCode;

import java.util.Observable;

// buraya bi comment atýver
public class Player extends Observable
{
   // properties
   public static final int STARTING_MONEY = 1000;
   public static final int TRAVEL_CHARGE = 5;
   int money;
   Countries countries; // vatandaþý olduðumuz ülkeler
   int numberOfCountries; // bu da onlarýn sayýsý
   String name;
   int location;
   int playerNo;
   int revenue;
   boolean isPlaying;
   
   // constructors
   
   // bu guide biyerde lazým onun içün yazýyorum.
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
   
   public Player( String name, int location, int playerNo )
   {
      countries = new Countries();
      numberOfCountries = 0;
      money = STARTING_MONEY;
      this.name = name;
      this.location = location;
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
   
   // zar sallama olayý, locationunu deðiþtiriyosun ( burda geçen yazdýðýmýz dice þeysini kullanabilirsin )
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
   
   // citizenship kazanýrsa citizen arrayine ekle
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
   
   
   