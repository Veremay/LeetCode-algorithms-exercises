import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permuteUnique {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used_tree = new boolean[nums.length];
        backtracking(nums, used_tree);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used_tree){
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        boolean[] used_layer = new boolean[21];
        for (int i = 0; i < nums.length; i++) {
            if(used_layer[nums[i] + 10]){
                continue;
            }
            if(used_tree[i]){
                continue;
            }

            path.add(nums[i]);
            used_layer[nums[i] + 10] = true;
            used_tree[i] = true;
            backtracking(nums, used_tree);
            path.removeLast();
            used_tree[i] = false;
        }
    }
}
