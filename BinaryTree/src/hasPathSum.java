import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hasPathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        boolean result = traversal(root, paths, targetSum);
        return result;
    }

    public static boolean traversal(TreeNode root, List<Integer> paths, int targetSum){
        paths.add(root.val);
        // 遇到叶子节点，结束递归，检查路径和
        if(root.left == null && root.right == null){
            int sum = 0;
            for (int i = 0; i < paths.size(); i++) {
                sum += paths.get(i);
            }
            if(sum == targetSum){
                return true;
            }
        }

        // 递归左子树，如果找到符合条件的路径就返回true
        if(root.left != null){
            if (traversal(root.left, paths, targetSum)) {
                return true;
            }
            paths.remove(paths.size() - 1); //回溯
        }
        if(root.right != null){
            if (traversal(root.right, paths, targetSum)) {
                return true;
            }
            paths.remove(paths.size() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        // 构建测试用例：root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
        Integer[] nodes = {5, 8, 4, 13, 4, 11, null, null, null, null, 1, 7, 2};
        TreeNode root = buildTree(nodes);

        System.out.println("构建的二叉树：");
        printTree(root);

        // 测试路径总和
        int targetSum = 22; // 5->4->11->2 = 22
        boolean result = hasPathSum(root, targetSum);

        System.out.println("\n测试结果：");
        System.out.println("是否存在路径总和为 " + targetSum + " 的路径: " + result);
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

    // 打印树的辅助函数（层次遍历）
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // 移除末尾的null
        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println("Tree: " + String.join(", ", result));
    }
}
