package twentyfive.april.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

  public static void main(String[] args) {
    System.out.println(generate(3));
  }
  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> result = new ArrayList<>();
    if (numRows < 1) {
      return result;
    }

    List<Integer> firstRow = Arrays.asList(1);
    result.add(firstRow);
    if (numRows == 1) {
      return result;
    }
    List<Integer> secondRow = Arrays.asList(1, 1);
    result.add(secondRow);

    int counter = 2;
    while (counter < numRows) {
      List<Integer> previous = result.get(counter - 1);
      int insideCounter = 0;
      List<Integer> insideList = new ArrayList<>();
      while (insideCounter <= counter) {
        if (insideCounter == 0 || insideCounter == counter) {
          insideList.add(1);
        } else {
          insideList.add(previous.get(insideCounter-1) + previous.get(insideCounter));
        }
        insideCounter++;
      }
      result.add(insideList);
      counter++;
    }
    return result;

  }

}
