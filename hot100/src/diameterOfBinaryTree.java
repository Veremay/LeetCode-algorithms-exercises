public class diameterOfBinaryTree {
    public static void main(String[] args) {

    }
    static int height = 0;
    static int diameterOfBinaryTree(TreeNode root) {
        countHeight(root);
        return height;
    }

    static int countHeight(TreeNode node){
        if(node == null) return 0;
        int leftHeight = countHeight(node.left);
        int rightHeight = countHeight(node.right);
        height = Math.max(height, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
