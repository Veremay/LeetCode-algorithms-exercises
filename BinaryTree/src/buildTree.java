public class buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, postorder);
    }

    public TreeNode traversal(int[] inorder, int[] postorder){
        // 终止条件：后序遍历的数组size为0，意味着没节点了，是空节点
        if(postorder.length == 0) return null;
        // 后序数组里最后一个节点是当前的根节点
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        // 如果后序数组里只有一个节点，说明这个节点是叶子节点
        if(postorder.length == 1) return root;

        // 开始在中序数组里找当前根节点，进行左右子树的切割
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        // 开始切中序数组，得到左中序数组和右中序数组
        int[] inorderLeft = new int[index];
        int[] inorderRight = new int[inorder.length - index - 1];
        for (int i = 0; i < index; i++) {
            inorderLeft[i] = inorder[i];
        }
        for (int i = index + 1; i < inorder.length; i++) {
            inorderRight[i - index - 1] = inorder[i];
        }
        // 开始切后序数组，得到左后序数组和右后序数组，两个数组的长度分别和中序的是一样的
        int[] postorderLeft = new int[inorderLeft.length];
        int[] postorderRight = new int[inorderRight.length];
        for (int i = 0; i < inorderLeft.length; i++) {
            postorderLeft[i] = postorder[i];
        }
        for (int i = inorderLeft.length; i < postorder.length - 1; i++) {
            postorderRight[i - inorderLeft.length] = postorder[i];
        }

        // 开始递归
        root.left = traversal(inorderLeft,postorderLeft);
        root.right = traversal(inorderRight, postorderRight);

        return root;
    }
}
