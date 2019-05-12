package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import mainCode.*;
import mainCode.pictureClasses.Avatar;
import java.io.Serializable;

/**
 * gamefilereader to create countryList, avatarsList
 * @author Yusuf Ziya Özgül
 * @version 12.05.2019
 */
public class GameFileReader implements Serializable
{  
   //propeties
   //constructors
   
  //methods
  
   // Used in PlayerMenu, to create country JList.
   // @return countrylist alpahabetically
   public static String[] getAlphabeticalCountriesArray()
   {
      final int COUNTRY_NUMBER = Route.COUNTRY_NUMBER;
      
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
      final int COUNTRY_NUMBER = Route.COUNTRY_NUMBER;
      
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
   
   //Used in MusicPlayer, to to create the musics String list
   public static ArrayList<String> getMusics() 
   {
      final int MUSIC_NUMBER = 2;
      
      try
      {
         ArrayList<String> musics;
         FileReader fr;
         BufferedReader br;
         
         musics = new ArrayList<String>();
         fr = new FileReader( "Music\\musics.txt" );
         br = new BufferedReader( fr );
         for ( int i = 0; i < MUSIC_NUMBER; i++ )
         {
            musics.add( br.readLine() );
         }
         
         return musics;
      }
      catch (IOException e)
      {
         return null;
      }
   }
   
   // Used in Game class, to upload the country informations.
   public static Countries uploadCountryInfo( ) 
   {     
      final int QUESTION_NUMBER = Country.QUESTION_NUMBER;
      final int COUNTRY_NUMBER = Route.COUNTRY_NUMBER;
      final int CHOICE_NUMBER = Question.CHOICE_NUMBER;
      
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
         questions = new Questions( QUESTION_NUMBER );
         questionSentence = "";
         countries = new Countries( COUNTRY_NUMBER );
         choices = new String[ CHOICE_NUMBER ];
         fr = new FileReader( "Country Info\\countries.txt" );
         cr = new CSVReader( fr );
         infoCount = 0;
         questionCount = 0;
         countryCount = 0;
         while ( countryCount < COUNTRY_NUMBER )
         {
            while ( questionCount < QUESTION_NUMBER )
            {
               if ( infoCount == 0 )
               {
                  questionSentence = cr.next();
               }
               else if ( infoCount == CHOICE_NUMBER + 1 )
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
                  
                  choices = new String[ CHOICE_NUMBER ];
               }
            }
            
            countries.add( new Country( cr.next(), Integer.parseInt( cr.next() ), Integer.parseInt( cr.next() ), questions, Integer.parseInt( cr.next() ), Integer.parseInt( cr.next() ), countryCount ) );
            
            countryCount++;
            
            questions = new Questions( QUESTION_NUMBER );
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