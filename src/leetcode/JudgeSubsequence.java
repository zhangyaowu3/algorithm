package leetcode;

/**
 * 392，判断子序列    双指针法
 */
public class JudgeSubsequence {

    public static void main(String[] args) {
        System.out.println(JudgeSubsequence("abc", "ahbgdc"));
        // System.out.println(JudgeSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean JudgeSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                //指向s的指针只有在两个字符串相同时才会往右移
                indexS ++;
                if (indexS == s.length()) {
                    return true;
                }
            }
            //指向t的指针每次都会往右移一位
            indexT ++;
        }
        return false;
    }


}
