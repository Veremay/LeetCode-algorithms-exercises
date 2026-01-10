import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int sum = 0;
        backtracking(k, n, sum, 1);
        return result;
    }

    public void backtracking(int k, int n, int sum, int startIndex){
        if(path.size() == k && sum == n ){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= 9; i++){
            path.add(i);
            sum += i;
            backtracking(k, n, sum, i+1);
            path.removeLast();
            sum -= i;
        }
    }
}
