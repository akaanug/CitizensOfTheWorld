package mainCode;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import util.*;
import gui.*;
import mainCode.pictureClasses.*;

public class Game extends Observable implements Observer 
{   
   Scanner scan = new Scanner( System.in);
         
   // properties
   public static final int NUMBER_OF_QUESTIONS = 10;
   public static final int NUMBER_OF_COUNTRIES = 60;
   public static final int NUMBER_OF_CHOICES = 3;
   public static final int NUMBER_OF_QUIZ_QUESTIONS = 3;
   int numberOfPlayers;
   Player[] players;
   int roundNo;
   int turnOfPlayer;
   LeadershipTable leadershipTable;
   Player currentPlayer;
   Quiz quiz;
   Route route;
   
   // constructors         
   public Game( int numberOfPlayers, int[] locationsOfPlayers, String[] namesOfPlayers, Avatar[] avatarsOfPlayers ) 
   { 
       this.numberOfPlayers = numberOfPlayers;
       roundNo = 0;
       turnOfPlayer = 0;
       
       quiz = new Quiz();
       quiz.addObserver( this );
       
       players = new Player[ numberOfPlayers ];
       for ( int n = 0; n < numberOfPlayers; n++ )
       {
          players[ n ] = new Player( namesOfPlayers[ n ], locationsOfPlayers[ n ], avatarsOfPlayers[ n ], n );
       }
       
       shufflePlayers();
       
       currentPlayer = players[ 0 ];   
       currentPlayer.setHasTurn( true );
       
       route = new Route( players );
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
      return p.getCurrentCountry();
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
         players[ n ].setPlayerNo( n );
         playersTemp[ location ] = playersTemp[ numberOfPlayers - n - 1 ];
      }
   }
   
   public void nextTurn()
   {
      currentPlayer.addRevenue();
      currentPlayer.setHasTurn( false );
      
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
      currentPlayer.setHasTurn( true );
   }
   
   public void rollDice( )
   {
      int movementNumber;
      
      movementNumber = currentPlayer.rollDice();     
      
      currentPlayer.payTravelFee( movementNumber );
      route.movePawn( currentPlayer, movementNumber );
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
   
   public void giveAnswerToQuestion( int answer )
   {
      quiz.checkAnswer( answer );
   }
         
   public void leaveGame()
   {
      currentPlayer.leaveGame();
   }
   
   public void startGame()
   {
      // Initialise all players and leadership table 
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         getPlayer( n ).notifier();
      }
      
      leadershipTable.notifier();
   }   
   
   public void update( Observable obs, Object obj )
   {
      if ( obj != null )
      {
         String s = (String)obj;
         
         if ( s.equals( "you win" ) )
         {
            youWin();
         }
         else if ( s.equals( "you lose" ) )
         {
            youLose();
         }
         else if ( s.equals( "next question" ) )
         {
            currentPlayer.payQuestionFee();
         }
      }
   }
}