public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return traversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean traversal(TreeNode root, long min, long max){
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
