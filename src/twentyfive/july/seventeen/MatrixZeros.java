package twentyfive.july.seventeen;

public class MatrixZeros {

  public static void main(String[] args) {
    int[][] array = {
        {1, 0, 1},
        {1, 0, 1},
        {1, 1, 1}
    };

    setZeroes(array);
  }

  public static void setZeroes(int[][] matrix) {

    boolean colzero = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {


        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          if(j==0){
            colzero = true;
          }else {
            matrix[0][j] = 0;
          }
        }
      }
      
    }

      for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[i].length; j++) {

          if (matrix[0][j] == 0 || matrix[i][0] == 0) {
            matrix[i][j] = 0;
          }
        }
    }


    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][0]==0) {
        matrix[0][i] = 0;
      }

    }

    for (int i = 0; i < matrix.length; i++) {
      if (colzero) {
        matrix[i][0] = 0;
      }
    }
    
  }

}
