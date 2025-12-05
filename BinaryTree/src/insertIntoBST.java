public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null){
            root = node;
            return root;
        }

        if(root.val > val){
            root.left = insertIntoBST(root.left, val); // 这里用root.left接住，还是有很多便利的。
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
