public class lowestCommonAncestorBST {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        // 如果 cur.val 同时小于 p.val和q.val，那么就应该向右遍历（目标区间在右子树）。
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorBST(root.right, p, q);
        }
        // 如果 cur.val 同时大于p.val和q.val，那么就应该向左遍历（目标区间在左子树）。
        else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorBST(root.left, p, q);
        }
        // 如果cur.val在两个val之间，那么就说明cur是最近公共祖先
        else {
            return root;
        }

    }

    // 迭代法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
