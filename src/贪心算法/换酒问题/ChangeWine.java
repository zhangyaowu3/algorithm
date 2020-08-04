package 贪心算法.换酒问题;

/**
 * leetcode 1518 换酒问题 贪心算法
 * numBottles 酒的数量
 * numExchange 几个空瓶可以换一瓶酒
 */
public class ChangeWine {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int num = numBottles;
        while (numBottles >= numExchange) {
            num = num + numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return num;
    }
}
