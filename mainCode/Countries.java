package mainCode;

import util.GameFileReader;
import java.io.Serializable;

// buraya bi comment at�ver
public class Countries implements Serializable
{
   // properties
   Country[] countries;
   int numberOfCountries;
   
   // constructors
   public Countries( Country[] countries )
   {
      this.countries = new Country[ countries.length ];
      
      for ( int n = 0; n < countries.length; n++ )
      {
         this.countries[ n ] = countries[ n ];
      }

   }
   
   public Countries( int maxCountryNumber )
   {
      countries = new Country[ maxCountryNumber ];
   }
   
   // methods ( javadoclar )
   public Country get( int location )
   {
      return countries[ location ];
   }
   
   public void add( Country country )
   {
      countries[ numberOfCountries ] = country;
      numberOfCountries++;
   }
   
   public int getNumberOfCountries()
   {
      return numberOfCountries;
   }
   
   public int size()
   {
      return countries.length;
   }
}