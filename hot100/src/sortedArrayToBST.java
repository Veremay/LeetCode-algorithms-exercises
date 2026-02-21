public class sortedArrayToBST {
    public static void main(String[] args) {

    }

    static class Solution{
        private static TreeNode sortedArrayToBST(int[] nums) {
            TreeNode root = traversal(nums, 0, nums.length - 1);
            return root;
        }

        // [left, right]
        private static TreeNode traversal(int[] nums, int left, int right){
            if(left > right) return null;

            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = traversal(nums, left, mid - 1);
            root.right = traversal(nums, mid + 1, right);
            return root;
        }
    }
}
