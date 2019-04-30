package mainCode;

import java.util.Observable;
import mainCode.pictures.*;
import java.awt.Point;

// buraya bi comment at�ver
public class Country extends Observable
{
   // properties
   public static final int NUMBER_OF_PLAYERS = 4;
   int tax;
   int accomodationFee;
   String name;
   Questions questions;
   Player[] citizens;
   int numberOfCitizens;
   CountryFlag flag;
   CountryPicture picture;
   Point location;
   int locationOnRoute;
   
   // constructors 
   public Country( String name, int accomodationFee, int tax, Questions questions, int locX, int locY, int locationOnRoute ) 
   {
      this.accomodationFee = accomodationFee;
      this.name = name;
      this.questions = questions;
      citizens = new Player[ NUMBER_OF_PLAYERS ];
      numberOfCitizens = 0;
      this.tax = tax;     
      flag = new CountryFlag( name );
      picture = new CountryPicture( name );
      location = new Point( locX, locY );
      this.locationOnRoute = locationOnRoute;
   }
   
   // methods 
   
   public int getAccomodationFee()
   {
      return accomodationFee;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getTax()
   {
      return tax;
   }
   
   public Player[] getCitizens()
   {
      return citizens;
   }
   
   public Player getCitizen( int citizenNo )
   {
      return citizens[ citizenNo ];
   }
   
   public int getNumberOfCitizens()
   {
      return numberOfCitizens;
   }
   
   public Questions getQuestions()
   {
      return questions;
   }
   
   public CountryFlag getFlag()
   {
      return flag;
   }
   
   public CountryPicture getPicture()
   {
      return picture;
   }
   
   public Point getLocation()
   {
      return location;
   }
   
   public int getLocationOnRoute()
   {
      return locationOnRoute;
   }
   
   // questionlar�n i�inden 3 tane random se�ip at�yorsun 
   protected Questions determineThreeRandomQuestions()
   {
      Questions randomQuestions;
      Questions questionsTemplate;
      int location;
      
      questionsTemplate = new Questions( this.questions );
      randomQuestions = new Questions( 3 );
      
      for ( int n = 0; n < 3; n++ )
      {
         location = (int)( Math.random() * ( 10 - n ) );
         randomQuestions.putToIndex( questionsTemplate.get( location ), n );
         questionsTemplate.putToIndex( questionsTemplate.get( 9 - n ), location );
      }
      
      return randomQuestions;
   }
   
   // playeri arraya ekliyosun yani ez
   protected void addToCitizenship( Player p )
   {
      citizens[ numberOfCitizens ] = p;
      numberOfCitizens++;
   }
   
   public boolean isACitizen( Player p )
   {
      boolean isACitizen;
      int n;
      
      isACitizen = false;
      for( n = 0; n < numberOfCitizens; n++ )
      {
         if ( p.equals( citizens[ n ] ) )
         {
            isACitizen = true;
         }
      }
      
      return isACitizen;
   }
   
   public boolean isTheFirstCitizen( Player p )
   {
      return p.equals( citizens[ 0 ] );
   }
   
   public boolean hasACitizen()
   {
      return numberOfCitizens > 0;
   }
   
   public void notifier()
   {
      setChanged();
      notifyObservers();
   }
}
   
      
      