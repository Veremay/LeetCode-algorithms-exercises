public class rotate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Solution.rotate(nums, 3);

    }

    static class Solution {
        // 翻转整个数组：[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        // 翻转前 k 个：[5,6,7, 4,3,2,1] (假设 $k=3$)
        // 翻转后 n-k 个：[5,6,7, 1,2,3,4]
        public static void rotate(int[] nums, int k){
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private static void reverse(int[] nums, int left, int right){
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }

        /**
        // 错误解法
        // 1. 致命伤：k > nums.length 的情况 (所以要k %= n) 取模
        // 2. 如果 k > n-k（即旋转步数超过数组一半），当你修改 nums[i] 时，可能会覆盖掉后面循环还需要用到的原始数据

        public static void rotate(int[] nums, int k) {
            int[] temp = new int[nums.length - k]; // 记录下未被旋转的头部
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[i] = nums[i + nums.length - k];
            }

            for (int i = k; i < nums.length; i++) {
                nums[i] = temp[i-k];
            }

        }
         **/
    }
}
