// buraya bi comment atýver
public class Countries
{
   // properties
   public static final int COUNTRY_NUMBER = 60;
   Country[] countries;
   int numberOfCountries;
   
   // constructors
   public Countries( Country[] countries )
   {
      countries = new Country[ COUNTRY_NUMBER ];
      
      for ( int n = 0; n < COUNTRY_NUMBER; n++ )
      {
         this.countries[ n ] = countries[ n ];
      }
   }
   
   public Countries()
   {
      countries = new Country[ COUNTRY_NUMBER ];
   }
   
   // methods ( javadoclar )
   public Country getCountry( int location )
   {
      return countries[ location ];
   }
   
   public void add( Country country )
   {
      countries[ numberOfCountries ] = country;
      numberOfCountries++;
   }
}