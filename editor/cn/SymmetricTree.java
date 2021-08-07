package cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author YangKai
 */
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1477 👎 0


public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        // TO TEST  1,2,2,3,4,4,3
        System.out.println(solution.isSymmetric(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3, null, null)),
                new TreeNode(2, null, new TreeNode(3, null, null)))));
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
        /**
         * 思路：对于相同层级：左子树的值等于右子树 && 右子树的值等于左子树
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            // 方法一：递归
            return backtrack(root.left, root.right);
            // 方法二：迭代， 借助
//            return check(root.left, root.right);
        }

        /**
         * 递归
         *
         * @param left
         * @param right
         * @return
         */
        boolean backtrack(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null) {
                return false;
            }
            if (right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return backtrack(left.left, right.right) && backtrack(left.right, right.left);
        }

        /**
         * 迭代
         *
         * @param left
         * @param right
         * @return
         */
        boolean check(TreeNode left, TreeNode right) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                // 依次出队列
                TreeNode l = queue.poll();
                TreeNode r = queue.poll();
                // 都为空则继续
                if (l == null && r == null) {
                    continue;
                }
                // 任意一个为空 或者值不相同
                if ((l == null || r == null) || l.val != r.val) {
                    return false;
                }
                // 依次入队
                queue.offer(l.left);
                queue.offer(r.right);

                queue.offer(l.right);
                queue.offer(r.left);
            }
            return true;
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