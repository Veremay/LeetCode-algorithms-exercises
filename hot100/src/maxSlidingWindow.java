import java.util.Arrays;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        System.out.println(Arrays.toString(Solution.maxSlidingWindow(nums, k)));
    }

    static class Solution{
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int max = Integer.MIN_VALUE;
            int[] result = new int[nums.length - k + 1];
            if(k == 1 || nums.length == 1) return nums;

            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                max = Math.max(max, nums[right]);

                if(right - left + 1 == k){
                    result[left] = max;
                    left ++;

                    if(nums[left - 1] == max){
                        int temp = nums[left];
                        for (int i = left; i <= right; i++) {
                            temp = Math.max(temp, nums[i]);
                        }
                        max = temp;
                    }


                }
            }

            return result;
        }
    }
}
