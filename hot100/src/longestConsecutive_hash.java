import java.util.*;
public class longestConsecutive_hash {
    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(Solution.longestConsecutive(nums));
    }

    static class Solution {
        public static int longestConsecutive(int[] nums) {
            if(nums.length == 0) return 0;
            // 需要一种能够只存储存在的数字，且能以 O(1) 复杂度查询某个数字是否存在的容器。 -> HashSet
            // 为了保证每个数字只被访问常数次，我们只在 num 是序列起点 时才开始计数。
            // 如果 set 中不包含 num - 1，那么 num 就是一个序列的开头。
            Set<Integer> set = new HashSet<>();
            for(int num: nums){
                set.add(num);
            }

            int result = 0;
            for (int num : set) {          // 遍历 去重后的set 而非原始数组，不然会重复计算起点
                int count = 1;
                // 确认遍历到的数是否是起点
                int curNum = num;
                if(!set.contains(curNum - 1)){ // 如果set不包含curnum - 1，说明是起点
                    while(set.contains(curNum + 1)){ // 开始数数
                        count ++;
                        curNum ++;
                    }
                    result = Math.max(result, count);
                }
            }

            return result;
        }
    }

}
