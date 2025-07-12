package twentyfive.july.eight;

import com.sun.source.tree.NewArrayTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import sep.clone.graph.Node;

public class CopyMap {

  public static Node cloneGraph(Node node) {

    if (node == null) {
      return null;
    }
    Map<Integer, Node> copiedNodes = new HashMap<>();
    Node firstNode = new Node(node.val, new ArrayList<>());
    copiedNodes.put(firstNode.val, firstNode);

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node currentPoll = queue.poll();
      Node copiedNode = copiedNodes.get(currentPoll.val);

      for (Node neighbor : currentPoll.neighbors) {
        if (!copiedNodes.containsKey(neighbor.val)) {
          Node copiedNeighborNode = new Node(neighbor.val, new ArrayList<>());
          copiedNodes.put(copiedNeighborNode.val, copiedNeighborNode);
          queue.add(neighbor);
        }
        copiedNode.neighbors.add(copiedNodes.get(neighbor.val));
      }
    }
    return firstNode;
  }
}
