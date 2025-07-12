//package october.tree;
//
//public class SortedArrayToTree {
//
//
//    public static void main(String[] args) {
//        int[] test = {1, 2, 3};
//        sortedArrayToBST(test);
//    }
//
//    public static TreeNode sortedArrayToBST(int[] nums) {
//
//
//        int mid = nums.length / 2;
//        TreeNode node = new TreeNode();
//        node.val = nums[mid];
//        TreeNode currentNode = node;
//        int leftStart = mid;
//        int rightStart = mid;
//
//        while (leftStart > 0) {
//            TreeNode newNode = new TreeNode();
//            newNode.val= nums[--leftStart];
//            currentNode.left = newNode;
//            currentNode = newNode;
//        }
//        currentNode = node;
//        while (rightStart< nums.length
//                < nums[nums.length - 1]) {
//            TreeNode newNode = new TreeNode();
//            newNode.val= nums[mid];
//            currentNode.left = newNode;
//            currentNode = newNode;
//        }
//
//    }
//}
