package 二叉树和图.二叉树的最大路径和;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * 定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * leetcode 124  二叉树中的最大路径和
 */
public class MaxPathSum {

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
    int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(maxPathSum.initTreeNode()));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax  = Math.max(0, dfs(root.left));         // 左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
        res = Math.max(res, root.val + leftMax + rightMax); // 更新res
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }
}
