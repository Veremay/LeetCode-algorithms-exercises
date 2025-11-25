public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        int result = getHeight(root);
        if(result == -1) return false;
        else return true;

        // 上面也可以写成：
        // return getHeight(root) == -1 ? false : true;
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        if(leftHeight == -1){ // 如果左子树不是平衡二叉树
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }

        boolean isBalanced = Math.abs(leftHeight - rightHeight) < 1;

        int result;
        if (Math.abs(leftHeight - rightHeight) > 1) {  // 中
            result = -1;
        } else {
            result = 1 + Math.max(leftHeight, rightHeight); // 以当前节点为根节点的树的最大高度
        }
        return result;

        // 上面可以直接写成：
        // return Math.abs(leftHeight - rightHeight) > 1 ?
        //           -1 : 1 + Math.max(leftHeight, rightHeight);

    }
}
