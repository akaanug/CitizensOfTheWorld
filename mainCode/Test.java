package mainCode;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * __program description___ 
 * @author Burak ÖÇALAN
 * @version 3.12.2018
 */ 
public class Test
{   

   public static void main( String[] args) throws IOException
   {
      Scanner scan = new Scanner( System.in);

      // constants
      final int NUMBER_OF_PLAYERS = 3;
      
      // variables
      Game game;
      Player p1, p2, p3, p4;
      int n;
      String name;
      int location;
      String[] names = { "burak", "adem", "batuhan" };
      int[] locations = { 1, 2, 3 };
      Player[] players;
      Country country;
      Question question;
      String[] countries;
      FileReader fr;
      BufferedReader br;
      String[] headerRecord;
      // program code
      
      players = new Player[ NUMBER_OF_PLAYERS ];
      for ( n = 0; n < NUMBER_OF_PLAYERS; n++ )
      {
         players[ n ] = new Player( names[ n ], locations[ n ], n );
      }

      p1 = players[ 0 ];
      p2 = players[ 1 ];
      p3 = players[ 2 ];
      // initialize the game
      game = new Game( "Country Infos\\countries.txt", players );
            
//      fr = new FileReader( "mainCode\\countries listed.txt" );
//      br = new BufferedReader( fr );
//      countries = new String[ 60 ];
//      for( n = 0; n < 60; n++ )
//      {
//         countries[ n ] = "\"" + br.readLine() + "\"";
//      }
//      
//      FileWriter writer = new FileWriter( "mainCode\\countries CSV.txt" );
//      BufferedWriter bw = new BufferedWriter( writer );
//      
      for ( n = 0; n < 60; n++ )
      {
         country = game.countries.getCountry( n );
            
         for ( int m = 0; m < 10; m++ )
         {
            question = country.questions.getQuestion( m );
            System.out.println( "\"" + question.questionSentence + "\",\"" + question.choices[0] + "\",\"" + question.choices[1] 
                                + "\",\"" + question.choices[2] + "\",\"" + question.answer + "\"" );
         }
         
         System.out.println( "\"" + country.name + "\",\"" + country.accomodationFee + "\",\"" + country.tax + "\"" );
      } 
//      
//      for ( n = 0; n < 60; n++ )
//      {
//         country = game.countries.getCountry( 0 );
//            
//         for ( int m = 0; m < 60; m++ )
//         {
//            if ( countries[ n ].equals( game.countries.getCountry( m ).getName() ) )
//            {
//               country = game.countries.getCountry( m );
//            }
//         }
//            
//         for ( int m = 0; m < 10; m++ )
//         {
//            question = country.questions.getQuestion( m );
//            bw.write( question.question );
//            bw.newLine();
//            bw.write( question.choices[0] );        
//            bw.newLine(); 
//            bw.write( question.choices[1] );        
//            bw.newLine();    
//            bw.write( question.choices[2] );        
//            bw.newLine();    
//            bw.write( question.answer );        
//            bw.newLine();    
//         }
//         
//         bw.write( country.name );        
//         bw.newLine();   
//         bw.write( country.accomodationFee );        
//         bw.newLine();
//         bw.write( country.tax );        
//         bw.newLine();
//      } 
   }

}