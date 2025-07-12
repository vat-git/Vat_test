package december.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {


        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1,1));

        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> currentList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0||j==i) {
                    currentList.add(1);
                    continue;
                }
                List<Integer> previousList = result.get(i - 1);
                currentList.add(previousList.get(j - 1) + previousList.get(j));
            }
            result.add(currentList);
        }
        return result;
    }

}
