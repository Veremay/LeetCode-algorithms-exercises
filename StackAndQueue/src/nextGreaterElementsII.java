import java.util.*;

public class nextGreaterElementsII {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int[] nextGreaterElements(int[] nums) {
            // 因为数组是循环的，每个元素不仅可以看到它后面的元素，还可以看到数组开头的一部分。
            // 一种直观的方法是将原数组“拉直”成两倍长度
            // 可以通过取模运算来模拟两倍数组的遍历，而不实际创建新数组。
            int n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            Stack<Integer> stack = new Stack<>(); // 存下标

            for (int i = 0; i < 2 * n; i++) {
                int cur = nums[i % n];
                while (!stack.isEmpty() && cur > nums[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = cur;
                }
                if (i < n) {  // 为了避免重第二次遍历时又把下标压入，只在下标 i < n 时压入栈。
                    stack.push(i);
                }
            }
            return res;
        }
    }
}
