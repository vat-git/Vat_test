package twentyfive.july.twelve;

import com.sun.source.tree.NewArrayTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchduleKhans {

  public static void main(String[] args) {
    int[][] test = {{1, 0}};
    canFinish(2, test);
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer,List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      graph.get(prerequisite[1]).add(prerequisite[0]);
    }

    int[] inDegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      for (Integer integer : graph.get(i)) {
        inDegree[integer]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    int courseCompleted = 0;
    while (!queue.isEmpty()) {
      Integer polled = queue.poll();
      courseCompleted++;
      for (Integer i : graph.get(polled)) {
        inDegree[i]--;
        if (inDegree[i] == 0) {
          queue.add(i);
        }
      }
    }
    return courseCompleted == numCourses;

  }


  public static boolean canFinish1(int numCourses, int[][] prerequisites) {
    // Create adjacency list representation
    List<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }

    // Build the graph from prerequisites
    for (int[] prerequisite : prerequisites) {
      int course = prerequisite[0];
      int prereq = prerequisite[1];
      graph[prereq].add(course); // prereq -> course
    }

    // Calculate in-degrees
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      for (int neighbor : graph[i]) {
        inDegree[neighbor]++;
      }
    }

    // Add courses with no prerequisites to queue
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    // Process courses in topological order
    int coursesCompleted = 0;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      coursesCompleted++;

      // Reduce in-degree of dependent courses
      for (int neighbor : graph[current]) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    // If all courses can be completed, return true
    return coursesCompleted == numCourses;
  }

}
