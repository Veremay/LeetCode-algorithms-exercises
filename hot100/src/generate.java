import java.util.*;
public class generate {
    public static void main(String[] args) {
        Solution.generate(5);
    }

    static class Solution{
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);

            int[][] dp = new int[numRows][numRows];

            if(numRows == 1) return result;

            dp[0][0] = 1;
            for (int i = 1; i < numRows; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < numRows; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }


            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < dp[i].length; j++) {
                    if(dp[i][j] != 0){
                        row.add(dp[i][j]);
                    }
                    System.out.print(dp[i][j]);
                }
                System.out.println();
                result.add(row);
            }

            return result;
        }
    }
}
