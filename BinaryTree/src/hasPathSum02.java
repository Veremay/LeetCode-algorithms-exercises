import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hasPathSum02 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, 0, targetSum);
    }

    public static boolean traversal(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;

        // 如果是叶子节点，检查当前和是否等于目标值
        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }

        // 递归检查左右子树
        return traversal(root.left, currentSum, targetSum) ||
                traversal(root.right, currentSum, targetSum);
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
