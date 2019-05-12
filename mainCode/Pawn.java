package mainCode;

import util.ResizablePicture;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Observable;
import java.io.Serializable;

/**
 * creating pawn object for each player
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class Pawn extends Observable implements Serializable
{
   // properties
   public static final int WIDTH = 20;
   public static final int HEIGHT = 30; 
   public static final int TIMER_CONSTANT = 40;
   public static final int SPEED = 4;
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
         
      timer = new Timer( TIMER_CONSTANT, new MovementTimeListener() ); 
   }
   
   // methods
   
   // drawing image for pawn object
   public void draw( Graphics g, JPanel panel )
   {
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\pawns\\" + p.getPlayerNo() + ".png" ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, (int)locX, (int)locY - HEIGHT, WIDTH, HEIGHT, panel );
      g2.dispose();
   }
   
   // get the location of pawn as x and y coordinates
   public Point getLocation()
   {
      return new Point( (int)locX, (int)locY );
   }
   
   // get the current country of pawn
   public Country getCurrentCountry()
   {
      return currentCountry;
   }
         
   // setting the location of pawn to given country
   protected void setLocation( Country c )
   {
      currentCountry = c;
      locX = c.getLocation().getX();
      locY = c.getLocation().getY();
   }
   
   // setting the location of pawn to given x and y coordinates
   protected void setLocation( double locX, double locY )
   {
      this.locX = locX;
      this.locY = locY;
      
      setChanged();
      notifyObservers();
   }
   
   // moving the pawn with given x and y values 
   protected void move( double x, double y )
   {
      setLocation( ( locX + x ) % 1920, locY + y );
   }
   
   // moving the pawn to next country in gameRoute
   protected void moveNextCountry()
   {
      p.payTravelFee();
      if ( p.isPlaying() )
      {
         // Get the location of next country
         currentCountry = Route.COUNTRIES_ON_ROUTE.get( ( currentCountry.getLocationOnRoute() + 1 ) % 60 );
         
         Point newLocation = new Point( currentCountry.getLocation() );
         if ( currentCountry.getLocationOnRoute() == 0 )
         {
            newLocation.translate( 1920, 0 );
         }
         
         // Find the distance and needed movements
         double distance = Math.hypot( newLocation.getX() - locX, newLocation.getY() - locY );      
         neededMovements = (int)( distance / SPEED );
         remainingTime = neededMovements;
         
         // Move the pawn
         movementOfX = ( newLocation.getX() - locX ) / neededMovements;
         movementOfY = ( newLocation.getY() - locY ) / neededMovements;
         timer.start();
      }
   }
   
   // move the pawn from given movement number of time further country from current position
   protected void moveAmongCountries( int movementNumber )
   {
      this.movementNumber = movementNumber;
      moveNextCountry();
   }
   
   //movement time listener
   public class MovementTimeListener implements ActionListener, Serializable
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         remainingTime--;
         
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
               currentCountry.notifier( "current country" );
            }
         }
      }    
   }
}
         