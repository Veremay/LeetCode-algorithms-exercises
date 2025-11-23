import java.util.LinkedList;
import java.util.Queue;

class invertTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return root;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
        }

        return root;
    }

    public TreeNode invertTreePreorder(TreeNode root){
        if(root == null){
            return root;
        }

        // 交换左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreePreorder(root.left);
        invertTreePreorder(root.right);
         return root;
    }
}
