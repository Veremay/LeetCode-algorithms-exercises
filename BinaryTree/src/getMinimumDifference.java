public class getMinimumDifference {
    private int result = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) return;

        // 左
        traversal(cur.left);

        // 中
        if (pre != null) {
            result = Math.min(result, cur.val - pre.val);
        }
        pre = cur;

        // 右
        traversal(cur.right);
    }
}
