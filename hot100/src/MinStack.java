import java.util.*;

public class MinStack {
    // 如果只用一个变量 min_val 来记录当前最小值，当 push 一个新元素时，更新 min_val 很容易。但当 pop 掉这个最小值后，该如何知道次小的值是多少呢？
    // 空间换时间的策略
    // 既然一个变量记不住“历史”，我们需要某种方式来存储每一个状态下的最小值。
    // 引入一个辅助栈
    Stack<Integer> main = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {

    }

    public void push(int val) {
        main.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop() {
        main.pop();
        minStack.pop();
        if(minStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = minStack.peek();
        }
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
