package mainCode;

// Represents a single question, with choices and the answer, that will be asked to players
public class Question
{
   // properties
   public static final int QUESTION_FEE = 10;
   String questionSentence;
   String[] choices;
   int answer;
   
   // constructors
   public Question( String questionSentence, String[] choices, int answer )
   {
      this.questionSentence = questionSentence;
      this.choices = choices;
      this.answer = answer;
      
   }
   
   // clone constructoru üþendim yazýver
   public Question( Question x )
   {
      this.questionSentence = x.questionSentence;
      this.choices = x.choices;
      this.answer = x.answer;
   }
   
   // methods
   
   // javadoclarý hallediver sana zahmet
   public String getQuestionSentence()
   {
      return questionSentence;
   }
   
   public String[] getChoices()
   {
      return choices;
   }
   
   public String getChoice( int choiceNo )
   {
      return choices[ choiceNo ];
   }
   
   // toStringi biliyosun zaten soru cümlesi ve cevaplarýný düzgün bir þekilde print etsin. Cevaplarý hizalý yapsan iyi olur. 
   public String toString()
   {
      String[] choices;
      choices = getChoices();
      
      return getQuestionSentence() + "\n" + "A) " + choices[ 0 ] + "\n"  + "B) " + choices[ 1 ] 
             + "\n" + "C) " + choices[ 2 ] + "\n";
   }
   
   public final boolean isAnswerCorrect( int answer )
   {
      return this.answer == answer;
   }
}
