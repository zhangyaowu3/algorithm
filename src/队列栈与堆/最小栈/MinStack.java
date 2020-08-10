package 队列栈与堆.最小栈;

import java.util.Stack;

/**
 * leetcode 155 最小栈  能在常数时间内检索到最小元素的栈
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */

/**
 * 算法思路:
 * 借用一个辅助栈min_stack，用于存获取stack中最小值。
 *
 * 算法流程：
 * push()方法： 每当push()新值进来时，如果 小于等于 min_stack栈顶值，则一起push()到min_stack，即更新了栈顶最小值；
 * pop()方法： 判断将pop()出去的元素值是否是min_stack栈顶元素值（即最小值），如果是则将min_stack栈顶元素一起pop()，这样可以保证min_stack栈顶元素始终是stack中的最小值。
 * getMin()方法： 返回min_stack栈顶即可。
 *
 */
public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 需要是小于等于
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // 只有stack和minStack的顶部相同时，才pop
    public void pop() {
        // pop直接弹出了
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // 返回 -3
        System.out.println(minStack.getMin());
        minStack.pop();
        // minStack.top();   返回 0
        System.out.println(minStack.top());
        // minStack.getMin();  返回 -2
        System.out.println(minStack.getMin());
    }
}
