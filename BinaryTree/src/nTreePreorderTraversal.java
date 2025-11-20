import java.util.ArrayList;
import java.util.List;

public class nTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public  List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        nPreOrder(root, result);

        return result;
    }

    public static void nPreOrder(Node root, List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        if(root.children != null){
            for (Node child: root.children){
                nPreOrder(child,result);
            }
        }

    }
}
