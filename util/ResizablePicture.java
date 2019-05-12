package util;

import java.awt.*;
import javax.swing.*;

/**
 * creating picture object which can be resizable
 * @author Keratta Kerattalar
 * @version 12.05.2019
 */
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
   
   // paintComponent method
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
   
   /*
    * setting picture with given file name and repaint
    * @param filename is the new path of the picture you want change with
    */
   public void setPicture( String filename )
   {
      this.filename = filename;
      repaint();
   }
   
   /*
    * setting picture with given resizablePicture and repaint
    * @param picture is the new picture you want to change with.
    */
   public void setPicture( ResizablePicture picture )
   {
      this.filename = picture.getFilename();
      repaint();
   }
   
   /*
    * return the width of picture
    * @return the width of picture
    */
   public int getWidth()
   {
      return width;
   }
   
   /**
    * return the height of picture
    * @return the height of picture
    */
   public int getHeight()
   {
      return height;
   }
   
   /**
    * resize the picture with given width and height and repainting
    * @param width is width of the picture
    * @param height is height of the picture
    */
   public void resizePicture( int width, int height )
   {
      this.width = width;
      this.height = height;
      
      repaint();
   }
   
   /**
    * return the filename of picture
    * @return the filename of picture
    */
   public String getFilename()
   {
      return filename;
   }
}
     