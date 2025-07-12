package october;

import java.util.HashSet;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(

                "pqswwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        while (bPointer < charArray.length) {

            if (!hashSet.contains(charArray[bPointer])) {
                hashSet.add(charArray[bPointer]);

                max = Math.max(max, hashSet.size());
            }else{
                hashSet.remove(charArray[aPointer]);
                aPointer++;
            }
            bPointer++;

        }
        return max;


    }
    }
