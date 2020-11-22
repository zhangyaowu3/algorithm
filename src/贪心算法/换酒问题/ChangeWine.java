package 贪心算法.换酒问题;

/**
 * leetcode 1518 换酒问题 贪心算法
 * numBottles 酒的数量
 * numExchange 几个空瓶可以换一瓶酒
 */
public class ChangeWine {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(10, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int num = numBottles;
        while (numBottles >= numExchange) {
            // 本次可以喝的酒的数量
            num = num + numBottles / numExchange;
            // 本次的空瓶数量
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return num;
    }
}
