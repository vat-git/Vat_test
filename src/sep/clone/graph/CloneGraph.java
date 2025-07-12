package sep.clone.graph;

import java.util.*;

public class CloneGraph {


    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {
        if (node ==null) {
            return null;
        }
        Map<Integer,Node> nodeMap = new HashMap<>();
        return copyGraph(node, nodeMap);
}

    private static Node copyGraph(Node node, Map<Integer, Node> nodeMap) {
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node newNode = new Node(node.val);
        nodeMap.put(newNode.val, newNode);
        if (!node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(copyGraph(neighbor, nodeMap));
            }
        }
        return newNode;
    }
    }
