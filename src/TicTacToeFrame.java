import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private TicTacToeButton[][] board; // 2D array of buttons
    private boolean playerXTurn = true; // Track whose turn it is

    public TicTacToeFrame() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3)); // Create a 3x3 grid layout for the game board

        board = new TicTacToeButton[3][3]; // Initialize the button board

        // Create and add TicTacToeButton objects to the frame
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].addActionListener(new ButtonListener());
                add(board[row][col]); // Add buttons to the frame
            }
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton buttonClicked = (TicTacToeButton) e.getSource();

            if (buttonClicked.getText().equals("")) { // Check if the button is empty
                if (playerXTurn) {
                    buttonClicked.setText("X");
                } else {
                    buttonClicked.setText("O");
                }
                playerXTurn = !playerXTurn; // Toggle player turn
                checkGameStatus(); // Check if the game is won or tied
            } else {
                JOptionPane.showMessageDialog(null, "Invalid move! Try again.");
            }
        }
    }

    private void checkGameStatus() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkWin(board[i][0], board[i][1], board[i][2]) ||
                checkWin(board[0][i], board[1][i], board[2][i])) {
                showWinDialog();
                return;
            }
        }
        if (checkWin(board[0][0], board[1][1], board[2][2]) ||
            checkWin(board[0][2], board[1][1], board[2][0])) {
            showWinDialog();
            return;
        }

        // Check for tie (all buttons filled)
        boolean tie = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().equals("")) {
                    tie = false;
                    break;
                }
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(null, "It's a tie! Click ok to play again");
            resetBoard();
        }
    }

    private boolean checkWin(TicTacToeButton b1, TicTacToeButton b2, TicTacToeButton b3) {
        return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    private void showWinDialog() {
        String winner = playerXTurn ? "O" : "X";
        JOptionPane.showMessageDialog(null, winner + " wins! Click ok to play again");
        resetBoard();
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText("");
            }
        }
        playerXTurn = true; // X starts the new game
    }
}
