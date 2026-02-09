public class maxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(Solution.maxArea(height));

    }

    static class Solution{
        static int maxArea(int[] height){
            int left = 0;
            int right = height.length - 1;
            int result = 0;
            while(left < right){
                int area = Math.min(height[left], height[right]) * (right - left);
                result = Math.max(result, area);
                if(height[left] < height[right]){
                    left ++;
                } else if (height[left] > height[right]){
                    right --;
                }else{
                    left ++;
                    right --;
                }
            }
            return result;
         }
    }
}
