package 贪心算法.摇摆序列;

/**
 * leetcode 376
 *
 * 思路：状态机转换  每一次状态变化，长度就加1
 */
public class WiggleMaxLength {
    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        int[] arr = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength.MaxLength(arr));
    }

//    public int MaxLength(int[] arr) {
//        if (arr.length <= 2) {
//            System.out.println("摆动序列的长度：" + arr.length);
//            return arr.length;
//        }
//        // 定义三种状态
//        final int BEGIN = 0;
//        final int UP = 1;
//        final int DOWN = 2;
//        // 定义开始时的状态和最大长度
//        int state = BEGIN;
//        int maxLength = 1;
//        for (int i = 1; i < arr.length; i++) {
//            switch (state) {
//                case BEGIN:
//                    if (arr[i - 1] < arr[i]) {
//                        state = UP;
//                        maxLength++;
//                    } else if (arr[i - 1] > arr[i]) {
//                        state = DOWN;
//                        maxLength++;
//                    }
//                    break;
//                case DOWN:
//                    if (arr[i - 1] < arr[i]) {
//                        state = UP;
//                        maxLength++;
//                    }
//                    break;
//                case UP:
//                    if (arr[i - 1] > arr[i]) {
//                        state = DOWN;
//                        maxLength++;
//                    }
//                    break;
//            }
//
//        }
//        System.out.println(maxLength);
//        return maxLength;
//    }

    public int MaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
