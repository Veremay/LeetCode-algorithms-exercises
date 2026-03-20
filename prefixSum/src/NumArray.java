public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i-1];
            this.nums[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return nums[right + 1] - nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
    }
}
