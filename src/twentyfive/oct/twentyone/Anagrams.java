package twentyfive.oct.twentyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        System.out.println(findAnagrams(s, "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {


        int[] pCount = new int[26];
        int[] sCount = new int[26];

        if (p == null || s == null || p.isBlank() || s.isBlank()) {
            return new ArrayList<>();
        }

        int windowSize = p.length();

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {

            char charAt = s.charAt(i);
            sCount[charAt - 'a']++;
            if (startIndex + windowSize <= i) {
                sCount[s.charAt(i - windowSize)-'a']--;
                startIndex++;
            }

            if (Arrays.equals(sCount,pCount)) {
                result.add(startIndex);
            }


        }

        return result;

    }


}
