package mainCode;

import util.ResizablePicture;

public class Die extends ResizablePicture
{
   // properties
   public static final int WIDTH = 80;
   public static final int HEIGHT = 80;
   int value;
 
   // constructors
   public Die()
   {
      super( WIDTH, HEIGHT );
      value = 0;  
   }
   
   public Die( int value )
   {
      super( WIDTH, HEIGHT, "..\\pictures\\dice\\Dice" + value + ".png" );
      this.value = value;
   }
   
   // methods
   public void rollDie()
   {
      value = (int)( Math.random() * 6 ) + 1;      
      setPicture( "..\\pictures\\dice\\Dice" + value + ".png" );
   }
   
   public int getValue()
   {
      return value;
   }
}