package mainCode;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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
   public Game()
   { 
       fileInfo( "mainCode\\countries.txt" );
       
       numberOfPlayers = 4;
       roundNo = 0;
       turnOfPlayer = 0;
       
       players = new Player[ 4 ];
       for ( int n = 0; n < 4; n++ )
       {
          players[ n ] = new Player( "Player" + ( n + 1 ), 0, n );
       }
   }      
      
   public Game( int numberOfPlayers, int[] locationsOfPlayers, String[] namesOfPlayers ) 
   { 
       fileInfo( "mainCode\\countries.txt" );
       
       this.numberOfPlayers = numberOfPlayers;
       roundNo = 0;
       turnOfPlayer = 0;
       
       players = new Player[ numberOfPlayers ];
       for ( int n = 0; n < numberOfPlayers; n++ )
       {
          players[ n ] = new Player( namesOfPlayers[ n ], locationsOfPlayers[ n ], n );
       }
   }      
   
   public Game( String fileName, Player[] players ) 
   { 
       fileInfo( fileName );
       
       this.numberOfPlayers = players.length;
       roundNo = 0;
       turnOfPlayer = 0;       
       this.players = players;
   }
   
   // methods
   public int getTurnOfPlayer()
   {
      return turnOfPlayer;
   }
   
   public Player getPlayer( int playerNo )
   {
      return players[ playerNo ];
   }
   
   public Player getCurrentPlayer()
   {
      return getPlayer( turnOfPlayer );
   }
   
   public int getNumberOfPlayers()
   {
      return numberOfPlayers;
   }
   
   public int getRoundNo()
   {
      return roundNo;
   }
   
   public Countries getCountries()
   {
      return countries;
   }
   
//   public Player[] getLeadershipTable()
//   {
//      ArrayList<Player> templatePlayers;
//      Player[] leadershipTable;
//      ArrayList<Integer> countryNumbersOfPlayers;
//      int max;
//      int maxLocation;
//      int n;
//      boolean found;
//      int m;
//      
//      templatePlayers = new ArrayList<Player>();
//      countryNumbersOfPlayers = new ArrayList<Integer>();
//      for( n = 0; n < numberOfPlayers; n++ )
//      {
//         countryNumbersOfPlayers.add( players[n].getNumberOfCountries() );
//         templatePlayers.add( players[n] );
//      }
//      Collections.sort( countryNumbersOfPlayers );
//         
//      leadershipTable = new Player[ numberOfPlayers ];
//      for( n = 0; n < numberOfPlayers; n++ )
//      {
//         m = numberOfPlayers - n - 1;
//         found = false;
//         while( !found )
//         {
//            if( countryNumbersOfPlayers.get( n ) == templatePlayers.get( m ).getNumberOfCountries() )
//            {
//               leadershipTable[ numberOfPlayers - n - 1 ] = templatePlayers.get( m );
//               templatePlayers.remove( m );
//               found = true;
//            }
//            
//            m--;
//         }
//      }
//      
//      return leadershipTable;
//   } 
      
   public Player[] getLeadershipTable()
   {
      Player[] leadershipTable;
      Player temp;
      int n;
      int m;
      
      leadershipTable = new Player[ numberOfPlayers ];
      for ( n = 0; n < numberOfPlayers; n++ )
      {
         leadershipTable[ n ] = players[ n ];
      }
      
      for ( n = 0; n < numberOfPlayers; n++ )
      {
         for ( m = 0; m < numberOfPlayers - n - 1; m++ )
         {
            if ( leadershipTable[ m ].compareTo( leadershipTable[ m + 1 ] ) < 0 )
            {
               temp = leadershipTable[ m ];
               leadershipTable[ m ] = leadershipTable[ m + 1 ];
               leadershipTable[ m + 1 ] = temp;
            }
         }
      }
      
      return leadershipTable;
   }
   
   public void addTurnOfPlayer()
   {
      turnOfPlayer = ( turnOfPlayer + 1 ) % numberOfPlayers;
   }
   
   public void rollDice( Player p )
   {
      p.rollDice();
   }
   
   public Country getLocationOfPlayer( Player p )
   {
      return countries.getCountry( p.getLocation() );
   }
   
   public boolean isTurnOf( Player p)
   {
      return p.getPlayerNo() == turnOfPlayer;
   }
   
   public void fileInfo( String fileName ) 
   {     
      try
      {
         FileReader fr;
         String line;         
         CSVReader cr;
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
         fr = new FileReader( fileName );
         cr = new CSVReader( fr );
         infoCount = 0;
         questionCount = 0;
         countryCount = 0;
         while ( countryCount < NUMBER_OF_COUNTRIES )
         {
            while ( questionCount < NUMBER_OF_QUESTIONS )
            {
               if ( infoCount == 0 )
               {
                  questionSentence = cr.next();
               }
               else if ( infoCount == 4 )
               {
                  answer = Integer.parseInt( cr.next() );             
               }
               else
               {
                  choices[ infoCount - 1 ] = cr.next();
               }
               infoCount = ( infoCount + 1 ) % 5;
               
               if ( infoCount == 0 )
               {
                  questions.add( new Question( questionSentence, choices, answer ) );
                  questionCount++;
                  
                  choices = new String[ 3 ];
               }
            }
            
            this.countries.add( new Country( cr.next(), Integer.parseInt( cr.next() ), Integer.parseInt( cr.next() ), questions ) );
            
            countryCount++;
            
            questions = new Questions( NUMBER_OF_QUESTIONS );
            questionCount = 0;
         }
         
         cr.close();
      }
      catch (IOException e)
      {
      }
      
   }     
}
