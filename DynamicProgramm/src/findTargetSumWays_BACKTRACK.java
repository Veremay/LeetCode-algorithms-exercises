import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class findTargetSumWays_BACKTRACK {

    // 用回溯法试试
    // 会超时

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public int findTargetSumWays_backtrack(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return result.size();
    }

    public void backtracking(int[] nums, int target, int startIndex, int sum){
        // 递归终止条件：处理完所有数字
        if (startIndex == nums.length){
            if(sum == target) {
                // 如果当前和等于目标值，则找到一种方法
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 选择1：当前数字取正号（加法）
         path.add("+" + nums[startIndex]);
        backtracking(nums, target, startIndex + 1, sum + nums[startIndex]);
         path.removeLast(); // 回溯，撤销选择

        // 选择2：当前数字取负号（减法）
         path.add("-" + nums[startIndex]);
        backtracking(nums, target, startIndex + 1, sum - nums[startIndex]);
         path.removeLast(); // 回溯，撤销选择
        
    }
}
