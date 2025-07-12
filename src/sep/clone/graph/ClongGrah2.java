package sep.clone.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClongGrah2 {

    public  Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneNode(node, map);
    }

    private  Node cloneNode(Node node, Map<Integer, Node> map) {
        if (node==null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneNode(neighbor, map));
        }
        return newNode;
    }
}
