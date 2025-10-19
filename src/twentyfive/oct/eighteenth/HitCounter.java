package twentyfive.oct.eighteenth;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> queue = new LinkedList<>();
     public HitCounter() {

        }

        public void hit(int timestamp) {
            queue.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty()&& queue.peek() < timestamp - 299) {
                queue.poll();
            }
            return queue.size();
        }
    }
