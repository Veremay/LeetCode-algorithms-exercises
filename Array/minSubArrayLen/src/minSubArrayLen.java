/*
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
如果不存在符合条件的子数组，返回 0 。
 */
public class minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int begin = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE; //初始值设定为最大值  很重要！！不能是nums.length

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while(sum >= target){ // 不用if，用while  nums=[1,1,1,100] target=100， if的话判断一次就结束了，而这个是个持续判断的过程
                //先看看是不是最小值
                int sumLen = end - begin + 1;
                if(sumLen <= result){
                    result = sumLen;
                }
                sum -= nums[begin];
                // 移动起始位置
                begin ++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
