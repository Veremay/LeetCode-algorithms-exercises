import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(i == 0) result = current.val; // 记录这一行最左边的节点值
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }

        return result;

    }

}
