package twentyfive.may.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import twentyfive.may.sixth.CloneGraph.Node;

public class CloneDFS {



  public Node cloneGraph(Node node) {
    Map<Integer, Node> visited = new HashMap<>();
    return dfs(node, visited);
  }

  private Node dfs(Node node, Map<Integer, Node> visited) {
    if (visited.containsKey(node)) {
      return visited.get(node);
    }

    Node copiedNode = new Node(node.val, new ArrayList<>());
    for (Node neighbor : node.neighbors) {
      copiedNode.neighbors.add(dfs(neighbor, visited));
    }
    return node;
  }

}
