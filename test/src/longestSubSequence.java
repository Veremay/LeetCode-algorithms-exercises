import java.util.*;
public class longestSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        while (T-->0) { // 注意 while 处理多个 case
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();
                set.add(num);
            }

            System.out.println(set.size());
        }
    }
}
