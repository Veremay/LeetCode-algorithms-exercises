import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        backtracking(candidates, target, sum, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for(int i = startIndex; i < candidates.length; i ++){
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            path.removeLast();
            sum -= candidates[i];
        }
    }


}
