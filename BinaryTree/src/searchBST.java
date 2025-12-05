import java.util.LinkedList;
import java.util.Queue;

public class searchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        if (left != null) return left;

        TreeNode right = searchBST(root.right, val);
        return right;
    }

    public static TreeNode searchBST2(TreeNode root, int val) {
        // 利用二叉搜索树的特性
        // 大多是二叉搜索树的题目，其实都离不开中序遍历，因为这样就是有序的。
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            // 只在左子树中搜索
            return searchBST(root.left, val);
        } else {
            // 只在右子树中搜索
            return searchBST(root.right, val);
        }

    }

    public static void main(String[] args) {
        // 构建测试用例：root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
        Integer[] nodes = {4,2,7,1,3};
        TreeNode root = buildTree(nodes);

        searchBST(root, 2);
    }

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
