package 二叉树和图.路径总和2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 *
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * leetcode 113  路径总和2  深度优先搜索
 */
public class PathSum {

    public TreeNode initTreeNode() {
        TreeNode n11 = new TreeNode(5);
        TreeNode n21 = new TreeNode(4);
        TreeNode n31 = new TreeNode(11);
        TreeNode n41 = new TreeNode(7);
        TreeNode n42 = new TreeNode(2);
        TreeNode n22 = new TreeNode(8);
        TreeNode n33 = new TreeNode(13);
        TreeNode n34 = new TreeNode(4);
        TreeNode nnLeft = new TreeNode(5);
        TreeNode nnRight = new TreeNode(1);
        n11.left = n21;
        n11.right = n22;
        n21.left = n31;
        n31.left = n41;
        n31.right = n42;
        n22.left = n33;
        n22.right = n34;
        n34.left = nnLeft;
        n34.right = nnRight;
        return n11;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        PathSum pathSum = new PathSum();

        pathSum.dfs(pathSum.initTreeNode(), 22, new ArrayList<>(), result);
        System.out.println(String.valueOf(result));
    }

    public void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        List<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);
        // 因为是找出所有从根节点到叶子节点的路径总和，必须要到叶子节点
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(subList);
            }
            return;
        }
        dfs(root.left, sum - root.val, subList, result);
        dfs(root.right, sum - root.val, subList, result);
    }

}
