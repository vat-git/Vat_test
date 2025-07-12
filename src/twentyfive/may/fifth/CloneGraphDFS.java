package twentyfive.may.fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraphDFS {

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
    return dfs(node, visited);



  }

  private Node dfs(Node node, Map<Integer, Node> visited) {
    if (visited.containsKey(node.val)) {
      return visited.get(node.val);
    }
    Node copiedNode = new Node(node.val, new ArrayList<>());
    visited.put(copiedNode.val, copiedNode);
    for (Node neighbor : node.neighbors) {
      copiedNode.neighbors.add(dfs(neighbor, visited));
    }
    return copiedNode;
  }

}
