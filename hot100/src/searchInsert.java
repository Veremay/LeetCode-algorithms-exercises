public class searchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;
        System.out.println(Solution.searchInsert(nums, target));
    }

    static class Solution {

        public static int searchInsert(int[] nums, int target) {
            // nums为 无重复元素 的 升序 排列数组

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2; // 防止溢出
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1; // 目标在右半部分
                } else {
                    right = mid - 1; // 目标在左半部分
                }
            }
            // 循环结束时 left 指向第一个大于 target 的位置，即插入位置
            return left;

            // 递归太复杂了
//            if(target < nums[0]) return 0;
//            else if (target > nums[nums.length-1]) return nums.length;
//            else return search(nums, target, 0, nums.length-1);
        }

        private static int search(int[] nums, int target, int left, int right){
            int res = -1;
            int middle = (left + right) / 2;
            if(nums[middle] == target) return middle;
            if(nums[middle] < target){
                res = search(nums, target, middle, right);
            }
            if(nums[middle] > target){
                res = search(nums, target, left, middle);
            }

            return res;
        }
    }
}
