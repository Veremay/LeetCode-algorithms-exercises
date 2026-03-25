public class hasPathSum {
    static class Solution {
        public static boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            int sum = 0;
            return traversal(root, sum, targetSum);
        }

        private static boolean traversal(TreeNode node, int sum, int targetSum){
            if (node == null) return false;               // 空节点直接返回 false
            sum += node.val;
            // 叶子节点判断
            if (node.left == null && node.right == null) {
                return sum == targetSum;
            }
            boolean left = traversal(node.left, sum, targetSum);
            boolean right = traversal(node.right, sum, targetSum);
            return left || right;
        }
    }
}
