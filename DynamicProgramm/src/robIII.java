public class robIII {
    public int robIII(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }

    int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
