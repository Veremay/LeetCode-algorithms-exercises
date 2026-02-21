public class isValidBST {
    public static void main(String[] args) {

    }

    class Solution{
        private boolean isValidBST(TreeNode root) {
            long min = Long.MIN_VALUE, max = Long.MAX_VALUE;
            return traversal(root, min, max);

        }

        private boolean traversal(TreeNode root, long min, long max){
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
