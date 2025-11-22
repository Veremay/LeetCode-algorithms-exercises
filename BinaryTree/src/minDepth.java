import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }

        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            depth ++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null ) return depth;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);

            }
        }

        return depth;
    }
}
