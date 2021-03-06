package mainCode;

import util.GameFileReader;
import java.io.Serializable;

/** 
 * class creating countries list
 * @author Emin Adem Buran
 * @version 12.05.2019
 */
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
   
   // methods 
   
   /*
    * return the country with given location
    * @param location 
    * @return the country whose location is given location value
    */
   public Country get( int location )
   {
      return countries[ location ];
   }
   
   //adding new country to countries list
   public void add( Country country )
   {
      countries[ numberOfCountries ] = country;
      numberOfCountries++;
   }
   
   /*
    * return the number of countries
    * @return number of countries
    */
   public int getNumberOfCountries()
   {
      return numberOfCountries;
   }
   
   /*
    * return the size of countries list
    * @return the size of countries list
    */
   public int size()
   {
      return countries.length;
   }
}