/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */


public class searchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 12;

        int[] result = searchRange(nums, target);

        for (int i : result) {
            System.out.println(i);

        }
    }

    public static int[] searchRange(int[] nums, int target) {
    /**
     * 分别寻找左边界和右边界，计算出来的边界不包含target的边界
     */
    int leftBorder = getLeftBorder(nums, target);
    int rightBorder = getRightBorder(nums, target);

    // 仔细想想下面三种情况
        //情况一
        // target 在数组范围的右边或者左边
        if(leftBorder == -2 || rightBorder == -2){
            return new int[]{-1, -1};
        }
        //情况三
        // target 在数组范围中，且数组中存在target
        else if(rightBorder - leftBorder > 1){
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        //情况二
        // target 在数组范围中，且数组中不存在target
        else{
            return new int[]{-1, -1};
        }

    }

    public static int getRightBorder(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        int rightBorder = -2; //记录找不到的情况

        while(left <= right) {
            int mid = (left + right) / 2;
            if (target < (nums[mid])) {
                right = mid - 1;
            }
            if (target >= (nums[mid])) {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public static int getLeftBorder(int[] nums, int target){
        // 计算出来的右边界不包含target的右边界
        int left = 0;
        int right = nums.length - 1;

        int leftBorder = -2; //记录找不到的情况

        while(left <= right) {
            int mid = (left + right) / 2;
            if (target <= (nums[mid])) {
                right = mid - 1;
                leftBorder = right;
            }
            if (target > (nums[mid])) {
                left = mid + 1;

            }
        }
        return leftBorder;
    }


}
