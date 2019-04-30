package mainCode.pictures;

import util.*;

public class PlayerAvatar extends ResizablePicture
{
   // properties
   public static final int WIDTH = 50;
   public static final int HEIGHT = 50;
   
   // constructors
   public PlayerAvatar()
   {
      super( WIDTH, HEIGHT );
   }
   
   public PlayerAvatar( String avatarName )
   {
      super( WIDTH, HEIGHT, "..\\..\\Avatar Pictures\\" + avatarName + ".png" );
   }
}