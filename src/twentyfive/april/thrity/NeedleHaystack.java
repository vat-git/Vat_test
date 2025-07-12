package twentyfive.april.thrity;

public class NeedleHaystack {


  public static void main(String[] args) {
    System.out.println(strStr("a", "a"));
  }

  public static int strStr(String haystack, String needle) {

    int counter=0;
    while(counter<haystack.length()){
      if (haystack.charAt(counter) == needle.charAt(0)) {
        int length = needle.length();
        if(counter+ length <=haystack.length()) {
          String substring = haystack.substring(counter, counter+length);
          if (substring.equals(needle)) {
            return counter;
          }
        }
      }
      counter++;
    }
    return -1;

  }

}
