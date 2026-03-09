public class searchMatrix {
    public static void main(String[] args) {

    }

    static class Solution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            // 把二维矩阵展开成一维数组，解法就一样了
            int m = matrix.length;
            int n = matrix[0].length;
            int[] nums = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i * n + j] = matrix[i][j];
                }
            }

            if(target < nums[0]) return false;
            if(target > nums[nums.length - 1]) return false;
            boolean res = search(nums, target, 0, nums.length - 1);
            return res;

        }

        private static boolean search(int[] nums, int target, int left, int right){
            if (left > right) return false;          // 终止条件
            int middle = left + (right - left) / 2;       // 防止溢出
            if (nums[middle] == target) return true;
            if (nums[middle] < target)
                return search(nums, target, middle + 1, right); // 收缩左边界
            else
                return search(nums, target, left, middle - 1);  // 收缩右边界
        }
    }
}
