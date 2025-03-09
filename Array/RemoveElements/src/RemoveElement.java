public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        // 暴力解法
        /*
        int len = nums.length;
        for (int i = 0; i < len; i++) { // 注意这里是小于会变化数组大小，而不是nums.length（数组地址空间实际大小）
            if(nums[i] == val){
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j-1] = nums[j];
                }
                i--; //因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                len--;
            }
        }

        return len;

         */

        // 快慢指针
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){ // 这个不等于很妙
                nums[slowIndex] = nums[i];
                slowIndex++;
            }

        }

        return slowIndex;

        /*
        int slowindex = 0;
        for(int fastindex = 0; fastindex < nums.length; fastindex++){
            if(nums[fastindex] != val){
                nums[slowindex] = nums[fastindex];
                slowindex ++;
            }
        }
        return slowindex;
         */
    }

}
