import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.green);
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(100,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Ariel",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]){
                if(player1Turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                }else{
                    if(Objects.equals(buttons[i].getText(), "")){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2) == 0){
            player1Turn = true;
            textField.setText("X Turn");
        }else{
            player1Turn = false;
            textField.setText("O Turn");
        }
    }
    public void check(){
        //check X win Conditions
        if((Objects.equals(buttons[0].getText(), "X")) &&
            (Objects.equals(buttons[1].getText(), "X")) &&
            (Objects.equals(buttons[2].getText(), "X"))){
            xWins(0,1,2);
        }
        if((Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X"))){
            xWins(3,4,5);
        }
        if((Objects.equals(buttons[6].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))){
            xWins(6,7,8);
        }
        if((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))){
            xWins(0,3,6);
        }
        if((Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X"))){
            xWins(1,4,7);
        }
        if((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))){
            xWins(2,5,8);
        }
        if((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))){
            xWins(0,4,8);
        }
        if((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))){
            xWins(2,4,6);
        }






        //check O wind Conditions
        if((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[2].getText(), "O"))){
            oWins(0,1,2);
        }
        if((Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O"))){
            oWins(3,4,5);
        }
        if((Objects.equals(buttons[6].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))){
            oWins(6,7,8);
        }
        if((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))){
            oWins(0,3,6);
        }
        if((Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O"))){
            oWins(1,4,7);
        }
        if((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))){
            oWins(2,5,8);
        }
        if((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))){
            oWins(0,4,8);
        }
        if((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))){
            oWins(2,4,6);
        }

    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }
}
