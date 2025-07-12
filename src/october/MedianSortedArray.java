package october;

public class MedianSortedArray {

    public static void main(String[] args) throws Exception {
        int[] first = {1, 2};
        int[] second = {3,4};
        System.out.println(findMedianSortedArrays(first, second));
    }

    public static double findMedianSortedArrays(int[] xArray, int[] yArray) throws Exception {


        if (xArray.length > yArray.length) {
            return findMedianSortedArrays(yArray, xArray);
        }

        int x = xArray.length;
        int y = yArray.length;


        int high = x;
        int low = 0;

        while (high >= low) {

            int partX = (high + low) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int maxLeftX = partX == 0 ? Integer.MIN_VALUE : xArray[partX - 1];
            int minRightX = partX == x ? Integer.MAX_VALUE : xArray[partX];


            int maxLeftY = partY == 0 ? Integer.MIN_VALUE : yArray[partY - 1];
            int minRightY = partY == y ? Integer.MAX_VALUE : yArray[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRightY) {
                high = partX-1;
            } else {
                low = partX + 1;
            }

        }
        return -1;
    }
}
