package twentyfive.oct.tenth;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {


    public static void main(String[] args) {
        int[] inputArray = {1, 4, 3, 2, 6, 99, 34, 5};
        findKthLargestElmenet(inputArray,4);
    }

    private static void findKthLargestElmenet(int[] inputArray, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i : inputArray) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        System.out.println(maxHeap.poll());

    }
}
