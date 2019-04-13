package mainCode;

// Represents package of questions.
public class Questions
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
         questions[ n ] = new Question( x.getQuestion( n ) );
      }
   }
   
   // methods  
   
   public String toString()
   {
      String s;
      int n;
      
      s = "";
      for ( n = 0; n < numberOfQuestions; n++ )
      {
         s = s + n + ") " + questions[ n ].toString();
      }
      
      return s;
   }
   
   public Question getQuestion( int questionNo )
   {
      return questions[ questionNo ];
   }
   
   public void add( Question question )
   {
      questions[ numberOfQuestions ] = question;
      numberOfQuestions++;
   }
   
   public void putToIndex( Question question, int index )
   {
      questions[ index ] = question;
   }
}
   
   