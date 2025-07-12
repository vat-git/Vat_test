package december.seven;

import java.util.*;

public class TrolleyProblem {

    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }
    public static int openLock(String[] deadends, String target) {

        String start = "0000";
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> isVisited = new HashSet<>();
        int levelCounter = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                String currentKey = queue.poll();
                if (deads.contains(currentKey)) {
                    break;
                }
                if (target.equals(currentKey)) {
                    return levelCounter;
                }

                for (int i = 0; i < currentKey.length(); i++) {

                    char currentChar = currentKey.charAt(i);
                    String forward = currentKey.substring(0, i)+ (currentChar == '9' ? 0 : currentChar - '0' + 1) + currentKey.substring(i + 1);
                    String revers = currentKey.substring(0, i) + (currentChar == '0' ? 9 : currentChar - '0' - 1) + currentKey.substring(i + 1);

                    if (!deads.contains(forward) && !isVisited.contains(forward)) {
                        System.out.println(forward);
                        queue.offer(forward);
                        isVisited.add(forward);
                    }
                    if (!deads.contains(revers) && !isVisited.contains(revers)) {
                        System.out.println(revers);
                        queue.offer(revers);
                        isVisited.add(revers);
                    }

                }
                queueSize--;
         }
            levelCounter++;
        }
        return -1;
    }

}
