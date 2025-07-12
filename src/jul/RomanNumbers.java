package jul;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class RomanNumbers {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {


        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char[] charArray = s.toCharArray();
        int index = s.length() - 1;

        while (index >= 0) {
            int numberToAdd = map.get(charArray[index]);
            if (index - 1 >= 0) {
                int preNum = map.get(charArray[index - 1]);
                if (preNum < numberToAdd) {
                    numberToAdd = numberToAdd - preNum;
                    index--;
                }
            }
            result += numberToAdd;
            index--;
        }
        return result;

    }

}
