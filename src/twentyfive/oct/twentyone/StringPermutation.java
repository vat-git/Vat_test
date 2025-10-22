package twentyfive.oct.twentyone;

import java.util.Arrays;

public class StringPermutation {

    public boolean checkInclusion(String s1, String s2) {

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (char c : s1.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = s1.length();
        int startIndex = 0;
        for (int i = 0; i < sCount.length; i++) {
            char c = s2.charAt(i);
            sCount[c - 'a']++;
            if (i - startIndex +1> windowSize) {
                sCount[s2.charAt(startIndex) - 'a']--;
                startIndex++;
            }
            if (Arrays.equals(sCount, pCount)) {
                return true;
            }
        }
        return true;
    }
}
