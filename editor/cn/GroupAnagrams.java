package cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author YangKai
 */
//给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 793 👎 0


public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计数法：记录每组中相对小写字符【a-z】出现的次数，存放进HashMap中，k=次数，v=字符串
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                // 记录子串中各字符出现次数
                int[] counter = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    // 对应位字符出现次数+1
                    counter[str.charAt(i) - 'a']++;
                }
                // 将每个出现次数成字符串大于 0 的字母和出现次数按顺序拼接，作为哈希表的键
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++) {
                    if (counter[i] != 0) {
                        sb.append('a' + i);
                        sb.append(counter[i]);
                    }
                }
                // 大于 0 的字母和出现次数按顺序拼接组合
                return sb.toString();
            })).values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}