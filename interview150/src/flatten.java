import java.util.*;

public class flatten {
    static class Solution {
        public static void flatten(TreeNode root){
            List<TreeNode> list = new LinkedList<>();
            traversal(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                TreeNode node = list.get(i);
                node.left = null;
                node.right = list.get(i + 1);
            }
            list.get(list.size() - 1).left = null;
        }

        private static void traversal(TreeNode node, List<TreeNode> list){
            if(node == null) return;
            list.add(node);
            traversal(node.left, list);
            traversal(node.right, list);
        }
    }
}
