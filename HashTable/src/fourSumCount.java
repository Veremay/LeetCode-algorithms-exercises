import java.util.*;

public class fourSumCount {
    public static void main(String[] args){

    }

    static class Solution {
        public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int result = 0;
            Map<Integer, Integer> map = new HashMap<>();

            //统计两个数组中的元素之和，同时统计出现的次数，放入map
            for (int i : nums1) {
                for (int j : nums2) {
                    int sum = i + j;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            for (int i : nums3) {
                for (int j : nums4) {
                    int sum = i + j;
                    if(map.containsKey(0 - sum)){
                        result += map.get(0 - sum);
                    }
                }
            }

            return result;
        }
    }
}
