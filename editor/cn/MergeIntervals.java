package cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author YangKai
 */
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1025 👎 0


public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(solution.merge(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * [[1,3],[2,6],[8,10],[15,18]]
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            // 按第一位从小到大排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> ans = new ArrayList<>();
            int index = 0;
            for (int[] interval : intervals) {
                if (ans.isEmpty()) {
                    ans.add(interval);
                }
                if (interval[0] > ans.get(index)[1]) {
                    // 第一位比较
                    index++;
                    ans.add(interval);
                } else {
                    // 第二位比较
                    if (interval[1] > ans.get(index)[1]) {
                        ans.get(index)[1] = interval[1];
                    }
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}