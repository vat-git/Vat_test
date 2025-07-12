package twentyfive.may.four;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {


  public static void main(String[] args) {
    String input = "abcdbehj";
    System.out.println(lengthOfLongestSubstring(input));
  }

  public static int lengthOfLongestSubstring(String s) {
    char[] charArray = s.toCharArray();
    int aPointer=0;
    int bPointer=0;
    int currentLongestLength = 0;
    Set<Character> characterSet = new HashSet<>();
    while (bPointer < charArray.length) {
      if (!characterSet.contains(charArray[bPointer])) {
        characterSet.add(charArray[bPointer]);
        currentLongestLength = Math.max(characterSet.size(), currentLongestLength);
        bPointer++;
      }else {
        characterSet.remove(charArray[aPointer]);
        aPointer++;
      }
    }
    return currentLongestLength;
  }

}
