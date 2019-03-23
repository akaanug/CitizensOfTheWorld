package mainCode;

import java.util.Scanner;

// buraya bi comment atıver
public class Player
{
   Scanner scan = new Scanner( System.in);
   
   // properties
   public static final int STARTING_MONEY = 1000;
   public static final int TRAVEL_CHARGE = 5;
   int money;
   Countries countries; // vatandaşı olduğumuz ülkeler
   int numberOfCountries; // bu da onların sayısı
   String name;
   int location;
   int playerNo;
   int revenue;
   
   // constructors
   
   // bu guide biyerde lazım onun içün yazıyorum.
   public Player()
   {
      countries = new Countries();
      numberOfCountries = 0;
      money = STARTING_MONEY;
      name = "";
      location = 0;
      playerNo = 0;
      revenue = 0;
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
   }
   
   // methods ( javadocları yazınız lütfen )
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
   
   // zar sallama olayı, locationunu değiştiriyosun ( burda geçen yazdığımız dice şeysini kullanabilirsin )
   public void rollDice()
   {
      int dice1;
      int dice2;
      
      dice1 = (int)( Math.random() * 6 ) + 1;
      dice2 = (int)( Math.random() * 6 ) + 1;     
      money = money - ( dice1 + dice2 ) * TRAVEL_CHARGE;
      location = ( location + dice1 + dice2 ) % 60;
   }
   
   public void payAccomodationFee( Country c )
   {
      money = money - c.getAccomodationFee();
   }
   
   // burda player eğer vatandaşsa tüm soruları cevaplarıyla birlikte görebiliyor. Onu string olarak atıcaksın. Countrieste metodu var zaten onun kolay iş.
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
   
   // bu da eğer ülkenin ilk vatandaşıysa başka bir oyuncu için 3 tane soru seçiyor. Tabi seçmesi için önce tüm soruları cevaplarıyla görmesi lazım. 
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
   
   // citizenship kazanırsa citizen arrayine ekle
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
