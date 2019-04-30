package mainCode;

import java.util.Observable;
   
public class LeadershipTable extends Observable
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
   
   public int size()
   {
      return leadershipTable.length;
   }
   
   public Player get( int n )
   {
      return leadershipTable[ n ];
   }
   
   public void notifier()
   {
      setChanged();
      notifyObservers();
   }
}