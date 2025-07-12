package twentyfive.april.thrity;

public class EvenNumberOfDigits {

  public static void main(String[] args) {
    int[] num = {12, 345, 2, 6, 7896};
    findNumbers(num);
  }
  public static int findNumbers(int[] nums) {

    int counter = 0;
    for (int num : nums) {
      int digitCounter = 0;
      while (num > 0) {
        num = num / 10;
        digitCounter++;
      }
      if (digitCounter % 2 == 0) {
        counter++;
      }
    }
    return counter;


  }

}
