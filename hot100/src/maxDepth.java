import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxDepth {
    public static void main(String[] args) {
        Integer[] roots = {1,2,7,3,4,null,null,null,null,5,6};

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(roots[0]);
        queue.offer(root);

        int index = 1;
        while(!queue.isEmpty() && index < roots.length){
            TreeNode cur = queue.poll();
            // 左节点
            if(roots[index] != null){
                TreeNode left = new TreeNode(roots[index]);
                cur.left = left;
                queue.offer(left);
            }
            index ++;

            // 右节点
            if(index < roots.length && roots[index] != null){
                TreeNode right = new TreeNode(roots[index]);
                cur.right = right;
                queue.offer(right);
            }
            index ++;
        }

        System.out.println(Solution.maxDepth(root));
    }

    static class Solution{
        static int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
