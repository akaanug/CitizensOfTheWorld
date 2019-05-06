package mainCode;

import util.ResizablePicture;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observable;

public class Pawn extends Observable
{
   // properties
   public static final int WIDTH = 20;
   public static final int HEIGHT = 30; 
   public static final int MOVING_TIME_ONE_PIXEL = 40;
   String picturePath;
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
      this.p = p;
      setLocation( p.getCurrentCountry() );
         
      timer = new Timer( MOVING_TIME_ONE_PIXEL, new MovementTimeListener() ); 
   }
   
   // methods
   public void draw( Graphics g, JPanel panel )
   {
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\pawns\\" + p.getPlayerNo() + ".png" ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, (int)locX, (int)locY - HEIGHT, WIDTH, HEIGHT, panel );
      g2.dispose();
   }
   
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
      
      setChanged();
      notifyObservers();
   }
   
   protected void move( double x, double y )
   {
      setLocation( ( locX + x ) % 1920, locY + y );
   }
   
   protected void moveNextCountry()
   {
      // Get the location of next country
      p.payTravelFee();
      currentCountry = Route.COUNTRIES_ON_ROUTE.get( ( currentCountry.getLocationOnRoute() + 1 ) % 60 );
      
      Point newLocation = new Point( currentCountry.getLocation() );
      if ( currentCountry.getLocationOnRoute() == 0 )
      {
         newLocation.translate( 1920, 0 );
      }
      
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
            
            setLocation( (int)locX, (int)locY ); // k�s�ratlar� yok etmek i�in         
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
         