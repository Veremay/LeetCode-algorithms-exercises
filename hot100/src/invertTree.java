public class invertTree {
    public static void main(String[] args) {

    }

    static class Solution{
        private static TreeNode invertTree(TreeNode root){
            if(root == null) return null;
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;

            return root;
        }
    }
}
