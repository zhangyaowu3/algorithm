package 贪心算法.分糖果;

import java.util.Arrays;

/**
 *  leetcode 455
 *
 * 已知一些孩子和一些糖果，每个孩子有需求因子g,
 * 每个糖果有大小s,当某个糖果的大小s>=某个孩子的需求因子g时，
 * 代表该糖果可以满足该孩子；求使用这些糖果，最多能满足多少孩子?(注意:某个孩子最多只能用一个糖果满足)
 *
 * 例如: 需求因子数组g = [5,10,2,9,15,9]; 糖果大小数组s = [6,1,20,3,8],最多 可以满足3个孩子
 */
public class DivideCandy {

    public static void main(String[] args) {
        DivideCandy divideCandy = new DivideCandy();
        int[] demandFactor = new int[]{5,10,2,9,15,9};
        int[] candy = new int[]{6,1,20,3,8};
        divideCandy.ChildNum(demandFactor, candy);
    }

    public int ChildNum(int[] demandFactor, int[] candy) {
        Arrays.sort(demandFactor);
        Arrays.sort(candy);
        // child代表已满足了几个孩子，candy代表尝试了几个糖果
        int childNum = 0;
        int candyNum = 0;
        // 在满足条件时，孩子指针和糖果指针都往右移动；不满足条件时，仅糖果指针往右移动
        while (childNum < demandFactor.length && candyNum < candy.length ) {
            if (demandFactor[childNum] <= candy[candyNum]) {
                childNum++;
            }
            candyNum ++;
        }
        System.out.println(childNum);
        return childNum;
    }
}
