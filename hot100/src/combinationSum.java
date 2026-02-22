import java.util.*;

public class combinationSum {
    public static void main(String[] args) {

    }

    class Solution{
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtracking(candidates, target, 0);
            return result;
        }

        private void backtracking(int[] candidates, int target, int startIndex){
            if(sum == target){
                result.add(new ArrayList<>(path));
                return;
            }
            if(sum > target){
                return;
            }

            // 使用 startIndex 控制起始位置是为了保证组合的递增顺序
            for (int i = startIndex; i < candidates.length; i++) {
                path.add(candidates[i]);
                sum += candidates[i];
                backtracking(candidates, target, i); // 传递i而不是i+1是为了实现重复选取
                path.removeLast();
                sum -= candidates[i];
            }


        }
    }
}
