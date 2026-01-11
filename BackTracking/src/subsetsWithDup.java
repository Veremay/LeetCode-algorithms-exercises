import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backtracking(nums,0,used);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, int[] used){
        if(startIndex >= nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1] && used[i-1] == 0){
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
