import java.util.*;
public class permute {
    public static void main(String[] args) {

    }

    class Solution{
        List<List<Integer>> result= new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        private List<List<Integer>> permute(int[] nums) {
            int[] used = new int[nums.length];
            backtracking(nums, used);
            return result;
        }

        private void backtracking(int[] nums, int[] used){
            if(path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if(used[i] == 1) continue;
                path.add(nums[i]);
                used[i] = 1;
                backtracking(nums, used);
                path.removeLast();
                used[i] = 0;
            }
        }
    }
}
