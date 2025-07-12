package jul;

public class Pallindrome {


    public static void main(String[] args) {
        System.out.println(isPalindrome(12));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int testNumber = x;
        int newNumber = 0;
        while (testNumber > 0) {
            int remaining = testNumber % 10;
            newNumber = (newNumber * 10) + remaining;
            testNumber = testNumber / 10;
        }
        if (newNumber == x) {
            return true;
        }
        return false;
    }
}
