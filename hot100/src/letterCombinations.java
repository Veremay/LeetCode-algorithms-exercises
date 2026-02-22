import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static void main(String[] args) {

    }

    class Solution{
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
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            backtracking(digits,0);
            return result;
        }

        private void backtracking(String digits, int startIndex){
            if(startIndex == digits.length()){
                result.add(path.toString());
                return;
            }

            // 获取当前数字对应的字母字符串
            int digit = digits.charAt(startIndex) - '0';
            String letters = letterMap[digit];

            // 遍历当前数字对应的所有字母
            for (int i = 0; i < letters.length(); i++) {
                path.append(letters.charAt(i)); // 选择一个字母
                backtracking(digits, startIndex + 1); // 处理下一个数字
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
