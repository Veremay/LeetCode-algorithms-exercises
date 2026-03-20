public class jump {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        System.out.println(Solution.jump(nums));
    }

    static class Solution{
        private static int jump(int[] nums) {
            if(nums.length <= 1) return 0;

            int step = 0;
            int curDistance = nums[0]; // 当前最远距离
            int nextDistance = nums[0]; // 下一步最远距离

            for(int i = 0; i < nums.length; i ++){
                nextDistance = Math.max(nextDistance, i + nums[i]);

                if(i == curDistance){ // 必须跳一步
                    step ++;
                    curDistance = nextDistance;
                }
                // 如果下一步的覆盖范围到达末端，提前结束
                if(curDistance >= nums.length - 1){
                    step ++;
                    break;
                }
            }

            return step;
        }
    }
}
