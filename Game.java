import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Game
{   
   Scanner scan = new Scanner( System.in);
         
   // properties
   final int NUMBER_OF_QUESTIONS = 10;
   final int NUMBER_OF_COUNTRIES = 60;
   final int NUMBER_OF_CHOICES = 3;
   final int NUMBER_OF_QUIZ_QUESTIONS = 3;
   int numberOfPlayers;
   Countries countries;
   Player[] players;
   int roundNo;
   int turnOfPlayer;
   
   // constructors
   public Game( String fileName, int numberOfPlayers, int[] locationsOfPlayers, String[] namesOfPlayers ) throws IOException
   { 
       fileInfo( fileName );
       
       this.numberOfPlayers = numberOfPlayers;
       roundNo = 0;
       turnOfPlayer = 0;
       
       players = new Player[ numberOfPlayers ];
       for ( int n = 0; n < numberOfPlayers; n++ )
       {
          players[ n ] = new Player( namesOfPlayers[ n ], locationsOfPlayers[ n ], n );
       }
   }    
   
   public Game( Player[] players ) 
   { 
       fileInfo2( );
       
       this.numberOfPlayers = players.length;
       roundNo = 0;
       turnOfPlayer = 0;       
       this.players = players;
   }
   
   public Game( String fileName, Player[] players ) throws IOException
   { 
       fileInfo( fileName );
       
       this.numberOfPlayers = players.length;
       roundNo = 0;
       turnOfPlayer = 0;       
       this.players = players;
   }
   // methods
   public boolean playTurn( Player p )
   {
      Country c;
      boolean getQuestion;
      char yn;
      boolean getCitizenship;
      
      if ( isTurnOf( p ) )
      {
         System.out.println( p.getName() + ", it is your turn." );
         p.rollDice();
         System.out.println( "Your current money: " + p.getMoney() );
         c = countries.getCountry( p.getLocation() );
         System.out.println( "Welcome to " + c.getName() );
         
         if ( c.isACitizen( p ) )
         {
            System.out.println( "You are already a citizen of the country." );
         }
         else 
         {
            System.out.println( "Do you want to try citizenship? ( y for yes ) " );
            yn = scan.next().charAt( 0 );
            
            if ( yn == 'y' )
            {
               getCitizenship = doTheQuiz( p, c );
               
               if ( getCitizenship )
               {
                  System.out.println( "Congratulations, you are a citizen of this country." );
                  p.addCitizenship( c );
                  c.addToCitizenship( p );
               }
               else 
               {
                  System.out.println( "Sorry but you have no knowledge to become a citizen." );
               }
            }
            else
            {
               System.out.println( "Then you are paying the accomodation fee." );
               p.payAccomodationFee( c );
            }
         }
         
         p.addRevenue();
         turnOfPlayer = ( turnOfPlayer + 1 ) % numberOfPlayers;
         System.out.println();
         System.out.println( "Your current money is: " + p.getMoney() );
         
         return true;
      }
      else 
      {
         System.out.println( "It is not your turn. \n" );
         return false;
      }  
   }
   
   public boolean isTurnOf( Player p)
   {
      return p.getPlayerNo() == turnOfPlayer;
   }
   
   public boolean doTheQuiz( Player p, Country c )
   {
      Questions quiz;
      int n;
      boolean isAllAnswersTrue;
      int answer;
      Question question;
      
      quiz = p.getQuiz( c );
      
      n = 0;
      isAllAnswersTrue = true;
      while ( n < NUMBER_OF_QUIZ_QUESTIONS && isAllAnswersTrue == true )
      {
         question = quiz.getQuestion( n );
         System.out.println( question );
         
         answer = scan.nextInt();
         scan.nextLine();
         
         if ( question.isAnswerCorrect( answer ) )
         {
            System.out.println( "Congratulations." );
         }
         else 
         {
            System.out.println( "Wrong answer. The true answer is: " + question.getStringAnswer() );
            isAllAnswersTrue = false;
         }
         
         n++;
      }
      
      return isAllAnswersTrue;
   }
   
   // buna bakmayin bu dosyadan çekme denemem.
   public void fileInfo( String fileName ) throws IOException
   {     
      FileReader fileReader;
      String line;         
      BufferedReader br;
      int infoCount;
      int questionCount;
      int countryCount;
      Questions questions;
      String questionSentence;
      String[] choices;
      int answer;
      
      answer = 0;
      questions = new Questions( NUMBER_OF_QUESTIONS );
      questionSentence = "";
      this.countries = new Countries();
      choices = new String[ 3 ];
      fileReader = new FileReader( fileName );
      br = new BufferedReader( fileReader );
      infoCount = 0;
      questionCount = 0;
      countryCount = 0;
      while ( countryCount < NUMBER_OF_COUNTRIES )
      {
         while ( questionCount < NUMBER_OF_QUESTIONS )
         {
            if ( infoCount == 0 )
            {
               questionSentence = br.readLine();
            }
            else if ( infoCount == 4 )
            {
               answer = Integer.parseInt( br.readLine() );             
            }
            else
            {
               choices[ infoCount - 1 ] = br.readLine();
            }
            infoCount = ( infoCount + 1 ) % 5;
            
            if ( infoCount == 0 )
            {
               questions.add( new Question( questionSentence, choices, answer ) );
               questionCount++;
               
               choices = new String[ 3 ];
            }
         }

         this.countries.add( new Country( br.readLine(), Integer.parseInt( br.readLine() ), Integer.parseInt( br.readLine() ), questions ) );

         countryCount++;
         
         questions = new Questions( NUMBER_OF_QUESTIONS );
         questionCount = 0;
      }
      
      br.close();
   }
   
    public void fileInfo2( ) 
   {              
      int infoCount;
      int questionCount;
      int countryCount;
      Questions questions;
      String questionSentence;
      String[] choices;
      int answer;
      
      answer = 0;
      questions = new Questions( NUMBER_OF_QUESTIONS );
      questionSentence = "";
      this.countries = new Countries();
      choices = new String[ 3 ];
      infoCount = 0;
      questionCount = 0;
      countryCount = 0;
      while ( countryCount < NUMBER_OF_COUNTRIES )
      {
         while ( questionCount < NUMBER_OF_QUESTIONS )
         {
            if ( infoCount == 0 )
            {
               questionSentence = "Dünyanýn en iyi kalecisi kimdir?";
            }
            else if ( infoCount == 4 )
            {
               answer = 1;
            }
            else
            {
               choices[ infoCount - 1 ] = "Kameni";
            }
            infoCount = ( infoCount + 1 ) % 5;
            
            if ( infoCount == 0 )
            {
               questions.add( new Question( questionSentence, choices, answer ) );
               questionCount++;
            }
         }
         
         this.countries.add( new Country( "Fransa", 100, 10, questions ) );
         countryCount++;
         
         questions = new Questions( NUMBER_OF_QUESTIONS );
         questionCount = 0;
      }     
   }
}