public class maxDepth {
    public static void main(String[] args) {
        // 使用 Integer 数组以支持 null
        Integer[] rootArray = {3, 9, 20, null, null, 15, 7};

        TreeNode root = constructTree.constructTree(rootArray);

        System.out.println(Solution.maxDepth(root));
    }

    static class Solution {
        public static int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;

            return Math.max(leftDepth, rightDepth);
        }
    }

}
