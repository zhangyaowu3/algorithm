package 队列与栈.合法的出栈序列;

import java.util.Stack;

/**
 * poj(北大在线测评系统) 1363 Rails  合法的出栈序列
 *
 * 已知1-n的数字序列，按顺序入栈，每个数字入栈后即可出栈，也可在栈中停留，
 * 等待后面的数字入栈出栈后，该数字再出栈，求该数字序列的出栈序列是否合法
 *
 * 原始数据: 1 2 3 4 5
 *
 * 例: 3 2 5 4 1 合法
 * 3 1 2 4 5 不合法   出栈序列不会是这个
 */
public class RightPop {

    public static void main(String[] args) {
        RightPop rightPop = new RightPop();
        int[] originalArr = new int[]{1, 2, 3, 4, 5};
        int[] resultArr = new int[]{3, 2, 5, 4, 1};
        rightPop.RightPop(originalArr, resultArr);
    }

    public boolean RightPop(int[] pushA, int[] popA) {
        if (pushA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //将popA中满足出栈条件的元素出栈
            while (j < popA.length && popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        System.out.println(stack.isEmpty());
        return stack.isEmpty();

    }


}
