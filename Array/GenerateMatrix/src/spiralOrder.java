import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{6,9,7}};
        System.out.println(spiralOrder(matrix));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

//        int m = matrix.length;
//        int n = matrix[0].length;
//        int startX = 0;
//        int startY = 0; //每一圈的起点和终点
////        int currentLoc = 1;
//        int offset = 1;
//        int loop = 1; // 当前是第几圈
//        int row, col;
//
//        while (loop <= m / 2 || loop <= n / 2) {
//            // 顶部
//            // 左闭右开，所以判断循环结束时， col 不能等于 n - offset
//            for (col = startY; col < n - offset; col++) {
//                result.add(matrix[startX][col]);
//                System.out.println("顶部" + result);
//            }
//
//            // 右侧
//            // 左闭右开，所以判断循环结束时， row 不能等于 m - offset
//            for (row = startX; row < m - offset; row++) {
//                result.add(matrix[row][col]);
//                System.out.println("右侧" + result);
//            }
//
//
//            // 底部
//            // 左闭右开，所以判断循环结束时， col != startY
//            for (; col > startY; col--) {
//                result.add(matrix[row][col]);
//                System.out.println("底部" + result);
//            }
//
//
//            // 左侧
//            // 左闭右开，所以判断循环结束时， row != startX
//            for (; row > startX; row--) {
//                result.add(matrix[row][col]);
//                System.out.println("左侧" + result);
//            }
//
//            startX++;
//            startY++;
//            loop++;
//            offset++;
//        }
//
//        if(n == m &&  m % 2 != 0){
//            result.add(matrix[m/2][n/2]);
//        }
//
//        return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        while(left <= right && top <= bottom){
            //顶部
            for (int j = left; j <= right; j++) { //左闭右开
                result.add(matrix[top][j]);
                System.out.println("顶部" + result);
            }
            top++;

            //右侧
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                System.out.println("右侧" + result);
            }
            right--;

            //底部
            //需要检测有没有，防止单行情况
            if(top <= bottom){
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                    System.out.println("底部" + result);
                }
                bottom--;
            }

            //左侧
            //需要检验有没有，防止单列情况
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                    System.out.println("左侧" + result);
                }
                left++;
            }

        }
        return result;
        }
    }

