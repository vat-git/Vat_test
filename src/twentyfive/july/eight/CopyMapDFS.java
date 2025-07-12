package twentyfive.july.eight;

import java.nio.channels.ConnectionPendingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.swing.undo.CannotUndoException;
import sep.clone.graph.Node;

public class CopyMapDFS {

  public static Node cloneGraph(Node node) {

    if (node==null) {
      return null;
    }

    Map<Integer, Node> copiedNodes = new HashMap<>();
    return copyDFS(node, copiedNodes);


  }

  private static Node copyDFS(Node node, Map<Integer, Node> copiedNodes) {
    if (copiedNodes.containsKey(node.val)) {
      return copiedNodes.get(node.val);
    }

    copiedNodes.put(node.val, new Node(node.val, new ArrayList<>()));

    for (Node neighbor : node.neighbors) {

        copiedNodes.get(node.val).neighbors.add(copyDFS(neighbor, copiedNodes));

    }
    return copiedNodes.get(node.val);
  }

}
