import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class nTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int levelSize = nodes.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = nodes.poll();
                currentLevel.add(currentNode.val);
                for(Node child: currentNode.children){
                    if(child != null)nodes.offer(child);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
