package cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author YangKai
 */
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 957 👎 0


public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
        System.out.println(solution.levelOrder(new TreeNode(1,
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
         * 广度遍历
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                // 此处必须先保存当前队列的长度，因为后续插入会影响
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(temp);
            }
            return ans;
        }

        /**
         * 依次入栈
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder1(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            if (root != null) {
                map.put(0, new ArrayList<Integer>() {{
                    add(root.val);
                }});
                doOrder(root.left, root.right, 1, map);
            }
            return new ArrayList<>(map.values());
        }

        private void doOrder(TreeNode left, TreeNode right, int index, Map<Integer, List<Integer>> map) {
            if (left == null && right == null) {
                return;
            }
            List<Integer> orDefault = map.getOrDefault(index, new ArrayList<>());
            if (left != null) {
                orDefault.add(left.val);
                doOrder(left.left, left.right, index + 1, map);
            }
            if (right != null) {
                orDefault.add(right.val);
                doOrder(right.left, right.right, index + 1, map);
            }
            map.put(index, orDefault);
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