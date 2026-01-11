import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        // 对数组进行排序
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        backtracking(candidates, target, sum, 0, used);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex, int[] used){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if(i != 0 && candidates[i] == candidates[i-1] && used[i-1] == 0){
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = 1;
            backtracking(candidates, target, sum, i + 1, used);
            path.removeLast();
            sum -= candidates[i];
            used[i] = 0;
        }
    }
}

class combinationSum2_simp {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2_simp(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 树层去重：i > startIndex 确保同一层不重复
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i + 1);
            path.removeLast();
        }
    }
}
