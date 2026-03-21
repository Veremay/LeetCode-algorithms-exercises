public class productExceptSelf {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int[] productExceptSelf(int[] nums) {
            int[] leftMulti = new int[nums.length];
            int left = 1;
            leftMulti[0] = left;
            for (int i = 1; i < leftMulti.length; i++) {
                left *= nums[i-1];
                leftMulti[i] = left;
            }

            int[] rightMulti = new int[nums.length];
            int right = 1;
            rightMulti[rightMulti.length - 1] = right;
            for (int i = rightMulti.length - 2; i >= 0; i--) {
                right *= nums[i+1];
                rightMulti[i] = right;
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = leftMulti[i] * rightMulti[i];
            }

            return res;
        }
    }
}
