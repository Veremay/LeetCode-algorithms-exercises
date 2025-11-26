import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sumOfLeftLeaves {
    public int sumOfLeftLeaves_recursion(TreeNode root) {
        // 代码准则：每个节点只负责判断它的左孩子是否是左叶子
        // 当前节点不需要知道自己是否是叶子，只需要：递归处理子树；如果是父节点的左孩子，等待父节点来判断
        if(root == null) return 0;

        int middleSum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            middleSum += root.left.val;
        }

        int leftSum = sumOfLeftLeaves_recursion(root.left);
        int rightSum = sumOfLeftLeaves_recursion(root.right);

        return middleSum + leftSum + rightSum;
    }

    public int sumOfLeftLeaves_stack(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }

        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null && current.left.left == null && current.left.right == null){
                result += current.left.val;
            }
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }

        return result;
    }
}
