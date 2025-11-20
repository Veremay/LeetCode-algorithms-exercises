import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
//     = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = checkFun01(root);
        //List<List<Integer>> result = checkFun02(root);

        return result;
    }

    // 迭代法
    public List<List<Integer>> checkFun01(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        // 边界情况：空树
        if(root == null){
            return result;
        }

        // 创建队列，用于存储待处理的节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);// 将根节点加入队列

        // 处理当前层的所有节点
        while(!queue.isEmpty()){
            // 这里需要记录当前层的节点值
            List<Integer> currentLevel = new ArrayList<>(); // 存储当前层的节点值
            int level_size = queue.size();
            for (int i = 0; i < level_size; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                // 同时将下一层的节点加入队列
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);

            }
            result.add(currentLevel); // 将当前层加入结果列表
        }

        return result;

    }

    // 递归法
    public List<List<Integer>> checkFun02(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> result) {
        // 递归终止条件
        if (node == null) {
            return;
        }

        // 如果当前层级还没有列表，创建一个新的空列表
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // 将当前节点值添加到对应层级的列表中
        result.get(level).add(node.val);

        // 递归处理左右子树，层级+1
        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}
