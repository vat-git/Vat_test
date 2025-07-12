package twentyfive.may.four;

public class SetMatrixZero {

  public static void main(String[] args) {
    int[][] input = {{1}, {0}, {3}};
    setZeroes(input);
  }
  public static void setZeroes(int[][] matrix) {

    int colm0 = 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {

          matrix[i][0] = 0;
          if(j==0){
            colm0 = 0;
          }else {
            matrix[0][j] = 0;
          }
        }
      }

    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        int counter = matrix[0].length - 1;
        while (counter >= 0) {
          matrix[i][counter] = 0;
          counter--;
        }
      }
    }

    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        int counter = matrix.length - 1;
        while (counter >= 0) {
          matrix[counter][i] = 0;
          counter--;
        }
      }
    }

    if (matrix[0][0] == 0) {
      int counter = matrix[0].length - 1;
      while (counter >= 0) {
        matrix[0][counter] = 0;
        counter--;
      }
    }
if(colm0==0) {
  int counter = matrix.length - 1;
  while (counter >= 0) {
    matrix[counter][0] = 0;
    counter--;
  }
}

  }

}
