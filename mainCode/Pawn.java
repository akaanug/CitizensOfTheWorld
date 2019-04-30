package mainCode;

import util.ResizablePicture;
import java.awt.Point;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pawn
{
   // properties
   public static final int WIDTH = 10;
   public static final int HEIGHT = 15; 
   public static final int MOVING_TIME_ONE_PIXEL = 40;
   ResizablePicture picture;
   Player p;
   Country currentCountry;
   double locX;
   double locY;
   Timer timer;
   int neededMovements;
   int remainingTime;
   int movementNumber;
   double movementOfX;
   double movementOfY;
   
   // constructors
   public Pawn( Player p )
   {
      picture = new ResizablePicture( WIDTH, HEIGHT, "..\\pictures\\Pawns\\" + p.getPlayerNo() + ".png" );  
      
      this.p = p;
      setLocation( p.getCurrentCountry() );
      
      timer = new Timer( MOVING_TIME_ONE_PIXEL, new MovementTimeListener() ); 
   }
   
   // methods
   public Point getLocation()
   {
      return new Point( (int)locX, (int)locY );
   }
   
   public Country getCurrentCountry()
   {
      return currentCountry;
   }
         
   protected void setLocation( Country c )
   {
      currentCountry = c;
      locX = c.getLocation().getX();
      locY = c.getLocation().getY();
   }
   
   protected void setLocation( double locX, double locY )
   {
      this.locX = locX;
      this.locY = locY;
   }
   
   protected void move( double x, double y )
   {
      setLocation( locX + x, locY + y );
      System.out.println( locX );
      System.out.println( locY );
   }
   
   protected void moveNextCountry()
   {
      // Get the location of next country
      currentCountry = Route.COUNTRIES_ON_ROUTE.get( ( currentCountry.getLocationOnRoute() + 1 ) % 60 );
      Point newLocation = currentCountry.getLocation();
      
      // Find the distance and needed movements
      double distance = Math.hypot( newLocation.getX() - locX, newLocation.getY() - locY );      
      neededMovements = (int)distance;
      remainingTime = neededMovements;
      
      // Move the pawn
      movementOfX = ( newLocation.getX() - locX ) / neededMovements;
      movementOfY = ( newLocation.getY() - locY ) / neededMovements;
      timer.start();
      
   }
   
   protected void moveAmongCountries( int movementNumber )
   {
      this.movementNumber = movementNumber;
      moveNextCountry();
   }
   
   public class MovementTimeListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         remainingTime--;
         System.out.println( remainingTime );
         
         move( movementOfX, movementOfY );   
         
         if ( remainingTime == 0 ) 
         {
            timer.stop();
            movementNumber--;
            
            setLocation( (int)locX, (int)locY ); // küsüratlarý yok etmek için         
            p.setLocation( currentCountry );
            
            if ( movementNumber != 0 )
            {
               moveNextCountry();
            }
            else
            {
               currentCountry.notifier();
            }
         }
      }
   }
}
         