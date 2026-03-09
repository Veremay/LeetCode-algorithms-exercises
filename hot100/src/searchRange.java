public class searchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] res = Solution.searchRange(nums, target);
        for(int num: res){
            System.out.print(num + " ");
        }

    }

    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            // nums依然是有序的
            // 分为两步：找左边界 and 找右边界
            int left = 0, right = nums.length-1;
            // 找左边界
            // 当找到一个时，持续收缩右边界，最终 left 指向第一个大于等于 target 的位置
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] >= target){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
            int leftBound = left;

            left = 0;
            right = nums.length-1;
            // 找右边界
            // 当找到一个时，持续收缩左边界，最终 right 指向最后一个小于等于 target 的位置
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] <= target){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
            int rightBound = right;

            // 如果左边界有效且对应元素等于 target，则返回左右边界，否则返回 [-1, -1]
            if (leftBound <= rightBound && rightBound < nums.length && nums[leftBound] == target) {
                return new int[]{leftBound, rightBound};
            }
            return new int[]{-1, -1};
        }
    }
}
