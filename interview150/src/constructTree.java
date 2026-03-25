import java.util.*;

public class constructTree {
    public static TreeNode constructTree(Integer[] nums){
        if(nums == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty() && i < nums.length){
            TreeNode current = queue.poll();
            // 左节点
            if(i < nums.length && nums[i] != null){
                current.left = new TreeNode(nums[i]);
                queue.add(current.left);
            }
            i ++;

            // 右节点
            if(i < nums.length && nums[i] != null){
                current.right = new TreeNode(nums[i]);
                queue.add(current.right);
            }
            i ++;
        }

        return root;
    }
}
