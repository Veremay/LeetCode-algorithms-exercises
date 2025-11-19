import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        System.out.println(preorderTraversal(root));
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preorder(root, list);

        return list;
    }

    public static void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}

