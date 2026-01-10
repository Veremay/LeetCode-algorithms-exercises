import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine {
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();  // 作为临时路径存储，在回溯过程中频繁修改，链表复杂度为O(1)，这里用arraylist也是可以的
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1); // 因为在backtracking()中，直接加入的是i，所以这里要从1开始遍历。
        return result;
    }

    public void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
            // 创建path的副本添加到结果中，避免后续修改影响已存储的结果
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= n; i++){
            path.add(i);
            backtracking(n, k, i+1);
            path.removeLast();
        }
    }
}
