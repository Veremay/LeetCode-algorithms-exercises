public class buildTree {
    public static void main(String[] args) {

    }

    class Solution{
        private TreeNode buildTree(int[] preorder, int[] inorder) {
            // 终止条件：前序遍历的数组size为0，意味着没节点了，是空节点
            if(preorder.length == 0) return null;
            // 前序遍历第一个为root
            TreeNode root = new TreeNode(preorder[0]);

            // 在中序遍历中找到
            int rootIndex = -1;
            for (int i = 0; i < inorder.length; i++) {
                if(inorder[i] == preorder[0]){
                    rootIndex = i;
                    break;
                }
            }

            // inorder切分左右
            int[] leftInorder = new int[rootIndex];
            for (int i = 0; i < rootIndex; i++) {
                leftInorder[i] = inorder[i];
            }
            int[] rightInorder = new int[inorder.length - rootIndex - 1];
            for (int i = rootIndex + 1; i < inorder.length; i++) {
                rightInorder[i - rootIndex - 1] = inorder[i];
            }

            // preorder切分左右
            int[] leftPreorder = new int[leftInorder.length];
            for (int i = 1; i <= leftPreorder.length; i++) {
                leftPreorder[i - 1] = preorder[i];
            }
            int[] rightPreorder = new int[rightInorder.length];
            for (int i = leftPreorder.length + 1; i < preorder.length; i++) {
                rightPreorder[i - leftPreorder.length - 1] = preorder[i];
            }

            // 开始递归
            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);

            return root;
        }
    }
}
