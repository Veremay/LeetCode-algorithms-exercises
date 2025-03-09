public class searchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,8};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target){
        /**
         * 时间复杂度O(N)
         */
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(!(nums[i] < target)){
//                index = i;
//                break;
//            }
//        }
//
//        if(index == 0){
//            if(target > nums[nums.length - 1]){
//                index = nums.length;
//            }
//        }
//        return index;

        /**
         * 二分解法
         * 时间复杂度O(logN)
         */
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (target < (nums[mid])) {
                right = mid - 1;
            }
            if (target > (nums[mid])) {
                left = mid + 1;
            }
            if (target == (nums[mid])) {
                return mid;
            }
        }
        return left;
    }
}
