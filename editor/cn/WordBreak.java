package cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author YangKai
 */
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 
// 👍 1106 👎 0


public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // TO TEST
        solution.wordBreak("leetcode", new ArrayList<String>() {{ add("leet"); add("code");}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * f[i] = f[j] && check(s[j,i-1])
         *
         * @param s
         * @param wordDict
         * @return
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> words = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] ans = new boolean[n + 1];
            ans[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (ans[j] && words.contains(s.substring(j, i))) {
                        ans[i] = true;
                        break;
                    }
                }
            }
            return ans[n];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}