package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import mainCode.*;
import mainCode.pictures.Avatar;

public class GameFileReader
{   
   // Used in PlayerMenu, to create country JList.
   public static String[] getAlphabeticalCountriesArray()
   {
      final int COUNTRY_NUMBER = 60;
      
      try
      {
         String[] countries;
         FileReader fr;
         BufferedReader br;
         
         countries = new String[ COUNTRY_NUMBER ];
         fr = new FileReader( "Country Info\\countries alphabetical.txt" );
         br = new BufferedReader( fr );
         for( int n = 0; n < COUNTRY_NUMBER; n++ )
         {
            countries[ n ] = br.readLine();
         }
         
         return countries;
      }
      catch (IOException e)
      {
         return null;
      }
   }
   
   // Used in PlayerMenu, to find the locations of players from their country selections
   public static ArrayList<String> getListedCountries() 
   {
      final int COUNTRY_NUMBER = 60;
      
      try
      {
         ArrayList<String> countries;
         FileReader fr;
         BufferedReader br;
         
         countries = new ArrayList<String>();
         fr = new FileReader( "Country Info\\countries listed.txt" );
         br = new BufferedReader( fr );
         for( int n = 0; n < COUNTRY_NUMBER; n++ )
         {
            countries.add( br.readLine() );
         }
         
         return countries;
      }
      catch (IOException e)
      {
         return null;
      }
   }
   
   // Used in PlayerMenu, to create the avatars JList
   public static Avatar[] getAvatarsArray()
   {
      final int AVATAR_NUMBER = 26;
      
      try
      {
         Avatar[] avatars;
         FileReader fr;
         BufferedReader br;
         Avatar avatar;
         
         avatars = new Avatar[ AVATAR_NUMBER ];
         fr = new FileReader( "pictures\\Avatar Pictures\\avatar names.txt" );
         br = new BufferedReader( fr );
         for( int n = 0; n < AVATAR_NUMBER; n++ )
         {
            avatar = new Avatar( br.readLine() );
            avatars[ n ] = avatar;
         }
         
         return avatars;
      }
      catch (IOException e)
      {
         return null;
      }
   }
   
   // Used in Game class, to upload the country informations.
   public static Countries uploadCountryInfo( ) 
   {     
      final int NUMBER_OF_QUESTIONS = 10;
      final int NUMBER_OF_COUNTRIES = 60;
      final int NUMBER_OF_CHOICES = 3;
      
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
         Countries countries;
         
         answer = 0;
         questions = new Questions( NUMBER_OF_QUESTIONS );
         questionSentence = "";
         countries = new Countries( NUMBER_OF_COUNTRIES );
         choices = new String[ NUMBER_OF_CHOICES ];
         fr = new FileReader( "Country Info\\countries.txt" );
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
               else if ( infoCount == NUMBER_OF_CHOICES + 1 )
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
                  
                  choices = new String[ NUMBER_OF_CHOICES ];
               }
            }
            
            countries.add( new Country( cr.next(), Integer.parseInt( cr.next() ), Integer.parseInt( cr.next() ), questions, 10 * countryCount, 10 * countryCount, countryCount ) );
            
            countryCount++;
            
            questions = new Questions( NUMBER_OF_QUESTIONS );
            questionCount = 0;
         }
         
         cr.close();
         
         return countries;
      }
      catch (IOException e)
      {
         return null;
      }      
   }  
}