package december.eight;

public class Pallindrome {

    public static void main(String[] args) {
        isPalindrome(121);
    }
    public static boolean isPalindrome(int x) {
        int orginal = x;
        int reverse = 0;
        while (x > 0) {
            int mod = x % 10;
            reverse = reverse * 10 + mod;
            x = x / 10;
        }
        if (reverse == orginal) {
            return true;
        }
        return false;
    }

}
