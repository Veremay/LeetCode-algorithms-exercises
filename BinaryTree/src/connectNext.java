import java.util.LinkedList;
import java.util.Queue;

public class connectNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root == null){
            return root;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsSize = queue.size();
            Node current = null;
            Node pre = null;
            for (int i = 0; i < levelsSize; i++) {
                if(i == 0){
                    current = queue.poll();
                    pre = current;
                }else{
                    current = queue.poll();
                    pre.next = current;
                    pre = pre.next;
                }

                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);

            }

            pre.next = null;
        }

        return root;
    }
}
