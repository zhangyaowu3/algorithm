package 队列与栈.栈实现队列;

import java.util.LinkedList;

/**
 * 剑指offer 09
 * appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class CQueue {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        // 栈1用来插入整数
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果栈2是空的，把栈2的数据依次放入栈1
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
