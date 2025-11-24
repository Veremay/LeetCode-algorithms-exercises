public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        // 首先排除空节点的情况
        if(left == null && right == null) return true;
        else if (left != null && right == null) return false;
        else if (left == null && right != null) return false;
        // 排除了空节点，再排除数值不相同的情况
        else if (left.val != right.val) return false;
        else{
            // 此时就是：左右节点都不为空，且数值相同的情况
            // 此时才做递归，做下一层的判断
            boolean outside = compare(left.left, right.right);  // 外侧，左子树：左、 右子树：右
            boolean inside = compare(left.right, right.left);   // 内侧，左子树：左、 右子树：右
            boolean result = outside && inside;
            return result;
        }

    }
}
