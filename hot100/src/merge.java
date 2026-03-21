import java.util.*;

public class merge {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int[][] merge(int[][] intervals) {
            if(intervals.length == 1) return intervals;
            // 按照每一行的第 0 个元素升序排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> list = new ArrayList<>();
            int min = intervals[0][0], max = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] > max ){
                    list.add(new int[]{min, max});
                    min = intervals[i][0];
                    max = intervals[i][1];
                    // 当循环结束时，最后一个被合并的区间还在变量 min 和 max 里，没有被加进 list
                }
                else{ // (intervals[i][0] <= max)
                    if(intervals[i][1] > max){
                        max = intervals[i][1];
                    }
                }
            }
            list.add(new int[]{min, max});

            return list.toArray(new int[list.size()][2]);
        }
    }
}
