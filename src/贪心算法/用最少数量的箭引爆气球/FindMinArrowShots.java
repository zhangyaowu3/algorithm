package 贪心算法.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 452
 *
 * 题目:
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 *
 * 思路:
 * 这代表了我们可以跟踪气球的结束坐标，若下个气球开始坐标在当前气球的结束坐标前，则我们可以用一支箭一起引爆；
 * 若下个气球的开始坐标在当前气球的结束坐标后，则我们必须增加箭的数量。并跟踪下个气球的结束坐标。
 *
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // sort by x_end
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // Arrays.sort(points,(a,b)->(a[1]-b[1]));

        int shootNum = 1;
        int shootEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= shootEnd) {
                continue;
            }
            shootNum++;
            shootEnd = points[i][1];
        }
        return shootNum;

    }
}
