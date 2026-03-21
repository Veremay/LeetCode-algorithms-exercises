import java.util.*;

public class balance2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = sc.nextInt();
        while(T -- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            char[] arr = s.toCharArray();
            int step = 0;
            int count = 1;
            while(count != 0){
                for (int i = 0; i < n - 1; i++) {
                    if(arr[i] == ')' && arr[i+1] == ')' ){
                        count ++;
                    }
                    if(arr[i] == ')' && arr[i+1] == '(' ){
                        arr[i] = '(';
                        arr[i+1] = ')';
                        step ++;
                    }
                }
                count --;
            }
            System.out.println(step);
        }
    }
}
