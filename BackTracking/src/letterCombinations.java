import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class letterCombinations {
    String[] letterMap = new String[]{
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder(); // 每次迭代获取一个字符串，所以会涉及大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    public void backtracking(String digits, int startIndex){
        if(path.length() == digits.length()){
            result.add(path.toString());
            return;
        }

        // 获取当前数字对应的字母字符串
        int digit = digits.charAt(startIndex) - '0';
        String letters = letterMap[digit];

        // 遍历当前数字对应的所有字母
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));  // 选择当前字母
            backtracking(digits, startIndex + 1);  // 递归处理下一个数字
            path.deleteCharAt(path.length() - 1);  // 回溯，移除最后一个字母
        }
    }
}
