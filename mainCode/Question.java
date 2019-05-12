package mainCode;

import java.io.Serializable;

/** 
 * Represents a single question, with choices and the answer, that will be asked to players
 * @author Ahmet Kaan Uguralp
 * @version 12.05.2019
 */
public class Question implements Serializable
{
   // properties
   public static final int CHOICE_NUMBER = 3;
   public static final int QUESTION_FEE = 60;
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
   
   public Question( Question x )
   {
      this.questionSentence = x.questionSentence;
      this.choices = x.choices;
      this.answer = x.answer;
   }
   
   // methods
   
   // getting question sentence
   public String getQuestionSentence()
   {
      return questionSentence;
   }
   
   /*
    * getting choices for questions
    * @return choices for questions
    */
   public String[] getChoices()
   {
      return choices;
   }
   
   /*
    * return the choices of question with given choiceNo
    * @return the choices of question with given choiceNo
    */
   public String getChoice( int choiceNo )
   {
      return choices[ choiceNo ];
   }
   
   /*
    * whether answer for question is true or nor
    * @param answer for question
    * @return answer is true or not
    */
   protected final boolean isAnswerCorrect( int answer )
   {
      return this.answer == answer;
   }
}