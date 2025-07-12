package october.tree;

public class MirrorTree {


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }


    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val == right.val) {
                return isMirror(left.left, right.right) && isMirror(left.right, right.left);
            }
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        return false;
    }
}
