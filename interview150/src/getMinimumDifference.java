public class getMinimumDifference {
    static class Solution{
        // 定义为全局变量
        static int min = Integer.MAX_VALUE;
        static TreeNode prev = null;
        public static int getMinimumDifference(TreeNode root) {
            // 按照 中序遍历 (In-order Traversal) 的顺序访问 BST
            // 会发现得到的节点值序列是 从小到大严格递增的
            traversal(root);
            return min;
        }

        private static void traversal(TreeNode node){
            if(node == null) return;
            traversal(node.left);
            if(prev != null){
                min = Math.min(min, node.val - prev.val);
            }
            prev = node;
            traversal(node.right);
        }
    }
}
