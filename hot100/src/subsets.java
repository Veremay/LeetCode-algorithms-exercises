import java.util.*;
public class subsets {
    public static void main(String[] args) {

    }

    class Solution{
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            result.add(new ArrayList<>());
            backtracking(nums, 0);
            return result;
        }

        private void backtracking(int[] nums, int startIndex){
            if(startIndex >= nums.length){
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                result.add(new ArrayList<>(path));
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
