package mainCode.pictures;

import util.*;
import java.awt.*;
import javax.swing.*;

public class Avatar extends ResizablePicture implements Icon
{
   // properties
   public static final int WIDTH = 50;
   public static final int HEIGHT = 50;
   String filename;
   
   // constructors
   public Avatar()
   {
      super( WIDTH, HEIGHT );
   }
   
   public Avatar( String avatarName )
   {
      super( WIDTH, HEIGHT, "..\\..\\Avatar Pictures\\" + avatarName + ".png" );
      filename = super.getFilename();
   }
   
   // methods
   public void paintIcon( Component c, Graphics g, int x, int y )
   {
      Image bg = new ImageIcon(getClass().getResource( filename ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, 0, 0, WIDTH, HEIGHT, this);
      g2.dispose();
   }
   
   public int getIconWidth()
   {
      return WIDTH;
   }
   
   public int getIconHeight()
   {
      return HEIGHT;
   }
}