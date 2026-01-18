public class numTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1; //空二叉树
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
