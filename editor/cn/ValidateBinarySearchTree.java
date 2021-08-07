package cn;

/**
 * 验证二叉搜索树
 *
 * @author YangKai
 */
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1153 👎 0


public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        // TO TEST
        System.out.println(solution.isValidBST(new TreeNode(5,
                new TreeNode(1, null, null), new TreeNode(4,
                new TreeNode(3, null, null), new TreeNode(6, null, null)))));
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
         * 方法一
         * 递归判断：左子树必须小于根节点  右子树必须大于根节点
         * 方法二
         * 中序遍历
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        // 中序遍历
        long pre = Long.MIN_VALUE;
        public boolean isValidBST1(TreeNode root) {

            if (root == null) {
                return true;
            }
            // 左子树
            if (!isValidBST1(root.left)) {
                return false;
            }
            // 根比较
            if (pre >= root.val) {
                return false;
            }
            pre = root.val;
            // 右子树
            return isValidBST1(root.right);
        }

        private boolean inorder(TreeNode root, long lowest, long upper) {
            if (root == null) {
                return true;
            }
            if (root.val <= lowest || root.val >= upper) {
                return false;
            }
            // 左子树必须小于根节点  右子树必须大于根节点
            return inorder(root.left, lowest, root.val) && inorder(root.right, root.val, upper);
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