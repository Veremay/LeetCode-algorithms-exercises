public class deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null){ //叶子节点，直接删除
                return null;
            } else if (root.left != null && root.right == null) { //左不为空，右为空
                return root.left;
            }else if (root.left == null && root.right != null){ //左为空，右不为空
                return root.right;
            }else{
                TreeNode cur = root.right;
                while(cur.left != null){ //一直找到右子树的最深左节点
                    cur = cur.left;
                }
                cur.left = root.left; // 把节点的左子树搬到右子树最深左节点的左孩子处
                return root.right;
            }
        }

        if(key < root.val) root.left = deleteNode(root.left, key);
        if(key > root.val) root.right = deleteNode(root.right, key);

        return root;
    }
}
