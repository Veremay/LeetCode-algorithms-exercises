public class search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(Solution.search(nums, target));
    }

    static class Solution {
        public static int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 判断左半部分是否有序
                if (nums[left] <= nums[mid]) { // 左半部分有序
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1; // target 在左半部分
                    } else {
                        left = mid + 1;  // target 在右半部分
                    }
                } else { // 右半部分有序
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;  // target 在右半部分
                    } else {
                        right = mid - 1; // target 在左半部分
                    }
                }
            }
            return -1;
        }
    }
}
