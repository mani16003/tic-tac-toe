import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    JFrame window = new JFrame("Tic-Tac-Toe");

    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel = new JPanel();
    JPanel scorePanel  = new JPanel();

    JLabel textfield= new JLabel();

    JButton[] buttons = new JButton[9];
    JButton reloadButton = new JButton("Reload");
    JButton closeButton = new JButton("Close");

    JLabel scoreLabelPlayerX = new JLabel();
    JLabel scoreLabelPlayerO = new JLabel();

    int playerXScore = 0;
    int playerOScore = 0;

    boolean playerXTurn;

    TicTacToe()
    {
      window.setSize( 1000, 800);
      window.getContentPane().setBackground(new Color( 50,50,50));
      window.setLayout(new BorderLayout());
      window.setVisible( true);

      textfield.setBackground(new Color(25,25,25));
      textfield.setForeground(new Color(25,255,0));

      textfield.setFont(new Font("Ink Free",Font.BOLD,75));
      textfield.setHorizontalAlignment(JLabel.CENTER);

      textfield.setText("Tic-Tac-Toe");
      textfield.setOpaque(true);
      titlePanel.setLayout(new BorderLayout());
      titlePanel.setBounds(0, 0, 800 , 100);
      buttonPanel.setLayout(new GridLayout(3,3));
      buttonPanel.setBackground(new Color(150 ,150 ,150));

   for(int i=0;i<9;i++)
     {
         buttons[i] = new JButton();
         buttonPanel.add(buttons[i]);
         buttons[i].setFont(new Font("MV Boli", Font.BOLD,50));
         buttons[i].setFocusable(false);
         // add an action listener to the JButton array
         buttons[i].addActionListener(this);
     }
        // set the layout of the JPanel such that reload button is on the left and close button is on the right
        reloadPanel.setLayout(new GridLayout( 1, 2));
        // set the background color of the JPanel
        reloadPanel.setBackground(new Color(150, 150, 150));
        // add the reload button to the JPanel
        reloadPanel.add(reloadButton);
        // add the close button to the JPanel
        reloadPanel.add(closeButton);
        // set the font of the reload button
        reloadButton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the reload button
        reloadButton.setBackground(new Color(0, 0, 255));
        // set the font of the close button
        closeButton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the close button
        closeButton.setBackground(new Color(255, 0, 0));
        // set the reload button to be not focusable
        reloadButton.setFocusable(false);
        // set the close button to be not focusable
        closeButton.setFocusable(false);
        // add an action listener to the reload button
        reloadButton.addActionListener(this);
        // add an action listener to the close button
        closeButton.addActionListener(this);
        // set the layout of the JPanel
        scorePanel.setLayout(new GridLayout(2, 1));
        // set the background color of the JPanel as gold
        scorePanel.setBackground(new Color(255, 255, 0));
        // set the font of the score label
        scoreLabelPlayerX.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        scoreLabelPlayerX.setText("Player X: " + playerXScore);
        // add the score label to the JPanel
        scorePanel.add(scoreLabelPlayerX);
        // set the font of the score label
        scoreLabelPlayerO.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        scoreLabelPlayerO.setText("Player O: " + playerOScore);
        // add the score label to the JPanel
        scorePanel.add(scoreLabelPlayerO);
        // add the JPanel to the JFrame
        titlePanel.add(textfield);
        titlePanel.add(textfield);
        // add the JPanel to the JFrame
        window.add(titlePanel, BorderLayout.NORTH);
        // add the JPanel to the JFrame
        window.add(buttonPanel);
        // add the JPanel to the JFrame
        window.add(reloadPanel, BorderLayout.SOUTH);
        // add the JPanel to the JFrame
        window.add(scorePanel, BorderLayout.EAST);
        // call the firstTurn method
        firstTurn();
    }
    // create an action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // create a for loop
        for (int i = 0; i < 9; i++) {
            // create an if statement
            if (e.getSource() == buttons[i]) {
                // create an if statement
                if (playerXTurn) {
                    // set the text of the JButton array to X
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("X");
                        playerXTurn = false;
                        textfield.setText("O turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0, 0, 255));
                        check();
                    }
                } else {
                    // set the text of the JButton array to O
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerXTurn = true;
                        textfield.setText("X turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0, 255, 0));
                        check();
                    }
                }
            }
        }
        // add functionality to the reload button
        if (e.getSource() == reloadButton) {
            // call the reload method
            reload();
        }
        // add functionality to the close button
        if (e.getSource() == closeButton) {
            // close the window
            window.dispose();
        }
    }
    // create a method
    public void firstTurn() {
        // create a try catch block
        try {
            // create a thread
            textfield.setText("Tic-Tac-Toe");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // create an if statement
        if (Math.random() < 0.5) {
            playerXTurn = true;
            textfield.setText("X turn");
        } else {
            playerXTurn = false;
            textfield.setText("O turn");
        }
    }
    // create a method
    public void reload() {
        // create a for loop
        for (int i = 0; i < 9; i++) {
            // set the text of the JButton array to empty
            buttons[i].setText("");
            // set the background color of the JButton array to the default color
            buttons[i].setBackground(new Color(240, 240, 240));
            // set the text of the textfield to empty
            buttons[i].setEnabled(true);
        }
        // call the firstTurn method
        firstTurn();
    }
    // create a method
    public void check() {
        // create an if statement
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        // create an if statement
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        // create an if statement
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        // create an if statement
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        // create an if statement
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        // create an if statement
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        // create an if statement
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        // create an if statement
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        // create an if statement
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        // create an if statement
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        // create an if statement
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        // create an if statement
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        // create an if statement
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        // create an if statement
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        // create an if statement
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        // create an if statement
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }
    // create a method
    public void xWins(int a, int b, int c) {
        // set the text of the textfield to X wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        // add 1 to the xCount
        playerXScore++;
        // set the text of the playerX_score_label to the xCount
        scoreLabelPlayerX.setText("Player 1: " + playerXScore);
    }
    // create a method
    public void oWins(int a, int b, int c) {
        // set the text of the textfield to O wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        // add 1 to the score of O
        playerOScore++;
        // set the text of the playerO_score_label to the oCount
        scoreLabelPlayerO.setText("Player 2: " + playerOScore);

    }

    }



