import java.util.*;

public class printTree {
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null");
            }
        }
        System.out.println("]");
    }
}
