package cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author YangKai
 */
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
//   前序遍历：根 左子树 右子树
//   中序遍历：左子树 根 右子树
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1146 👎 0


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] a = {1, 2, 3};
        int[] b = new int[1];
        System.arraycopy(a, 2, b, 0, 1);
        // TO TEST
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
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
         * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
         * 前序遍历：根 左子树 右子树
         * 中序遍历：左子树 根 右子树
         * 思路：
         * 1、通过前序遍历数组头部元素确认二叉树的根preorder[0]
         * 2、通过中序遍历数组确认根的位置index = map.get(preorder[0])，则确认左子树长度leftSize
         * 3、确认左子树范围
         *        a、前序遍历数组：[preorder_left = preorder_left + 1, preorder_right = preorder_left + leftSize]
         *        b、中序遍历数组：[inorder_left = inorder_left, inorder_right = index - 1]
         * 4、确认右子树范围
         *        a、前序遍历数组 [preorder_left = left + leftSize, preorder_right = preorder_right]
         *        b、中序遍历数组 [inorder_left = index + 1, inorder_right = inorder_right]
         * 5、递归处理
         *
         * @param preorder
         * @param inorder
         * @return
         */
        Map<Integer, Integer> rootMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            rootMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                rootMap.put(inorder[i], i);
            }
            // 第一次就是数组本身
            return backtrack(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        /**
         * @param preorder       前序遍历数组
         * @param inorder        中序遍历数组
         * @param preorder_left  当前子序列在前序遍历中左下标
         * @param preorder_right 当前子序列在前序遍历中右下标
         * @param inorder_left   当前子序列在中序遍历中左下标
         * @param inorder_right  当前子序列在中序遍历中右下标
         */
        private TreeNode backtrack(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }
            // 获取根节点在中序遍历中所在下标
            Integer rootIndex = rootMap.get(preorder[preorder_left]);
            TreeNode root = new TreeNode();
            // 1、通过前序遍历数组头部元素确认二叉树的根preorder[0]
            root.val = preorder[preorder_left];
            // 2、通过中序遍历数组确认根的位置 map.get(preorder[0])，则确认左子树长度leftSize
            int leftSize = rootIndex - inorder_left;
            root.left = backtrack(preorder, inorder, preorder_left + 1, preorder_left + leftSize, inorder_left, rootIndex - 1);
            root.right = backtrack(preorder, inorder, preorder_left + leftSize + 1, preorder_right, rootIndex + 1, inorder_right);
            return root;
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