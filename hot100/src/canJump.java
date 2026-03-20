public class canJump {
    public static void main(String[] args){

    }

    static class Solution{
        private boolean canJump(int[] nums) {
            int cover = 0;

            // 在 cover 的范围内移动。每到一个新位置 i，就计算：从这个位置起跳，最远能到哪？
            for (int i = 0; i <= cover; i++) {
                cover = Math.max(cover, i + nums[i]);
                if(cover >= nums.length){
                    return true;
                }
            }

            return false;
        }
    }
}
