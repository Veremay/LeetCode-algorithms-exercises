import java.util.*;

public class flatten {
    public static void main(String[] args) {

    }

    class Solution{
        private void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            traversal(root, list);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1);
                TreeNode cur = list.get(i);
                prev.left = null;
                prev.right = cur;
            }
        }

        private void traversal(TreeNode node, List<TreeNode> list){
            if(node == null) return;
            list.add(node);
            traversal(node.left, list);
            traversal(node.right, list);
        }
    }
}
