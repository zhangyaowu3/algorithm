package 队列栈与堆.队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 225 队列实现栈   ---2--1-->  ->     ---1--2-->   保持2不变，移动1
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // 把元素压入栈中
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i< queue.size(); i++) {
            queue.add(queue.remove());
        }

    }
    // 弹出(移除)栈顶元素
    public int pop() {
        return queue.poll();
    }

    // 返回栈顶元素
    public int top() {
        return queue.peek();
    }

    // 判断栈是否为空
    public boolean empty() {
        return queue.size() == 0;
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
