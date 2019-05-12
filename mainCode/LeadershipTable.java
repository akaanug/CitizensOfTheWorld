package mainCode;

import java.util.Observable;
import java.io.Serializable;
   
/** 
 * keeps the informations of Players to sort them as their current money and Citizenship numbers
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class LeadershipTable extends Observable implements Serializable
{
   // properties 
   Player[] leadershipTable;
   
   // constructors
   public LeadershipTable( Player[] players )
   {
      leadershipTable = new Player[ players.length ];
      for ( int n = 0; n < leadershipTable.length; n++ )
      {
         leadershipTable[ n ] = players[ n ];
      }
      
      refresh();
   }
   
   // methods
   
   //update of leadership table considering new points of players
   public void refresh()
   {
      Player temp;
      int n;
      int m;
      
      for ( n = 0; n < size(); n++ )
      {
         for ( m = 0; m < size() - n - 1; m++ )
         {
            if ( leadershipTable[ m ].compareTo( leadershipTable[ m + 1 ] ) < 0 )
            {
               temp = leadershipTable[ m ];
               leadershipTable[ m ] = leadershipTable[ m + 1 ];
               leadershipTable[ m + 1 ] = temp;
            }
         }
      }
      
      notifier();
   }
   
   //return the size of leadership table
   public int size()
   {
      return leadershipTable.length;
   }
   
   /**
    * return the nth player in leadership table
    * @param n the nth player
    * @return n'th player's content.
    */
   public Player get( int n )
   {
      return leadershipTable[ n ];
   }
   
   // notifier method
   public void notifier()
   {
      setChanged();
      notifyObservers();
   }
}