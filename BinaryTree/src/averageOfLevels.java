import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            double sum = 0.0;  // 注意这里数据类型是double， 不能先用int再在除法的时候转换
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }

            result.add(sum / levelSize);
        }

        return result;
    }
}
