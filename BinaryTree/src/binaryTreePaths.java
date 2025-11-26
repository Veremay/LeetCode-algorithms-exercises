import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }

        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;

    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> result){
        paths.add(root.val);// 前序遍历，中
        // 遇到叶子节点，递归结束
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            // 记录最后一个节点
            sb.append(paths.get(paths.size()-1));
            result.add(sb.toString()); // 记录下一个路径
            return;
        }

        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left != null) { // 左
            traversal(root.left, paths, result);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) { // 右
            traversal(root.right, paths, result);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
