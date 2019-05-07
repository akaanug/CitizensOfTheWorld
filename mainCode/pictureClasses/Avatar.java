package mainCode.pictureClasses;

import util.*;
import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

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
   
   public void resizePicture( int edge )
   {
      this.edge = edge;
      
      super.resizePicture( edge, edge );
   }
   
   public void paintIcon( Component c, Graphics g, int x, int y )
   {
      Image bg = new ImageIcon(getClass().getResource( filename ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, 0, 0, edge, edge, this);
      g2.dispose();
   }
   
   public int getIconWidth()
   {
      return edge;
   }
   
   public int getIconHeight()
   {
      return edge;
   }
}