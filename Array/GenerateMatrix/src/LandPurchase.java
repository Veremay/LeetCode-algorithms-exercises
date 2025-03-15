import java.util.Map;
import java.util.Scanner;

public class LandPurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //行
        int m = scanner.nextInt(); //列
        int[][] matrix = new int[n][m];
        int sum = 0; //全部的总和

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                sum += matrix[i][j];
            }
        }

        // 统计横向
        int[] horizontalSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontalSum[i] += matrix[i][j];
            }
        }

        // 统计纵向
        int[] verticalSum = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                verticalSum[j] += matrix[i][j];
            }
        }

        // 行
        int result = Integer.MAX_VALUE;
        int horizontalCut = 0;
        for (int i = 0; i < n; i++) {
            horizontalCut += horizontalSum[i];
            result = Integer.min(result, Math.abs((sum - horizontalCut) - horizontalCut));
            // 更新result。其中，horizontalCut表示前i行的和，sum - horizontalCut表示剩下的和，作差、取绝对值，得到题目需要的“A和B各自的子区域内的土地总价值之差”。下同。
        }

        // 列
        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += verticalSum[j];
            result = Integer.min(result, Math.abs((sum - verticalCut) - verticalCut));
        }

        System.out.println(result);
        scanner.close();

    }
}
