import java.util.*;

public class inorderTraversal {
    public static void main(String[] args) {
        Integer[] roots = {1,2,3,4,5,null,8,null,null,6,7,9};

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

        List<Integer> result = Solution.inorderTraversal(root);

        for(Integer val: result){
            System.out.print(val + "->");
        }

    }

    static class Solution{
        static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            traversal(root, result);
            return result;
        }
        private static void traversal(TreeNode node, List<Integer> result){
            if(node == null) return;
            traversal(node.left, result);
            result.add(node.val);
            traversal(node.right, result);
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
