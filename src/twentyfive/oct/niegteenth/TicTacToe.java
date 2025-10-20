package twentyfive.oct.niegteenth;

public class TicTacToe {

    int[] rows;
    int[] columns;
    int diagonal;
    int antidiagonal;
    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;
        rows[row] = rows[row] + currentPlayer;
        if (Math.abs(rows[row]) == rows.length) {
            return player;
        }
        columns[col] = columns[col] + currentPlayer;
        if (Math.abs(columns[col]) == columns.length) {
            return player;
        }

        if (row == col) {
            diagonal += currentPlayer;
            if (Math.abs(diagonal)==rows.length) {
                return player;
            }
        }
        if (row == rows.length - 1 - col) {
            antidiagonal += currentPlayer;
            if (Math.abs(antidiagonal)==rows.length) {
                return player;
            }
        }
        return 0;

    }


}
