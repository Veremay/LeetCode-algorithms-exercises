import java.util.*;

public class balance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = sc.nextInt();
        while(T -- > 0){
            int n = sc.nextInt();
            String s = sc.next();

            int[] leftPos = new int[n / 2];
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '('){
                    leftPos[index] = i;
                    index ++;
                }
            }

            int step = 0;
            for (int i = 0; i < leftPos.length; i++) {
                int gap = Math.abs(leftPos[i] - i * 2);
                step += gap;
            }

            System.out.println(step);
        }
    }
}
