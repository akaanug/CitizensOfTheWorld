package mainCode;

import util.*;
import javax.swing.Timer;
import java.io.Serializable;
import java.
/**
 * creating gameRoute players follow
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class Route implements Serializable
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
   
   /*
    * return the counry with given location on gameRoute
    * @param int location 
    * @return the counry with given location on gameRoute
    */
   public static Country getCountry( int location )
   {
      return COUNTRIES_ON_ROUTE.get( location );
   }
   
   /*
    * return the pawn of given player
    * @param playerNo
    * @return pawn of given player( playerNo) 
    */
   public Pawn getPawn( int playerNo )
   {
      return pawns[ playerNo ];
   }
   
   /*
    * moving the pawn of given player with given movementNumber
    * @param1 Player p
    * @param2 int movementNumber
    */
   protected void movePawn( Player p, int movementNumber )
   {        
      getPawn( p.getPlayerNo() ).moveAmongCountries( movementNumber );    
   }
   
   public void setRouteResolution( Dimension resolution )
   {
      Country temp;
      for ( int n = 0; n < COUNTRY_NUMBER; n++ )
      {
         temp = getCountry( n );
         temp.setLocation( (int)( temp.getLocation().getX() * resolution.getX() / Application.NORMAL_RESOLUTION.getX() ),
                           (int)( temp.getLocation().getY() * resolution.getY() / Application.NORMAL_RESOLUTION.getY() ) );
      }
           
      // To refresh the locations of pawns 
      for ( int n = 0; n < pawns.length; n++ )
      {
         pawns[ n ].setLocation( pawns[ n ].getCurrentCountry() );
      }
   } 
}
