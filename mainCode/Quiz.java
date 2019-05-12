package mainCode;

import java.util.Observable;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

/**
 * make quiz for three randomly selected questions with givenQuestion time 15 seconds
 * @author Batuhan Gelgi
 * @version 12.05.2019
 */
public class Quiz extends Observable implements Serializable
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
   
   /*
    * return the number of current question player answer
    * @return the number of current question player answer
    */
   public int getQuestionNumber()
   {
      return questionNumber;
   }
   
   /*
    * return how many minutes left for quiz
    * @return how many minutes left for quiz
    */
   public int getRemainingTime()
   {
      return remainingTime;
   }
   
   /*
    * return whether quiz continue or not
    * @return whether quiz continue or not
    */
   public boolean isQuizzing()
   {
      return quizzing;
   }
   
   /*
    * end of quiz and update the game with result of quiz
    * @param string s  result of quiz like win, lost
    */
   public void quizEnded( String s )
   {
      notifier( s );
   }
   
   /*
    * creating new quiz for given country
    * @param Country c
    */
   public void newQuiz( Country c )
   {
      quizQuestions = c.determineThreeRandomQuestions();
      questionNumber = 0;
      remainingTime = QUESTION_TIME;
      timer.start();
      
      notifier();
   }
   
   //preparing new question if player answer correctly previous questions
   public void nextQuestion()
   {
      questionNumber++;
      remainingTime = QUESTION_TIME;
      timer.start();
      
      notifier( "next question" );
   }
   
   /*
    * return the question in the order
    * @return the question wil be asked to player 
    */
   public Question getQuestion()
   {
      return quizQuestions.get( questionNumber );
   }
   
   // set changes and notifying observers
   public void notifier( String s )
   {
      setChanged();
      notifyObservers( s );
   }
   
   // set changes and notifying observers
   public void notifier( )
   {
      setChanged();
      notifyObservers();
   }
   
   // controlling the answer of quiz question and operations related to this
   // @param int answer 
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
   public class QuestionTimeListener implements ActionListener, Serializable
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