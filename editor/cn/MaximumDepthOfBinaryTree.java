package cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author YangKai
 */
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 937 👎 0


public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // TO TEST  3,9,20,null,null,15,7
        System.out.println(solution.maxDepth(new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            // 方法一：深度优先
            return byDeep(root, 1);

            // 方法二：广度优先
//            return byRange(root);
        }

        /**
         * 广度优先搜索
         *
         * @param root
         */
        int byRange(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            int index = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                index++;
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) {
                        max = Math.max(max, index);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return max;
        }

        /**
         * 深度优先搜索
         *
         * @param node
         * @param index
         */
        int byDeep(TreeNode node, int index) {
            if (node == null) {
                return 0;
            }

            if (node.left == null && node.right == null) {
                return index;
            }
            return Math.max(byDeep(node.left, index + 1), byDeep(node.right, index + 1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}