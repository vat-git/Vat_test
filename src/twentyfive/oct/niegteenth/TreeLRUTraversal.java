package twentyfive.oct.niegteenth;

import java.util.Stack;

public class TreeLRUTraversal {


        public String getDirections(TreeNode root, int startValue, int destValue) {

            StringBuilder pathToStart = new StringBuilder();
            findPath(root, startValue, pathToStart);

            StringBuilder pathToDest = new StringBuilder();

            findPath(root, destValue, pathToDest);

            int shortest = pathToStart.length() < pathToDest.length() ? pathToStart.length() : pathToDest.length();
            int commonAncestor = shortest;
            for (int i = 0; i < shortest; i++) {
                if (pathToStart.charAt(i) != pathToDest.charAt(i)) {
                    commonAncestor = i;
                    break;

                }


            }

            int remainingStart = pathToStart.length() - commonAncestor;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i <remainingStart; i++) {
                result.append("U");
            }

            result.append(pathToDest.subSequence(commonAncestor, pathToDest.length()));
            return result.toString();
        }

    private boolean findPath(TreeNode root, int destValue,StringBuilder resultStack) {

        if (root == null) {
            return false;
        }
        if (root.val == destValue) {
            return true;
        }

        //left
        resultStack.append("L");
        if (findPath(root.left, destValue, resultStack)) {
            return true;
        }
        resultStack.deleteCharAt(resultStack.length() - 1);

        resultStack.append("R");
        if (findPath(root.right, destValue, resultStack)) {
            return true;
        }
        resultStack.deleteCharAt(resultStack.length() - 1);

        return false;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
