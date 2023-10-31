package 字符串;

/**
 * leetcode 58
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 */

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end>= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >=0 && s.charAt(start) != ' ') {
            start--;
        }
        System.out.println(end-start);
        return end-start;

    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "Hello World";
        lengthOfLastWord.lengthOfLastWord(s);

    }
}
