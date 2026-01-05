public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    // 左闭右闭区间[left, right]
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + ((right - left) >> 1);  // (left + right) / 2 在 left 和 right 都很大时可能溢出; left + ((right - left) >> 1) 先做减法，避免了直接相加的溢出风险
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
