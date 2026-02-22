import java.util.*;

public class partition {
    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(s.substring(0, 1));

    }

    class Solution{
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        public List<List<String>> partition(String s) {
            backtracking(s, 0);
            return result;
        }

        private void backtracking(String s, int start){
            if(start == s.length()){ // 如果是length - 1，这个时候最后一个字符串还没加入路径
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if(isPalindrome(s, start, i)){
                    path.add(s.substring(start, i + 1));
                    backtracking(s, i + 1);
                    path.removeLast();
                }
            }

        }

        private boolean isPalindrome(String word, int start, int end){
            for(int i = start, j = end; i < j; i++, j--){
                if(word.charAt(i) != word.charAt(j)) return false;
            }
            return true;
        }
    }
}
