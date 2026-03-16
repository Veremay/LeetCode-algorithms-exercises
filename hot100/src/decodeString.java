import java.util.*;

public class decodeString {
    public static void main(String[] args){
        String s = "3[a2[b]c]";
        System.out.println(Solution.decodeStrings(s));
    }

    static class Solution{
        public static String decodeStrings(String s){
            // 数字栈 (countStack)：存放当前的倍数 k。
            // 字符串栈 (resStack)：存放当前括号外的“普通字符串”。
            Stack<Integer> count = new Stack<>();
            Stack<String> string = new Stack<>();
            int multi = 0; // 记录当前倍数
            String res = ""; // 记录当前被倍数的字符串
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if(curChar >= '0' && curChar <= '9'){ // 处理多位数字。不能在这里直接push
                    // multi = multi * 10 + Integer.parseInt(String.valueOf(curChar));
                    multi = multi * 10 + curChar - '0';
                } else if (curChar == '[' ) {
                    // 遇到左括号，把multi和res都入栈
                    count.push(multi);
                    string.push(res);
                    // 重置
                    multi = 0;
                    res = "";
                } else if (curChar == ']') {
                    // 遇到右括号，取出倍数和前一个字符
                    int num = count.pop();
                    String last_res = string.pop();
                    // 拼接
                    for (int j = 0; j < num; j++) {
                        last_res += res;
                    }
                    res = last_res;
                } else { // 普通字符
                    res += String.valueOf(curChar);
                }
            }

            return res;
        }
    }
}
