public class removeDuplicates {
    /*
    给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
    元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[i];
            }
        }
        return slowIndex + 1;
    }
}
