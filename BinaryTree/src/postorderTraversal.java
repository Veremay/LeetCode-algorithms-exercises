import java.util.ArrayList;
import java.util.List;

public class postorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);

        return list;
    }

    public static void postorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}
