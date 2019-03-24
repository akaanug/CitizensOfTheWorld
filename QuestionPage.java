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
   Questions questions;
   Question currentQuestion;
   JLabel header;
   JLabel questionSentence;
   JButton choiceOne;
   JButton choiceTwo;
   JButton choiceThree;
   ArrayList<JButton> choiceButtons;
   int countryIncome; // this is needed when player answers all questions correctly
   int questionNumber; // Bununla sorunun kaçýncý soru olduðunu bilicez. ( ingilizcem yetmedi ) 
   int n; // for loops
   GameGUI parent;
   
   // Constructor to setup the GUI components
   public QuestionPage( GameGUI parent )
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      setVisible( false );
      
      // Declare some variables
      this.parent = parent;
      
      header = new JLabel();
      add( header );
      
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
   }
   
   public QuestionPage( Questions questions, int countryIncome, GameGUI parent ) 
   {
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
  
      // Declare the variables and add them to the panel
      this.questions = questions;
      questionNumber = 0;
      currentQuestion = questions.getQuestion( questionNumber );
      this.countryIncome = countryIncome;
      
      header = new JLabel( "QUESTION   " + ( questionNumber + 1 ) );
      add( header );
      
      questionSentence = new JLabel( currentQuestion.getQuestionSentence() );
      add( questionSentence );
      
         // Declare Buttons
      choiceButtons = new ArrayList<JButton>();
      
      choiceOne = new JButton( currentQuestion.getChoice( 0 ) );
      choiceButtons.add( choiceOne );
      
      choiceTwo = new JButton( currentQuestion.getChoice( 1 ) );
      choiceButtons.add( choiceTwo );
      
      choiceThree = new JButton( currentQuestion.getChoice( 2 ) );
      choiceButtons.add( choiceThree );
      
         // Add Buttons to the Panel while arranging their event handlers
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         add( choiceButtons.get( n ) );
         choiceButtons.get( n ).addActionListener( new ChoiceBtnListener() );
      }
      
      setVisible( true );
   }

   // Methods  
   
   // Choice Button Listener
   public class ChoiceBtnListener implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         if ( choiceButtons.indexOf( evt.getSource() ) == currentQuestion.getAnswer() )
         {
            if ( questionNumber < MAX_QUESTION_NUMBER - 1 )
            {
               newQuestion( questionNumber + 1 );
            }
            else 
            {
               parent.simplePages.youWin( countryIncome );
               setVisible( false );
            }
         }
         else
         {
            parent.simplePages.youLose( );
            setVisible( false );
         }
         
      }
   }
   
   public void newQuestion( int questionNumber )
   {
      this.questionNumber = questionNumber;
      currentQuestion = questions.getQuestion( questionNumber );
      
      header.setText( "QUESTION   " + ( questionNumber + 1 ) );
      questionSentence.setText( currentQuestion.getQuestionSentence() );
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         choiceButtons.get( n ).setText( currentQuestion.getChoice( n ) );
      }
   }
   
   public void totallyNewQuestions( Questions questions, int countryIncome )
   {
      // Defining some variables
      this.questions = questions;
      questionNumber = 0;
      currentQuestion = questions.getQuestion( questionNumber );
      this.countryIncome = countryIncome;
      
      // Arranging some panels and buttons 
      header.setText( "QUESTION   1" ); 
      questionSentence.setText( currentQuestion.getQuestionSentence() );
      for ( n = 0; n < CHOICE_NUMBER; n++ )
      {
         choiceButtons.get( n ).setText( currentQuestion.getChoice( n ) );
      }
      
      setVisible( true );
   }
}   
         