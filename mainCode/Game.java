package mainCode;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import util.*;
import gui.*;
   
public class Game extends Observable
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
   LeadershipTable leadershipTable;
   Player currentPlayer;
   Quiz quiz;
   
   // constructors         
   public Game( int numberOfPlayers, int[] locationsOfPlayers, String[] namesOfPlayers ) 
   { 
       fileInfo( "Country Info\\countries.txt" );
       
       this.numberOfPlayers = numberOfPlayers;
       roundNo = 0;
       turnOfPlayer = 0;
       quiz = new Quiz();
       
       players = new Player[ numberOfPlayers ];
       for ( int n = 0; n < numberOfPlayers; n++ )
       {
          players[ n ] = new Player( namesOfPlayers[ n ], locationsOfPlayers[ n ], n );
       }
       
       shufflePlayers();
       
       currentPlayer = players[ 0 ];       
       leadershipTable = new LeadershipTable( players );
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
      return currentPlayer;
   }
   
   public Country getCurrentLocation()
   {
      return getLocationOfPlayer( currentPlayer );
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
   
   public Quiz getQuiz()
   {
      return quiz;
   }
   
   public LeadershipTable getLeadershipTable()
   {
      return leadershipTable;
   }
      
   public Country getLocationOfPlayer( Player p )
   {
      return countries.get( p.getLocation() );
   }
      
   public void shufflePlayers()
   {
      Player[] playersTemp;
      int location;
      
      playersTemp = new Player[ numberOfPlayers ];
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         playersTemp[ n ] = players[ n ];
      }
      
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         location = (int)( Math.random() * ( numberOfPlayers - n ) );
         players[ n ] = playersTemp[ location ];
         playersTemp[ location ] = playersTemp[ numberOfPlayers - n - 1 ];
      }
   }
   
   public void nextTurn()
   {
      currentPlayer.addRevenue();
      
      boolean found = false;         
      while( !found )
      {
         turnOfPlayer = ( turnOfPlayer + 1 ) % numberOfPlayers;
         
         if ( players[ turnOfPlayer ].isPlaying() )
         {
            found = true;
         }
      }
      
      leadershipTable.refresh();
      
      currentPlayer = getPlayer( turnOfPlayer );
      currentPlayer.notifier();
   }
   
   public void rollDice( )
   {
      currentPlayer.rollDice();      
      getCurrentLocation().notifier();
   }
   
   public boolean isTurnOf( Player p)
   {
      return p.getPlayerNo() == turnOfPlayer;
   }
   
   public void payAccomodationFee()
   {
      currentPlayer.payAccomodationFee( getCurrentLocation() );
      
      setChanged();
      notifyObservers( new AccomodationFeePage() );
   }
   
   public void payQuestionFee()
   {
      currentPlayer.payQuestionFee();
   }
   
   public void newQuiz()
   {
      quiz.newQuiz( getCurrentLocation() );
   }
      
   public void getCitizenship()
   {
      payQuestionFee();
      newQuiz();
   }
   
   public void youWin()
   {
      currentPlayer.addCitizenship( getCurrentLocation() );
      getCurrentLocation().addToCitizenship( currentPlayer );  
      
      setChanged();
      notifyObservers( new YouWinPage() );
   }
   
   public void youLose()
   {
      setChanged();
      notifyObservers( new YouLosePage() );
   }
   
   public int giveAnswerToQuestion( int answer )
   {
      int reflection = quiz.checkAnswer( answer );
   
      if ( reflection == 0 )
      {
         youLose();
      }
      else if ( reflection == 1 )
      {
         currentPlayer.payQuestionFee();
      }
      else if ( reflection == 2 )
      {
         youWin();
      }
      
      return reflection;
   }
         
   public void leaveGame()
   {
      currentPlayer.leaveGame();
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