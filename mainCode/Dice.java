package mainCode;

import java.util.Observable;

public class Dice extends Observable
{
   // properties
   Die die1;
   Die die2;
   
   // constructors
   public Dice()
   {
      die1 = new Die();
      die2 = new Die();
   }
   
   public Dice( int value1, int value2 )
   {
      die1 = new Die( value1 );
      die2 = new Die( value2 );
   }
   
   // methods
   public int rollDice()
   {
      die1.rollDie();
      die2.rollDie();
      
      setChanged();
      notifyObservers();
      
      return getTotalDice();
   }
   
   public int getTotalDice()
   {
      return die1.getValue() + die2.getValue();
   }
   
   public Die getDie1()
   {
      return die1;
   }
   
   public Die getDie2()
   {
      return die2;
   }
}