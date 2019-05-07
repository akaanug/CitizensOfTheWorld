package mainCode.pictureClasses;

import util.ResizablePicture;
import java.io.Serializable;

public class CountryFlag extends ResizablePicture implements Serializable
{
   // properties
   public static final int WIDTH = 150;
   public static final int HEIGHT = 100;
   
   // constructors
   public CountryFlag( String countryName )
   {
      super( WIDTH, HEIGHT, "..\\..\\Country Info\\Country Flags\\" + countryName + ".png" );
   }
}