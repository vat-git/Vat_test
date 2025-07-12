package twentyfive.march.twentyfive;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {
        char[][] board = {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {


        for (int i = 0; i < 9; i++) {

            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {

                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
            }

        }

        for (int i = 0; i < 9; i++) {

            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (row.contains(board[j][i])) {
                        return false;
                    } else {
                        row.add(board[j][i]);
                    }
                }
            }

        }

        int rowLimit=2;
        int rowStart=0;
        while (rowLimit<9){

            int columenLimit = 2;
            int columnStart=0;
            while (columenLimit < 9) {
                Set<Character> row = new HashSet<>();
                for(int i=rowStart; i<=rowLimit;i++){

                    for (int j = columnStart; j <= columenLimit; j++) {
                        if (board[i][j] != '.') {
                            if (row.contains(board[i][j])) {
                                return false;
                            } else {
                                row.add(board[i][j]);
                            }
                        }
                    }
                }
                columnStart=columenLimit+1;
                columenLimit=columenLimit+3;
            }

            rowStart=rowLimit+1;
            rowLimit = rowLimit + 3;
        }

        return true;

    }


}