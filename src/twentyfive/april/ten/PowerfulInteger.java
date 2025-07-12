package twentyfive.april.ten;

public class PowerfulInteger {

  public static void main(String[] args) {
    System.out.println(numberOfPowerfulInt(20, 1159, 5, "20"));
  }
  public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {

    int i = Integer.parseInt(s);
    int number = i;
    int digitCount = 0;
    while (number > 0) {
      number = number / 10;
      digitCount++;
    }

    int toBeSummedValue = 1;

    while (digitCount > 0) {
      toBeSummedValue = toBeSummedValue * 10;
      digitCount--;
    }
    int counter = 0;
    if (i <= finish && i >= start) {
      counter++;
    }
    int maxNumber = 0;
    int multiplier = toBeSummedValue;
    while (maxNumber <= finish) {
      int multi = toBeSummedValue;
      boolean skip=false;
      while (multi > 0) {
        if (multi%10>limit) {
          skip = true;
          break;
        }
        multi = multi / 10;
      }
      if (skip) {
        toBeSummedValue = toBeSummedValue + multiplier;
        continue;
      }

      int toBeSummedForThisIteration = toBeSummedValue + i;
      if (toBeSummedForThisIteration <= finish && toBeSummedForThisIteration >= start) {
        counter++;
      }
      maxNumber = toBeSummedForThisIteration;
      toBeSummedValue = toBeSummedValue + multiplier;
    }
    return counter;
  }

}
