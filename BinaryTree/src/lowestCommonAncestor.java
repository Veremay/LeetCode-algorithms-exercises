public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 其实这里返回什么没关系，只要不为空就行。标记找到了。
        // 但题目接收的是TreeNode，并且考虑自己本身就是公共祖先的情况，所以返回TreeNode方便一些
        if(root == null) return null;
        // 找到了p或者q就返回，此时也包括自己本身就是最近公共祖先的情况
        if(root == p || root == q) return root;

        // 因为是从底向上找，所以用后序遍历合适
        // 保存递归调用的返回值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 对root进行处理
        // 如果返回的左右子树不为空，说明在左右子树找到了p,q，此时root就是最近公共祖先
        if(left != null && right != null) return root;
        // 如果只返回了一侧，说明只在一侧找到了p或者q，说明最近公共祖先还在上面，还得往上
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return null;
    }
}
