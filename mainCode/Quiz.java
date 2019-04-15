package mainCode;

import java.util.Observable;

public class Quiz extends Observable
{
   // properties
   public static final int QUESTION_NUMBER = 3;
   Questions quizQuestions;
   int questionNumber;
   boolean quizzing;
   
   // constructors
   public Quiz()
   {
      quizzing = false;
   }
   
   public Quiz( Country c )
   {
      newQuiz( c );
   }
   
   // methods
   public int getQuestionNumber()
   {
      return questionNumber;
   }
   
   public boolean isQuizzing()
   {
      return quizzing;
   }
   
   public void quizEnded()
   {
      quizzing = false;
      
      notifier();
   }
   
   public void newQuiz( Country c )
   {
      quizQuestions = c.determineThreeRandomQuestions();
      questionNumber = 0;
      quizzing = true;
      
      notifier();
   }
   
   public void nextQuestion()
   {
      questionNumber++;
      
      notifier();
   }
   
   public Question getQuestion()
   {
      return quizQuestions.get( questionNumber );
   }
   
   public void notifier()
   {
      setChanged();
      notifyObservers();
   }
   
   public int checkAnswer( int answer )
   {
      if ( getQuestion().isAnswerCorrect( answer ) )
      {
         if ( questionNumber < QUESTION_NUMBER - 1 )
         {
            nextQuestion();
            return 1;
         }
         else 
         {     
            quizEnded();
            return 2;
         }
      }
      else
      {
         quizEnded();
         return 0;
      }     
   }
}