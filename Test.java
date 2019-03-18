import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * __program description___ 
 * @author Burak ÖÇALAN
 * @version 3.12.2018
 */ 
public class Test 
{   

   public static void main( String[] args) throws Exception
   {
      Scanner scan = new Scanner( System.in);

      // constants
      final int NUMBER_OF_PLAYERS = 4;
      
      // variables
      Game game;
      Player p1, p2, p3, p4;
      int n;
      String name;
      int location;
      String[] names = { "burak", "adem", "batuhan", "kaan" };
      int[] locations = { 1, 2, 3, 4 };
      Player[] players;
      
      // program code
      
      players = new Player[ NUMBER_OF_PLAYERS ];
      for ( n = 0; n < NUMBER_OF_PLAYERS; n++ )
      {
         players[ n ] = new Player( names[ n ], locations[ n ], n );
      }

      p1 = players[ 0 ];
      p2 = players[ 1 ];
      p3 = players[ 2 ];
      p4 = players[ 3 ];
      // initialize the game
      game = new Game( "H:\\private\\cs102\\proje\\countries.txt", players );
          
      // play game
      for( int m = 0; m < 5; m++ )
      {
         game.playTurn( p1 );
         game.playTurn( p2 );
         game.playTurn( p3 );
         game.playTurn( p4 );
      }
      System.out.println( p1.getMoney() );
      System.out.println( p2.getMoney() );
      System.out.println( p3.getMoney() );
      System.out.println( p4.getMoney() );      
   }

}
