import java.util.*;
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()){
            // 打印奇数层
            List<Integer> row = new ArrayList<>();
            // 从左向右打印
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                row.add(node.val);
                // 先左后右加入子节点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(new ArrayList<>(row));

            if(deque.isEmpty()) break; // 若为空则提前跳出

            // 打印偶数层
            row = new ArrayList<>();
            size = deque.size();
            for(int i = size; i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                row.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) deque.addFirst(node.right);
                if (node.left != null) deque.addFirst(node.left);
            }
            res.add(new ArrayList<>(row));
        }

        return res;
    }
}
