public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums);
    }

    public TreeNode traversal(int[] nums){
        // 当数组为空，说明没有节点了
        if(nums.length == 0) return null;

        // 找到最大值，作为根节点
        int maxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);

        // 如果数组只有一个值，那这个值就是叶子节点
        if(nums.length == 1) return root;

        // 开始切分左子树
        int[] left = new int[maxIndex];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        // 开始切分右子树
        int[] right = new int[nums.length - maxIndex - 1];
        for (int i = maxIndex + 1; i < nums.length; i++) {
            right[i - maxIndex - 1] = nums[i];
        }

        root.left = traversal(left);
        root.right = traversal(right);

        return root;
    }
}
