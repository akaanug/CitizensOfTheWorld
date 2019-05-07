package mainCode;

import util.GameFileReader;
import javax.swing.Timer;

public class Route
{
   // properties
   public static final int COUNTRY_NUMBER = 60;
   public static final int TRAVEL_CHARGE = 5;
   public static final Countries COUNTRIES_ON_ROUTE = GameFileReader.uploadCountryInfo( );
   Pawn[] pawns;
   Pawn currentPawn;
   
   // constructors
   public Route( Player[] players )
   {
      pawns = new Pawn[ players.length ];
      for ( int n = 0; n < pawns.length; n++ )
      {
         pawns[ n ] = new Pawn( players[ n ] );
      }
   }
   
   // methods
   public static Country getCountry( int location )
   {
      return COUNTRIES_ON_ROUTE.get( location );
   }
   
   public Pawn getPawn( int playerNo )
   {
      return pawns[ playerNo ];
   }
   
   protected void movePawn( Player p, int movementNumber )
   {        
      getPawn( p.getPlayerNo() ).moveAmongCountries( movementNumber );    
   }
}