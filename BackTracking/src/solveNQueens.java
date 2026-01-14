import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solveNQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] chessboard = new String[n][n];
        for (String[] c : chessboard) {
            Arrays.fill(c, ".");
        }

        backtracking(n, 0, chessboard);
        return result;
    }

    public void backtracking(int n, int curRow, String[][] chessboard){
        if (curRow == n){
            // 将当前棋盘状态转换为结果
            List<String> boardState = new ArrayList<>();
            for (String[] row : chessboard) {
                boardState.add(String.join("", row)); // 每行拼接成一个字符串
            }
            result.add(new ArrayList<>(boardState));
            return;
        }

        for (int col = 0; col < chessboard[curRow].length; col++) {
            if(isValid(curRow, col, chessboard)){
                chessboard[curRow][col] = "Q";
                backtracking(n, curRow+1, chessboard);
                chessboard[curRow][col] = ".";
            }
        }
    }

    public boolean isValid(int curRow, int col, String[][] chessboard){
        // 横着不行
        for (int i = 0; i < chessboard[curRow].length; i++) {
            if(chessboard[curRow][i].equals("Q")){
                return false;
            }
        }

        // 竖着不行
        for (int i = 0; i < chessboard.length; i++) {
            if(chessboard[i][col].equals("Q")){
                return false;
            }
        }

        // 检查45度对角线
        for (int i=curRow-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j].equals("Q")) {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=curRow-1, j=col+1; i>=0 && j<chessboard[i].length; i--, j++) {
            if (chessboard[i][j].equals("Q")) {
                return false;
            }
        }

        return true;
    }
}
