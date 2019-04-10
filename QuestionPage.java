import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.ArrayList;

// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class QuestionPage extends JPanel {

   // private variables
   public static final int MAX_QUESTION_NUMBER = 3;
   public static final int CHOICE_NUMBER = 3;
   public static final int ONE_SECOND = 1000;
   public static final int QUESTION_TIME = 15;
   public int remainingTime;  
   Questions questions;
   Question currentQuestion;
   JLabel header;
   JLabel timeLabel;
   Timer timer;
   JLabel questionSentence;
   JButton choiceOne;
   JButton choiceTwo;
   JButton choiceThree;
   ArrayList<JButton> choiceButtons;
   int questionNumber; // Bununla sorunun kaçýncý soru olduðunu bilicez. ( ingilizcem yetmedi ) 
   int n; // for loops
   GameGUI parent;
   Country c;
   Player p;
   
   // Constructor to setup the GUI components
   public QuestionPage( GameGUI parent )
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      setVisible( false );
      
      // Declare some variables
      this.parent = parent;
      
      header = new JLabel();
      add( header );
      
      timeLabel = new JLabel( remainingTime + "" );
      add( timeLabel );
      
      questionSentence = new JLabel();
      add( questionSentence );
      
      // Declare buttons
      choiceButtons = new ArrayList<JButton>();
      
      choiceOne = new JButton();
      choiceButtons.add( choiceOne );
      
      choiceTwo = new JButton();
      choiceButtons.add( choiceTwo );
      
      choiceThree = new JButton();
      choiceButtons.add( choiceThree );
      
      // Add Buttons to the Panel while arranging their event handlers
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         add( choiceButtons.get( n ) );
         choiceButtons.get( n ).addActionListener( new ChoiceBtnListener() );
      }
      
      // Time Arranger
      timer = new Timer(ONE_SECOND, new QuestionTimeListener() );
   }
   
//   public QuestionPage( Questions questions, int countryIncome, GameGUI parent ) 
//   {
//      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
//  
//      // Declare the variables and add them to the panel
//      this.questions = questions;
//      questionNumber = 0;
//      currentQuestion = questions.getQuestion( questionNumber );
//      this.countryIncome = countryIncome;
//      
//      header = new JLabel( "QUESTION   " + ( questionNumber + 1 ) );
//      add( header );
//      
//      timeLabel = new JLabel( questionTime + "" );
//      add( timeLabel );
//      
//      questionSentence = new JLabel( currentQuestion.getQuestionSentence() );
//      add( questionSentence );
//      
//         // Declare Buttons
//      choiceButtons = new ArrayList<JButton>();
//      
//      choiceOne = new JButton( currentQuestion.getChoice( 0 ) );
//      choiceButtons.add( choiceOne );
//      
//      choiceTwo = new JButton( currentQuestion.getChoice( 1 ) );
//      choiceButtons.add( choiceTwo );
//      
//      choiceThree = new JButton( currentQuestion.getChoice( 2 ) );
//      choiceButtons.add( choiceThree );
//      
//         // Add Buttons to the Panel while arranging their event handlers
//      for ( n = 0; n < CHOICE_NUMBER; n++ )
//      {
//         add( choiceButtons.get( n ) );
//         choiceButtons.get( n ).addActionListener( new ChoiceBtnListener() );
//      }
//      
//      // Time Arranger
//      timer = new Timer(ONE_SECOND, new QuestionTimeListener() );
//
//      setVisible( true );
//      timer.start();
//   }

   // Methods  
   
   // Question Time Listener
   public class QuestionTimeListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         remainingTime--;
         
         timeLabel.setText( remainingTime + "" );
         
         if ( remainingTime == 0 ) 
         {
            timer.stop();
            parent.youLosePage.refresh( questionNumber );
            setVisible( false );
         }
      }
   }
   
   // Choice Button Listener
   public class ChoiceBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {                  
         timer.stop();
         
         if ( currentQuestion.isAnswerCorrect( choiceButtons.indexOf( evt.getSource() ) ) )
         {
            if ( questionNumber < MAX_QUESTION_NUMBER - 1 )
            {
               newQuestion( questionNumber + 1 );
               
               p.payQuestionFee();
               parent.northPanelMoneyRefresher();
            }
            else 
            {               
               p.addCitizenship( c );
               c.addToCitizenship( p );
               
               parent.youWinPage.refresh( c.getTax() );
               setVisible( false );
            }
         }
         else
         {
            parent.youLosePage.refresh( questionNumber );
            setVisible( false );
         }
      }
   }
   
   public void newQuestion( int questionNumber )
   {
      this.questionNumber = questionNumber;
      currentQuestion = questions.getQuestion( questionNumber );
      remainingTime = QUESTION_TIME;
              
      timeLabel.setText( remainingTime + "" );      
      header.setText( "QUESTION   " + ( questionNumber + 1 ) );
      questionSentence.setText( currentQuestion.getQuestionSentence() );
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         choiceButtons.get( n ).setText( currentQuestion.getChoice( n ) );
      }
      
      timer.start();
   }
   
   public void totallyNewQuestions( Player p, Country c )
   {
      // Defining some variables
      this.c = c;
      this.p = p;
      this.questions = c.determineThreeRandomQuestions();
      questionNumber = 0;
      currentQuestion = questions.getQuestion( questionNumber );
      remainingTime = QUESTION_TIME;
      
      // Arranging some panels and buttons 
      timeLabel.setText( remainingTime + "" ); 
      header.setText( "QUESTION   1" ); 
      questionSentence.setText( currentQuestion.getQuestionSentence() );
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         choiceButtons.get( n ).setText( currentQuestion.getChoice( n ) );
      }
      
      setVisible( true );
      timer.start();
   }
}   
         