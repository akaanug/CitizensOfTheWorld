package util;

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*;

/*
 * music player class and controlling the music playing operations
 * @author Batuhan Gelgi
 * @version 12.05.2019
 */
public class MusicPlayer implements Runnable, LineListener 
{
   //properties   
   final int VOLUME_DOWN = 30;
   final int MUTE_BTN_SIZE = 30;
   Clip clip;
   File soundFile;
   AudioInputStream ais;
   AudioFormat format;
   DataLine.Info info;
   FloatControl gainControl;
   private ArrayList<String> musicFiles;
   private int currentSongIndex;
   long clipTimePosition;
   boolean muted;
   ResizablePicture muteIcon;
   
   //constructors
   public MusicPlayer( ArrayList<String> files )
   {
      musicFiles = new ArrayList<String>();
      for ( int i = 0; i < files.size(); i++ )
      {
         musicFiles.add( "Music\\" + files.get( i ) + ".wav" );   
      }
      muteIcon = new ResizablePicture( MUTE_BTN_SIZE, MUTE_BTN_SIZE, "..\\pictures\\mute\\speaker.png" );
      clipTimePosition = 0L;
      muted = false;
      
      run();
   } 
   
   //methods
   
   //playing music file
   public void play()
   {
      try
      {
         soundFile = new File( musicFiles.get( currentSongIndex ) );
         ais = AudioSystem.getAudioInputStream( soundFile );
         
         // get audio format
         format = ais.getFormat();
         
         info = new DataLine.Info( Clip.class, format);
         clip = (Clip) AudioSystem.getLine( info );
         clip.addLineListener( this );
         clip.open( ais );
                  
         // make the music lower by VOLUME_DOWN desibel
         gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue( -VOLUME_DOWN );
         
      }catch(Exception e){
         e.printStackTrace();
      }
      clip.start();     
   }
   
   // playing the music files from musiclist
   @Override
   public void run()
   {
      play();
      try
      {
         currentSongIndex++;
         if ( currentSongIndex >= musicFiles.size() )
         {
            currentSongIndex = 0;
         } 
      } catch( Exception e ) {
         e.printStackTrace();
      }
   }
   
   // setting the situation of music audios like muted or not
   public void mute()
   {
      if ( !muted )
      {
         clipTimePosition = clip.getMicrosecondPosition();
         clip.stop();
         muteIcon.setPicture( "..\\pictures\\mute\\mute.png" );
      }
      else 
      {
         clip.setMicrosecondPosition( clipTimePosition );
         clip.start();
         muteIcon.setPicture( "..\\pictures\\mute\\speaker.png" );
      }
      muted = !muted;
   }
   
   /*
    * return the muteIcon 
    * @return the muteIcon
    */
   public ResizablePicture getIcon()
   {
      return muteIcon;
   }
   
   //updating the situation of music audio 
   @Override
   public void update( LineEvent event)
   {
      if ( event.getType() == LineEvent.Type.STOP )
      {
         clip.stop();
         clip.flush();
         clip.setFramePosition( 0 );
         if ( !muted )
         {
            run();
         }
      }
   }
   
}