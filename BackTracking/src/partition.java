import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class partition {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex){
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if(startIndex >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 定义了起始位置startIndex，那么 [startIndex, i] 就是要截取的子串。
            if(isPalindrome(s, startIndex, i)){
                // 获取[startIndex,i]在s中的子串
                String sub = s.substring(startIndex, i + 1);
                path.add(sub);
            }else{
                continue;
            }

            backtracking(s, i + 1); // 切割过的位置不能重复切割
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;
    }

}
