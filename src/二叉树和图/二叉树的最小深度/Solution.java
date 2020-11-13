package 二叉树和图.二叉树的最小深度;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * [3,9,20,null,null,15,7]
 *
 * leetcode 111  可以用模板
 */
public class Solution {

    public TreeNode initTreeNode() {
        TreeNode n11 = new TreeNode(-10);
        TreeNode n21 = new TreeNode(9);
        TreeNode n22 = new TreeNode(20);
        TreeNode n33 = new TreeNode(15);
        TreeNode n34 = new TreeNode(7);
        n11.left = n21;
        n11.right = n22;
        n22.left = n33;
        n22.right = n34;
        return n11;
    }

    public static void main(String[] args) {
          Solution solution = new Solution();
          Integer miniNum = solution.miniDepth(solution.initTreeNode());
          System.out.println(miniNum);
    }

    public int miniDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = miniDepth(root.left);
        int right = miniDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) {
            return left + right +1;
        }
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(left,right) + 1;
    }
}
