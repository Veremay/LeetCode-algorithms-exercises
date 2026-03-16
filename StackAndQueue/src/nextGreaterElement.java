import java.util.*;

public class nextGreaterElement {
    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = Solution.nextGreaterElement(nums1, nums2);
        for (int num: res){
            System.out.print(num + ",");
        }
    }

    static class Solution {
        public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 单调栈 + 哈希表
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> map = new HashMap();

            stack.push(nums2[0]);
            map.put(nums2[0], -1);
            for(int i = 1; i < nums2.length; i++){
                map.put(nums2[i], -1);
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put(stack.peek(), nums2[i]);
                    stack.pop();
                }
                stack.push(nums2[i]);
            }

            int[] result = new int[nums1.length];
            for(int i = 0; i < nums1.length; i++){
                result[i] = map.get(nums1[i]);
            }

            return result;
        }
    }
}
