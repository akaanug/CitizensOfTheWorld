package mainCode;

import java.util.Observable;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quiz extends Observable
{
   // properties
   public static final int QUESTION_NUMBER = 3;
   public static final int ONE_SECOND = 1000;
   public static final int QUESTION_TIME = 15;
   int remainingTime;  
   Questions quizQuestions;
   int questionNumber;
   boolean quizzing;
   Timer timer;
   
   // constructors
   public Quiz()
   {
      quizzing = false;
      timer = new Timer(ONE_SECOND, new QuestionTimeListener() );
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
   
   public int getRemainingTime()
   {
      return remainingTime;
   }
   
   public boolean isQuizzing()
   {
      return quizzing;
   }
   
   public void quizEnded( String s )
   {
      quizzing = false;
      
      notifier( s );
   }
   
   public void newQuiz( Country c )
   {
      quizQuestions = c.determineThreeRandomQuestions();
      questionNumber = 0;
      quizzing = true;
      remainingTime = QUESTION_TIME;
      timer.start();
      
      notifier();
   }
   
   public void nextQuestion()
   {
      questionNumber++;
      remainingTime = QUESTION_TIME;
      timer.start();
      
      notifier( "next question" );
   }
   
   public Question getQuestion()
   {
      return quizQuestions.get( questionNumber );
   }
   
   public void notifier( String s )
   {
      setChanged();
      notifyObservers( s );
   }
   
   public void notifier( )
   {
      setChanged();
      notifyObservers();
   }
   
   protected void checkAnswer( int answer )
   {
      timer.stop();
      
      if ( getQuestion().isAnswerCorrect( answer ) )
      {
         if ( questionNumber < QUESTION_NUMBER - 1 )
         {
            nextQuestion();
         }
         else 
         {     
            quizEnded( "you win" );
         }
      }
      else
      {
         quizEnded( "you lose" );
      }     
   }
   
   // Question time listener class
   public class QuestionTimeListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent evt )
        {
            remainingTime--;
            
            if ( remainingTime == 0 ) 
            {
                timer.stop();
                quizEnded( "you lose" );
            }
            
            notifier();
        }
    }
}