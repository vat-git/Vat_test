package twentyfive.may.four;

public class CarPooling {

  public boolean carPooling(int[][] trips, int capacity) {

    int[] passengerCounts = new int[1001];
    for (int[] trip : trips) {
      int passengerCount = trip[0];
      int from = trip[1];
      int to = trip[2];
      passengerCounts[from] += passengerCount;
      passengerCounts[to] -= passengerCount;
    }

    int totalPassengerCount = 0;
    for (int passengerCount : passengerCounts) {
      totalPassengerCount += passengerCount;
      if (totalPassengerCount > capacity) {
        return false;
      }
    }
    return true;

  }

}
