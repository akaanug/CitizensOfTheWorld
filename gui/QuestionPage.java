package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class QuestionPage extends JPanel implements Observer {
    
    /**
     * Creates new form QuestionPageJ
     */
    
    public static final int CHOICE_NUMBER = 3;
    GameGUI parent;
    Game game;
    ArrayList<JButton> choiceButtons;
    private JButton choiceOne;
    private JButton choiceThree;
    private JButton choiceTwo;
    private JLabel header;
    private JLabel questionSentence;
    private JLabel timeLabel;
    
    public QuestionPage( GameGUI parent ) {
        initComponents();
        
        this.parent = parent;
        game = parent.game;
        
        choiceButtons = new ArrayList<JButton>();
        choiceButtons.add( choiceOne );
        choiceButtons.add( choiceTwo );
        choiceButtons.add( choiceThree );
        
        game.getQuiz().addObserver( this );
        
        handleActionListeners();
        
        setVisible( false );
    }
    
    public void handleActionListeners()
    {
        for ( int n = 0; n < CHOICE_NUMBER; n++ )
        {
            choiceButtons.get( n ).addActionListener( new ChoiceBtnListener() );
        }
    }
    
    public class ChoiceBtnListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent evt )
        {                  
            game.giveAnswerToQuestion( choiceButtons.indexOf( evt.getSource() ) );
        }
    }
    
    public void update( Observable obs, Object obj )
    {      
        Quiz quiz = (Quiz)obs;
        Question currentQuestion = quiz.getQuestion();
        
        if ( quiz.isQuizzing() )
        {           
            timeLabel.setText( quiz.getRemainingTime() + "" );      
            header.setText( "QUESTION   " + ( quiz.getQuestionNumber() + 1 ) );
            questionSentence.setText( currentQuestion.getQuestionSentence() );
            for ( int n = 0; n < CHOICE_NUMBER; n++ )
            {
                choiceButtons.get( n ).setText( currentQuestion.getChoice( n ) );
            }
            
            setVisible( true );
        }
        else
        {
            setVisible( false );
        }
    }
    
   /**
    * This method is called from within the constructor to initialize the form.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

        choiceOne = new JButton();
        choiceTwo = new JButton();
        choiceThree = new JButton();
        header = new JLabel();
        questionSentence = new JLabel();
        timeLabel = new JLabel();

        setBackground(new java.awt.Color(102, 255, 255));

        choiceOne.setBackground(new java.awt.Color(204, 255, 255));
        choiceOne.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceOne.setText("1");
        choiceOne.setToolTipText("");

        choiceTwo.setBackground(new java.awt.Color(204, 255, 255));
        choiceTwo.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceTwo.setText("2");

        choiceThree.setBackground(new java.awt.Color(204, 255, 255));
        choiceThree.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceThree.setText("3");

        header.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        header.setForeground(new java.awt.Color(0, 0, 204));
        header.setText("jLabel1");

        questionSentence.setBackground(new java.awt.Color(255, 255, 255));
        questionSentence.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        questionSentence.setText("jLabel1");

        timeLabel.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 102, 102));
        timeLabel.setText("jLabel1");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(questionSentence, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(header, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                    .addComponent(choiceOne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceTwo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceThree, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(header, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(questionSentence, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(choiceOne, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceTwo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceThree, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>                 
}
