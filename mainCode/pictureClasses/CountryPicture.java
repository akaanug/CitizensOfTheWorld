package mainCode.pictureClasses;

import util.ResizablePicture;
import java.io.Serializable;

/** 
 * picture of countries
 * @author Yusuf Ziya Özgül
 * @version 12.05.2019
 */
public class CountryPicture extends ResizablePicture implements Serializable
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