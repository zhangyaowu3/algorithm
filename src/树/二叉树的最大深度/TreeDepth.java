package 树.二叉树的最大深度;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 104 二叉树的最大深度
 */
public class TreeDepth {

    public static void main(String[] args) {

//        [3,9,20,null,null,15,7]

        TreeDepth treeDepth = new TreeDepth();
        TreeNode n1 = new TreeNode(3);
        TreeNode n21 = new TreeNode(9);
        TreeNode n22 = new TreeNode(20);
        TreeNode n33 = new TreeNode(15);
        TreeNode n34 = new TreeNode(7);
        n1.left = n21;
        n1.right = n22;
        n22.left = n33;
        n22.right = n34;

        int depth = treeDepth.maxDepth(n1);
        System.out.println(depth);
    }

 /*   public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        // 每次都把下一层的节点放入queue
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }*/

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + (left > right ? left : right);
        }
    }
}
