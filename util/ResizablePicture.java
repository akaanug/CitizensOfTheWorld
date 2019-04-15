package util;

import java.awt.*;
import javax.swing.*;

public class ResizablePicture extends JPanel
{
   // properties
   int width;
   int height;
   String filename;
   
   // constructors
   public ResizablePicture( int width, int height )
   {
      this.width = width;
      this.height = height;
      
      setPreferredSize( new Dimension( width, height ) );
   }
   
   public ResizablePicture( int width, int height, String filename )
   {
      this.width = width;
      this.height = height;
      this.filename = filename;
      
      setPreferredSize( new Dimension( width, height ) );
   }
   
   // methods
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent( g );
      
      if ( filename != null )
      {
         Image bg = new ImageIcon(getClass().getResource( filename ) ).getImage();
         
         Graphics2D g2 = (Graphics2D) g.create();
         g2.drawImage( bg, 0, 0, width, height, this);
         g2.dispose();
      }
   }
   
   public void setPicture( String filename )
   {
      this.filename = filename;
      repaint();
   }
   
   public void setPicture( ResizablePicture picture )
   {
      this.filename = picture.filename;
      repaint();
   }
   
   public int getWidth()
   {
      return width;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   public void resizePicture( int width, int height )
   {
      this.width = width;
      this.height = height;
      
      repaint();
   }
   
   public String getFilename()
   {
      return filename;
   }
}
     
