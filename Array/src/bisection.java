public class bisection {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,3,9,12};
        int target = 4;

        System.out.println(search(nums, target));
        }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                return -1;
            }
        }
        return -1;
    }
}

