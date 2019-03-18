import java.util.Scanner;

// buraya bi comment atýver
public class Player
{
   Scanner scan = new Scanner( System.in);
   
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
   
   // constructors
   public Player( String name, int location, int playerNo )
   {
      countries = new Countries();
      numberOfCountries = 0;
      money = STARTING_MONEY;
      this.name = name;
      this.location = location;
      this.playerNo = playerNo;
      revenue = 0;
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
   
   public String getCountries()
   {
      String s;
      int n;
      
      s = "The countries that " + name + " is a citizenship: \n";
      for ( n = 0; n < numberOfCountries; n++ )
      {
         s = s + countries.getCountry( n ).getName() + "\n";
      }
      
      return s;
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
      
      System.out.println( "You went " + ( dice1 + dice2 ) + " way and your current position is " + location );
   }
   
   public void payAccomodationFee( Country country )
   {
      money = money - country.getAccomodationFee();
   }
   
   // burda player eðer vatandaþsa tüm sorularý cevaplarýyla birlikte görebiliyor. Onu string olarak atýcaksýn. Countrieste metodu var zaten onun kolay iþ.
   public String getAllQuestions( Country country )
   {
      if ( country.isACitizen( this ) )
      {
         return country.getQuestions().toString();
      }
      else
      {
         return "You are not a citizen of this country.";
      }
   }
   
   // bu da eðer ülkenin ilk vatandaþýysa baþka bir oyuncu için 3 tane soru seçiyor. Tabi seçmesi için önce tüm sorularý cevaplarýyla görmesi lazým. 
   public Questions chooseQuestionsForOtherPlayer( Country country )
   {
      Questions questionsChosen;
      int n;
      System.out.println( getAllQuestions( country ) );
      int questionNo;
      
      System.out.println( country.getQuestions() );
      System.out.println( this.getName() + ", Please choose 3 questions for another player." );
      
      questionsChosen = new Questions( 3 );
      for ( n = 0; n < 3; n++ )
      {
         System.out.println( "Please enter the question number to choose" );
         questionNo = scan.nextInt();
         
         questionsChosen.add( country.getQuestions().getQuestion( questionNo - 1 ) );
      }
      
      return questionsChosen;
   }
   
   public Questions getQuiz( Country c )
   {
      money = money - Question.QUESTION_FEE * 3;
      
      if ( c.hasACitizen() )
      {
         return c.getCitizen( 0 ).chooseQuestionsForOtherPlayer( c );
      }
      else 
      {
         return c.determineThreeRandomQuestions();
      }
   }
   
   // citizenship kazanýrsa citizen arrayine ekle
   public void addCitizenship( Country c )
   {
      countries.add( c );
      numberOfCountries++;
      
      revenue = revenue + c.getTax();
   }
   
   public int giveAnswer()
   {
      int answer;
      
      System.out.println( "Please give your answer to this question: " );
      answer = scan.nextInt();
      
      return answer;
   }
   
   public void addRevenue()
   {
      money = money + revenue;
   }
}
   
   
   