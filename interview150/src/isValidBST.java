public class isValidBST {
    static class Solution{
        public static boolean isValidBST(TreeNode root){
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            return traversal(root, min, max);
        }

        private static boolean traversal(TreeNode root, int min, int max){
            if(root == null) return true;
            // 检查当前节点值是否在允许范围内
            if (root.val <= min || root.val >= max) {
                return false;
            }

            boolean left = traversal(root.left, min, root.val);
            boolean right = traversal(root.right, root.val, max);

            return left && right;
        }
    }
}
