package twentyfive.may.fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

 static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }


  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> copiedMap = new HashMap<>();
    copiedMap.put(node.val, new Node(node.val, new ArrayList<>()));
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      Node currentCopiedNode = copiedMap.get(poll.val);
      for (Node neighbor : poll.neighbors) {
        if (!copiedMap.containsKey(neighbor.val)) {
          copiedMap.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
        }
        currentCopiedNode.neighbors.add(copiedMap.get(neighbor.val));
        queue.add(neighbor);
        }
      }
    return copiedMap.get(node.val);
    }

}
