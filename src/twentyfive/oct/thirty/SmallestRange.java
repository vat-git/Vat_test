package twentyfive.oct.thirty;

public class SmallestRange {


    public static void main(String[] args) {
        int[] input1 = {5, 36, 56, 88, 122};
        int[] input2 = {2, 65, 78, 92, 151};

        int apointer = 0;
        int bpointer = 0;
        int startRange = -1;
        int endRange = -1;
        int minrange = Integer.MAX_VALUE;
        while (apointer < input1.length && bpointer < input2.length) {
            int firstInput = input1[apointer];
            int secondInput = input2[bpointer];

            int high = Math.max(firstInput, secondInput);
            int min = Math.min(firstInput, secondInput);

        }
        System.out.println(startRange);
        System.out.println(endRange);

    }
}
