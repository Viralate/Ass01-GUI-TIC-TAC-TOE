import javax.swing.JButton;

public class TicTacToeButton extends JButton {
    private int row, col;

    public TicTacToeButton(int row, int col) {
        this.row = row;
        this.col = col;
        setFont(getFont().deriveFont(50f)); // Set large font for the buttons
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
