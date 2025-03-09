/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
时间复杂度为O(N)
 */
public class sortedSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, 0, 3, 10};
        int[] nums_new = sortedSquares(nums);

        for (int i = 0; i < nums_new.length; i++) {
            System.out.println(nums_new[i]);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;

        while( left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                squares[position] = nums[left] * nums[left];
                left ++;
            }else{
                squares[position] = nums[right] * nums[right];
                right --;
            }
            position --;
        }
        return squares;
    }
}
