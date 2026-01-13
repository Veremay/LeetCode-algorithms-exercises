import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class findSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex){
        if(startIndex >= nums.length){
            return;
        }

        // 记录本层已经使用过的数字，避免重复
        boolean[] used = new boolean[201]; // 题目中数字范围是[-100, 100]

        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty() && path.getLast() > nums[i]){
                continue;
            }
            // 跳过本层已经使用过的相同元素
            if (used[nums[i] + 100]) {
                continue;
            }

            path.add(nums[i]);
            // 标记当前数字已在本层使用
            used[nums[i] + 100] = true;

            if(path.size() >= 2) result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
