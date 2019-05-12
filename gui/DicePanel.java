package gui;

import mainCode.*;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import util.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;

public class DicePanel extends JPanel implements Observer
{
   // properties
   Game game;
   Die die1;
   Die die2;
   
   // constructors
   public DicePanel( Game game )
   {            
      this.game = game;      
      die1 = game.getDice().getDie1();
      die2 = game.getDice().getDie2();
      
      game.addObserver( this );
      
      add( die1 );
      add( die2 );
      
      setPreferredSize( new Dimension( 300, 300 ) );
      setOpaque( false );
      setVisible( false );
   }
   
   // methods      
   public void update( Observable obs, Object obj )
   {                            
      setVisible( game.getStage().equals( "moving pawn" ) );
   }
}