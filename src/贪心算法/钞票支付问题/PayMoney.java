package 贪心算法.钞票支付问题;

/**
 * 有1元，5元，10元，20元，100元，200元的钞票无穷多张，
 * 现在使用这些钞票支付X元，最少需要多少张?
 * <p>
 * X = 628
 */
public class PayMoney {

    public static void main(String[] args) {
        PayMoney payMoney = new PayMoney();
        payMoney.minNum(628);
    }

    public int minNum(int x) {
        int[] noteType = new int[]{200, 100, 20, 10, 5, 1};
        int total = 0;

        for (int i = 0; i < noteType.length; i++) {
            total = total + x / noteType[i];
            x = x - (x / noteType[i]) * noteType[i];
        }
        System.out.println("需要张数:" + total);
        // 200 3, 20 1, 5 1, 1 3
        return total;
    }
}
