/*
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。
 */
public class backspaceCompare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    static boolean backspaceCompare(String s, String t) {
        /*
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();

        int slowIndex_s = 0;
        for (int i = 0; i < s_char.length; i++) {
            if (s_char[i] != '#') {
                s_char[slowIndex_s] = s_char[i];
                slowIndex_s++;
            } else {
                if (slowIndex_s > 0) {
                    slowIndex_s--;
                }
            }
        }
        int s_len = slowIndex_s;

        int slowIndex_t = 0;
        for (int i = 0; i < t_char.length; i++) {
            if (t_char[i] != '#') {
                t_char[slowIndex_t] = t_char[i];
                slowIndex_t++;
            } else {
                if (slowIndex_t > 0) {
                    slowIndex_t--;
                }
            }
        }
        int t_len = slowIndex_t;

        if (s_len != t_len) {
            return false;
        } else {
            for (int i = 0; i < s_len; i++) {
                if (s_char[i] != t_char[i]) {
                    return false;
                }
            }
            return true;
        }

         */

        int s_index = s.length() - 1;
        int t_index = t.length() - 1;
        int s_skip = 0;
        int t_skip = 0;

        while(s_index >= 0 || t_index >= 0){
            while(s_index >= 0){
                if(s.charAt(s_index) == '#'){
                    s_skip ++;
                    s_index --;
                }else{
                    if(s_skip > 0){
                        s_skip --;
                        s_index --;
                    }else{
                        break; // 第一个能够确定的字符
                    }
                }
            }

            while(t_index >= 0){
                if(t.charAt(t_index) == '#'){
                    t_skip ++;
                    t_index --;
                }else{
                    if(t_skip > 0){
                        t_skip --;
                        t_index --;
                    }else{
                        break; // 第一个能够确定的字符
                    }
                }
            }

            if(s_index >= 0 && t_index >= 0){
                if(s.charAt(s_index) != t.charAt(t_index)){
                    return false;  //字符不相等
                }
            }else{
                if(s_index >= 0 || t_index >= 0){ //当一个已经遍历完，但另一个还没遍历完
                    return false;
                }
            }

            s_index --;
            t_index --;
        }

        return true;

    }
}
