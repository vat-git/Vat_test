package twentyfive.may.sixth;


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
    if (node==null) {
      return null;
    }
    Map<Integer, Node> visited = new HashMap<>();
    Queue<Node> integerQueue = new LinkedList<>();
    visited.put(node.val, new Node(node.val, new ArrayList<>()));
    integerQueue.add(node);
    while (!integerQueue.isEmpty()) {
      Node currentNode = integerQueue.poll();
      Node node1 = visited.get(currentNode.val);
      for (Node neighbor : currentNode.neighbors) {
        if (!visited.containsKey(neighbor.val)) {
          visited.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
          integerQueue.add(neighbor);
        }
        node1.neighbors.add(visited.get(neighbor.val));
      }
    }
    return visited.get(node.val);

  }

}
