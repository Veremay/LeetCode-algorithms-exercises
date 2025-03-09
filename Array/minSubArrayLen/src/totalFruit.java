/*
你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。

你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
 */

public class totalFruit {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,2};

        System.out.println(totalFruit(nums));

    }

    public static int totalFruit(int[] fruits) {
        int begin = 0;

        //用数组来模拟一个哈希表，哈希表数组的下标含义是水果的种类（因为题目中fruits[i] < fruits.length）
        int[] count = new int[fruits.length];
        int type = 0; //水果种类数目
        int result = 0; //结果

        for (int end = 0; end < fruits.length; end++) {
            if(count[fruits[end]] == 0){ //篮子里没有这种水果
                type ++;
                while(type > 2){ //加了这种水果之后，篮子里不止两种水果了
                    count[fruits[begin]] --; //移除前面的水果
                    if(count[fruits[begin]] == 0){
                        type --;
                    }
                    begin ++;
                }
            }
            count[fruits[end]] ++;

            result = Math.max(result, end-begin+1);

        }
        return result;

    }
}
