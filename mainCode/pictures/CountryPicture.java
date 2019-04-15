package mainCode.pictures;

import util.ResizablePicture;

public class CountryPicture extends ResizablePicture
{
   // properties
   public static final int WIDTH = 300;
   public static final int HEIGHT = 200;
   
   // constructors
   public CountryPicture()
   {
      super( WIDTH, HEIGHT );
   }
   
   public CountryPicture( String countryName )
   {
      super( WIDTH, HEIGHT, "..\\..\\Country Info\\Country Pictures\\" + countryName + ".jpg" );
   }
}