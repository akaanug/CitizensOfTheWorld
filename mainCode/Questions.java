package mainCode;

import java.io.Serializable;

/** 
 * Represents package of questions.
 * @author Ahmet Kaan Uguralp
 * @version 12.05.2019
 */
public class Questions implements Serializable
{
   // properties
   Question[] questions;
   int numberOfQuestions;
   
   // constructors   
   public Questions( int size ) 
   {
      questions = new Question[ size ];
      numberOfQuestions = 0;
   }
   
   public Questions( Questions x )
   {
      int n;
      
      questions = new Question[ x.questions.length ];
      for ( n = 0; n < questions.length; n++ )
      {
         questions[ n ] = new Question( x.get( n ) );
      }
   }
   
   // methods  
   
   /*
    * return question with given questionNo
    * @param questionNo
    * @return the question (questionNo )
    */
   public Question get( int questionNo )
   {
      return questions[ questionNo ];
   }
   
   /*
    * adding new question to question list
    * @param given question and which is added
    */
   public void add( Question question )
   {
      questions[ numberOfQuestions ] = question;
      numberOfQuestions++;
   }
   
   /*
    * changing given index with given question
    * @param1 given question
    * @param2 given index
    */
   public void putToIndex( Question question, int index )
   {
      questions[ index ] = question;
   }
}
   
   