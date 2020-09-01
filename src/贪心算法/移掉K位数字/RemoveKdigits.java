package 贪心算法.移掉K位数字;

import java.util.LinkedList;

/**
 * leetcode 402    单调栈
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 *
 * 思考:
 * 1. 当所有数字都扫描完成后，k依然>0,应该做怎样的处理?  例如: num = 12345, k = 3时
 * 2. 当数字中有0出现时，应该有怎样的特殊处理?  例如: num = 100200, k = 1 时
 * 3. 如何将最后结果存储为字符串并返回?
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') {
                // 跳出本次循环
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) {
            return "0";
        }
        System.out.println(ret.toString());
        return ret.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits handle = new RemoveKdigits();
//        handle.removeKdigits("1002000", 1);
        handle.removeKdigits("1432219", 3);
    }
}
