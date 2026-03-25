public class sumNumbers {
    static class Solution {
        public static int sumNumbers(TreeNode root) {
            return traversal(root, 0);
        }

        public static int traversal(TreeNode node, int sum){
            if(node== null) return 0;
            if(node.left == null && node.right == null){
                sum *= 10;
                sum += node.val;
                return sum;
            }
            sum *= 10;
            sum += node.val;
            int leftSum = traversal(node.left, sum);
            int rightSum = traversal(node.right, sum);
            return leftSum + rightSum;
        }
    }
}
