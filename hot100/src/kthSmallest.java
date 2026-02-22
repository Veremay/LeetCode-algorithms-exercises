public class kthSmallest {
    public static void main(String[] args) {

    }

    class Solution{
        int count = 0;
        int res = -1;
        private int kthSmallest(TreeNode root, int k) {
            // 二叉搜索树有一个非常重要的性质：中序遍历的结果是递增的序列
            // 第 k 小的元素就是中序遍历结果中的第 k 个元素
            traversal(root, k);
            return res;
        }

        private void traversal(TreeNode node, int k){
            if(node == null) return;
            traversal(node.left, k);
            count ++;
            if(count == k) res = node.val;
            traversal(node.right, k);
        }
    }
}
