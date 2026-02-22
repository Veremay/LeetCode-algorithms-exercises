import java.util.*;

public class generateParenthesis {
    public static void main(String[] args) {

    }

    class Solution{
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int left = 0, right = 0;

        public List<String> generateParenthesis(int n) {
            backtracking(n);
            return result;
        }

        private void backtracking(int n){
            if(left == n && right == n){
                result.add(path.toString());
                return;
            }

            if(left < n){
                path.append("(");
                left ++;
                backtracking(n);
                path.deleteCharAt(path.length() - 1);
                left --;
            }

            if(right < left){
                path.append(")");
                right ++;
                backtracking(n);
                path.deleteCharAt(path.length() - 1);
                right --;
            }
        }
    }
}
