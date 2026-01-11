import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class restoreIpAddresses {
    List<String> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        int count = 0;
        backtracking(s, 0, count);
        return result;
    }

    public void backtracking(String s, int startIndex, int count){
        if(count == 4 && startIndex >= s.length()){
            String ip = String.join(".", path);
            result.add(ip);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 定义了起始位置startIndex，那么 [startIndex, i] 就是要截取的子串。
            if(isValidIp(s, startIndex, i)){
                // 获取[startIndex,i]在s中的子串
                String sub = s.substring(startIndex, i + 1);
                path.add(sub);
                count ++;
            }else{
                continue;
            }

            backtracking(s, i + 1, count); // 切割过的位置不能重复切割
            path.removeLast();
            count --;
        }
    }

    public boolean isValidIp(String s, int start, int end){
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法，但单独的0可以
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
