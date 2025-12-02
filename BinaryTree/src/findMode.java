import java.util.ArrayList;

public class findMode {
    TreeNode pre;
    int count;
    int maxCount;
    ArrayList<Integer> resList;
    public int[] findMode(TreeNode root) {
        pre = null;
        count = 0;
        maxCount = 0;
        resList = new ArrayList<>();
        searchBST(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void searchBST(TreeNode cur){
        if(cur == null) return;

        // 左
        searchBST(cur.left);
        // 中
        if(pre == null){ // 第一个节点
            count = 1; // 频率为1
        }else if(pre.val == cur.val) { // 如果当前节点数值和前一个节点数值相同
            count++;
        }else{
            count = 1;
        }
        pre = cur; // 更新节点

        if(count == maxCount){ // 如果频率和最高的一样，就放入result
            resList.add(cur.val);
        }

        if(count > maxCount){ // 如果频率比当前最高的高，就清空result之后，放进去
            resList.clear();
            resList.add(cur.val);
            maxCount = count;
        }

        // 右
        searchBST(cur.right);
    }
}
