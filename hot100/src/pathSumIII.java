import java.util.*;

public class pathSumIII {
    public static void main(String[] args) {

    }

    class Solution{
        private int pathSum(TreeNode root, int targetSum) {
            if(root == null) return 0;
            // 题目要求的是任意节点作为起点的路径，而不仅仅是根节点，如果只算根节点的话，会漏掉
            // 从当前根节点出发的路径数 + 从左子树出发的路径数 + 从右子树出发的路径数
            return countFromNode(root, (long)targetSum)
                    + pathSum(root.left, targetSum)
                    + pathSum(root.right, targetSum);
        }

        private int countFromNode(TreeNode node, long targetSum){
            if(node == null) return 0;
            int count = 0;

            if(node.val == targetSum){
                count = 1;
            }

            // 继续往下找
            count += countFromNode(node.left, targetSum - node.val);
            count += countFromNode(node.right, targetSum - node.val);

            return count;
        }
    }
}
