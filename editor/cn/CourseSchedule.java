package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表
 *
 * @author YangKai
 */
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 906 👎 0


public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        // TO TEST
        //1连接方式
        String s1 = "a";
        String s2 = "a";
        String s3 = "a" + s2;
        String s4 = "a" + "a";
        String s5 = s1 + s2;
        //表达式只有常量时，编译期完成计算
        //表达式有变量时，运行期才计算，所以地址不一样
        System.out.println(s3 == s4); //f
        System.out.println(s3 == s5); //f
        System.out.println(s4 == "aa"); //t
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 将课程按每组中的顺序转为List
        List<List<Integer>> courses;
        // 课程访问状态：0-未搜索，1-搜索中，2-已完成
        int[] visited;
        // 检验返回值
        boolean valid = true;

        /**
         * 深度优先：
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            courses = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                // 空List
                courses.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            // 向每节课程中添加先后关系
            for (int[] prerequisite : prerequisites) {
                // 添加该下标对应课程的后置课程
                courses.get(prerequisite[1]).add(prerequisite[0]);
            }
            // 遍历判断每节课程是否满足先后关系
            for (int i = 0; i < numCourses && valid; i++) {
                if (visited[i] == 0) {
                    // 课程未搜索，进行遍历
                    dfs(i);
                }
            }
            return valid;
        }

        private void dfs(int i) {
            // 搜索中
            visited[i] = 1;
            // 遍历该课程的所有后置课程
            for (int v : courses.get(i)) {
                // 后置课程v 未搜索：递归执行
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        // 搜索完检验不通过，返回
                        return;
                    }
                } else if (visited[v] == 1) {
                    // 搜索中：代表后置课程正在搜索中，相互关联（环）
                    valid = false;
                    return;
                }
            }
            // 已完成
            visited[i] = 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}