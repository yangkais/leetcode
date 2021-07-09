package cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YangKai
 * @date Date
 */
 
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5477 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 存放不重复的字符串片段
        Set<Character> sub = new HashSet<>();
        // 右移动指针，不重复字符串长度
        int n = s.length();
        int rk = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 进入下一次循环，移除上一位字符(然后依次移除最左边字符直到没有重复，其实此处应该是直接移除重复字符与之前的所有字符)
                // 可以通过记录重复字符出现的下标，直接将左指针指向它的后一位，不用一位一位去右移
                // HashMap<Character, Integer>  字符，对应下标【但是此处会更耗存储空间, 存储了整个字符串加下标】
                // 如果出现重复数据，长度计算result = 右指针(i) - 左指针(map.value,如果有多个取最后一个)
                sub.remove(s.charAt(i - 1));
            }
            // 固定左指针i，不断移动右指针rk，判断是子串是否包含重复数据
            while (rk < n &&  !sub.contains(s.charAt(rk))) {
                // 不重复则将添加当前字符
                sub.add(s.charAt(rk));
                // 不断移动右指针rk
                rk++;
            }
            result = Math.max(result, rk - i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    // abcd abcdabcd
}