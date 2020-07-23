package 位运算;

public class OddNumber {

    public static int OddNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(OddNumber(new int[]{2,2,1,4,4,1,1}));
    }
}
