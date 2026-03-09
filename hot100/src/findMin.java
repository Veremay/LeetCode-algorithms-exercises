public class findMin {
    public static void main(String[] args) {

    }

    static class Solution{
        public static int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > nums[right]){ // mid落在较大的一段，则最小值在右半部分
                    left = mid + 1;
                }else{
                    right = mid;  // 最小值在左半部分（包括mid）
                }
            }

            return nums[left];
        }
    }
}
