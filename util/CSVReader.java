package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * reader class reads essential data for our game from FileReader
 * @author Yusuf Ziya Özgül
 * @version 12.05.2019
 */
public class CSVReader extends BufferedReader implements Serializable
{
   // properties
   public static final char QUOTER = '"';
   boolean write;
   
   // constructors
   public CSVReader( FileReader fr )
   {
      super( fr );
      write = false;
   }
   
   // methods
   
   //read method
   public String next() throws IOException
   {
      String s;
      char c;
      
      while ( !write )
      {
         c = (char)super.read();
         if ( c == QUOTER )
         {
            write = true;
         }
      }
      
      s = "";
      while ( write )
      {
         c = (char)super.read();
         if ( c != QUOTER )
         {
            s = s + c;
         }
         else
         {
            write = false;
         }
      }
      
      return s;
   }
   
   //closing the reader
   @Override
   public void close() throws IOException
   {
      super.close();
   }
}
