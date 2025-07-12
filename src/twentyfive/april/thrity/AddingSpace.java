package twentyfive.april.thrity;

public class AddingSpace {

  public static void main(String[] args) {
    int[] spaces = {0,1,2,3,4,5,6};
    System.out.println(addSpaces("spacing", spaces));

  }


  public static String addSpaces(String s, int[] spaces) {
    StringBuilder sb = new StringBuilder();
    int spaceIdx = 0;

    // Iterate through each index of the original string
    for (int i = 0; i < s.length(); i++) {
      // Check if we need to add a space at this index
      while (spaceIdx < spaces.length && spaces[spaceIdx] == i) {
        sb.append(" ");
        spaceIdx++;
      }
      sb.append(s.charAt(i));
    }

    return sb.toString();
  }

}
