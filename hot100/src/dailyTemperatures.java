import java.util.*;

public class dailyTemperatures {
    public static void main(String[] args){
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = Solution.dailyTemperatures(temperatures);
        for (int num: res){
            System.out.print(num + ",");
        }
    }

    static class Solution {
        public static int[] dailyTemperatures(int[] temperatures) {
            // 引入单调栈。存放“还在等待更高温”的那些天的索引。
            // 在遍历过程中，“记住”那些还没找到更高温度的天气，等遇到高温时一次性“解决”掉它们
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[temperatures.length];

            stack.push(0);

            for (int i = 1; i < temperatures.length; i++) {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);

            }

            return result;
        }
    }
}
