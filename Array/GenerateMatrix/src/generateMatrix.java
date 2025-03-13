/*
给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */


import java.util.Arrays;

public class generateMatrix {
    public static void main(String[] args) {
        int n = 4;
        int[][] b = generateMatrix(n);
        System.out.println(Arrays.deepToString(b));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startX = 0;
        int startY = 0; //每一圈的起点和终点
        int currentNum = 1;
        int offset = 1;
        int loop = 1; // 当前是第几圈
        int row, col;

        while (loop <= n / 2) {
            // 顶部
            // 左闭右开，所以判断循环结束时， col 不能等于 n - offset
            for (col = startY; col < n - offset; col++) {
                matrix[startX][col] = currentNum;
                currentNum++;
            }

            // 右侧
            // 左闭右开，所以判断循环结束时， row 不能等于 n - offset
            for (row = startX; row < n - offset; row++) {
                matrix[row][col] = currentNum;
                currentNum++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， col != startY
            for (; col > startY; col--) {
                matrix[row][col] = currentNum;
                currentNum++;
            }

            // 左侧
            // 左闭右开，所以判断循环结束时， row != startX
            for (; row > startX; row--) {
                matrix[row][col] = currentNum;
                currentNum++;
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }

        if(n % 2 != 0){
            matrix[n/2][n/2] = n * n;
        }

        return matrix;
    }
}
