public class exist {
    public static void main(String[] args) {

    }

    class Solution{
        public boolean exist(char[][] board, String word) {
            // 不能只从(0,0)开始搜索，从网格中的每一个格子都尝试作为单词的起点
            int m = board.length;
            int n = board[0].length;
            int[][] visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) { // 只对可能的起点尝试
                        if (dfsAndBacktracking(board, word, visited, i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // 从 (i,j) 出发能否匹配从 word[index] 开始的剩余部分
        private boolean dfsAndBacktracking(char[][] board, String word, int[][] visited, int i, int j, int index){
            // 越界检查，如果不通过，说明此路不通
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
            // 已访问检查
            if(visited[i][j] == 1) return false;
            // 字符匹配检查
            if(board[i][j] != word.charAt(index)) return false;
            // 到这里说明当前格子匹配成功
            if(index == word.length() - 1){
                return true;
            }
            // 标记已访问
            visited[i][j] = 1;
            // 递归四个方向
            boolean foundUp = dfsAndBacktracking(board, word, visited, i - 1, j, index + 1);
            boolean foundRight = dfsAndBacktracking(board, word, visited, i, j + 1, index + 1);
            boolean foundDown = dfsAndBacktracking(board, word, visited, i + 1, j, index + 1);
            boolean foundLeft = dfsAndBacktracking(board, word, visited, i, j - 1, index + 1);
            boolean found = foundUp || foundRight || foundDown || foundLeft;
            // 回溯
            visited[i][j] = 0;

            return found;
        }
    }
}
