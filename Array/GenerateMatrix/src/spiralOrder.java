import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{6,9,7}};
        System.out.println(spiralOrder(matrix).toString());

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int startX = 0;
        int startY = 0; //每一圈的起点和终点
//        int currentLoc = 1;
        int offset = 1;
        int loop = 1; // 当前是第几圈
        int row, col;

        while (loop <= m / 2 || loop <= n / 2) {
            // 顶部
            // 左闭右开，所以判断循环结束时， col 不能等于 n - offset
            for (col = startY; col < n - offset; col++) {
                result.add(matrix[startX][col]);
            }

            // 右侧
            // 左闭右开，所以判断循环结束时， row 不能等于 m - offset
            for (row = startX; row < m - offset; row++) {
                result.add(matrix[row][col]);
            }

            // 底部
            // 左闭右开，所以判断循环结束时， col != startY
            for (; col > startY; col--) {
                result.add(matrix[row][col]);
            }

            // 左侧
            // 左闭右开，所以判断循环结束时， row != startX
            for (; row > startX; row--) {
                result.add(matrix[row][col]);
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }

        if(n == m &&  m % 2 != 0){
            result.add(matrix[m/2][n/2]);
        }

        return result;
        }
    }

