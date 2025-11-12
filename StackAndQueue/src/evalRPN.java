import java.util.Stack;

public class evalRPN {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4","3","-"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String temp = " ";
        for (String s: tokens) {
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}
