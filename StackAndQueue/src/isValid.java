import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String s = "([)]";

        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char temp = ' ';
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if(!stack.isEmpty()){
                if(temp == ')' && stack.peek()=='('){
                    stack.pop();
                } else if (temp == ']'  && stack.peek()=='[') {
                    stack.pop();
                } else if (temp == '}'  && stack.peek()=='{') {
                    stack.pop();
                } else{
                    stack.push(temp);
                }
            }else{
                stack.push(temp);
            }

        }

        return stack.isEmpty();
    }
}
