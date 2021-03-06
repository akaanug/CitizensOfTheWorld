package mainCode.pictureClasses;

import util.*;
import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

/** 
 * creating Avatar object
 * @author Yusuf Ziya �zg�l
 * @version 12.05.2019
 */
public class Avatar extends ResizablePicture implements Icon, Serializable
{
   // properties
   public static final int STANDART_EDGE = 50;
   int edge;
   String filename;
   String avatarName;
   
   // constructors
   public Avatar()
   {
      super( STANDART_EDGE, STANDART_EDGE );
      
      edge = STANDART_EDGE;
   }
   
   public Avatar( String avatarName )
   {
      super( STANDART_EDGE, STANDART_EDGE, "..\\..\\pictures\\Avatar Pictures\\" + avatarName + ".png" );
      
      edge = STANDART_EDGE;
      filename = super.getFilename();
      this.avatarName = avatarName;
   }
   
   public Avatar( String avatarName, int edge )
   {
      super( STANDART_EDGE, STANDART_EDGE, "..\\..\\pictures\\Avatar Pictures\\" + avatarName + ".png" );
      
      this.edge = edge;
      filename = super.getFilename();
      this.avatarName = avatarName;
   }
   
      
   
   // methods
   public int getEdge()
   {
      return edge;
   }
   
   public String getFilename()
   {
      return filename;
   }

   public String getAvatarName()
   {
      return avatarName;
   }
   
   /*
    * resizing the picture with given edge ( edge x edge )
    * @param edge 
    */
   public void resizePicture( int edge )
   {
      this.edge = edge;
      
      super.resizePicture( edge, edge );
   }
   
   // painting the image
   public void paintIcon( Component c, Graphics g, int x, int y )
   {
      Image bg = new ImageIcon(getClass().getResource( filename ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, 0, 0, edge, edge, this);
      g2.dispose();
   }
   
   /*
    * return the width of icon
    * @return the width of icon
    */
   public int getIconWidth()
   {
      return edge;
   }
   
   /*
    * return the height of icon
    * @return the height of icon
    */
   public int getIconHeight()
   {
      return edge;
   }
}