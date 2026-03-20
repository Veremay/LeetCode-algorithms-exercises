import java.util.*;

public class partitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(Solution.partitionLabels(s).toString());
    }

    static class Solution{
        private static List<Integer> partitionLabels(String s) {
            // 先计算每个字母的最后出现位置
            int[] location = new int[26];
            for (int i = 0; i < s.length(); i++){
                location[s.charAt(i) - 'a'] = i;
            }

            // 其实和跳跃游戏是一样的
            List<Integer> list = new LinkedList<>();
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                end = Math.max(end, location[cur - 'a']);

                if(i == end){
                    list.add(end - start + 1);
                    start = end + 1;
                }
            }

            return list;

        }
    }
}
