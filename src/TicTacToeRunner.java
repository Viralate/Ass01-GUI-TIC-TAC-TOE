import javax.swing.JFrame;

public class TicTacToeRunner {
    public static void main(String[] args) {
        JFrame frame = new TicTacToeFrame(); // Create an instance of the game frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // Make the frame visible
    }
}
