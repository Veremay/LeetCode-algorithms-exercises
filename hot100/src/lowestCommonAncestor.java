public class lowestCommonAncestor {
    public static void main(String[] args) {

    }

    class Solution{
        private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            // 找到了两个节点
            if(root == p || root == q) return root;

            // 因为要自底向上查找，所以用后序遍历
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // 说明两个子树都没有p和q
            if(left == null && right == null) return null;
            // 在其中一边找到，继续往上找
            else if(left != null && right == null) return left;
            else if(left == null && right != null) return right;
            // 两边找到了
            else return root;
        }
    }
}
