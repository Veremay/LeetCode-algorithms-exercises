public class isSymmetric {
    public static void main(String[] args) {

    }

    static class Solution{
        static boolean isSymmetric(TreeNode root) {
            if(root == null) return true;

            return compare(root.left, root.right);
        }

        static boolean compare(TreeNode left, TreeNode right){
            // 有一方或更多为空
            if(left == null && right == null) return true;
            else if(left != null && right == null) return false;
            else if(left == null && right != null) return false;
            // 都不为空
            // 再排除数值不相同的情况
            else if (left.val != right.val) return false;
            else{
                // 此时就是：左右节点都不为空，且数值相同的情况
                // 此时才做递归，做下一层的判断
                boolean inner = compare(left.right, right.left);
                boolean outer = compare(left.left, right.right);
                return inner && outer;
            }
        }
    }
}
