import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hasPathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<Integer> path = new ArrayList<>();
        traversal(root, result, path, targetSum);
        return result;
    }

    public static void traversal(TreeNode root, List<List<Integer>> result, List<Integer> path, int targetSum){
        path.add(root.val);
        if(root.left == null && root.right == null){
            int sum = 0;
            List<Integer> currentPath = new ArrayList<>();
            for(int i: path){
                sum += i;
                currentPath.add(i);
            }
            if(sum == targetSum) result.add(currentPath); // 记录下一个路径
            return;
        }

        if(root.left != null){
            traversal(root.left, result, path, targetSum);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            traversal(root.right, result, path, targetSum);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // 构建测试用例：root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
        Integer[] nodes = {5, 8, 4, 13, 4, 11, null, null, null, null, 1, 7, 2};
        TreeNode root = buildTree(nodes);

        // 测试路径总和
        int targetSum = 22; // 5->4->11->2 = 22
        pathSum(root, targetSum);
    }

    // 构建二叉树的辅助函数
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // 左子节点
            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            // 右子节点
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
