package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangKai
 * @date Date
 */

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1181 👎 0

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            // 每行数据用StringBuffer存储, 最后返回结果是从左到右从上到下读取，刚好拼接每行StringBuffer返回
            List<StringBuffer> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                // 构造存储数据行
                rows.add(new StringBuffer());
            }
            // 向下或向上标识，初始设置为false，因为下标从0开始，为边界条件
            boolean isDown = false;
            // 行号
            int rowNum = 0;
            for (char c : s.toCharArray()) {
                // 将数据存入当前行号下的StringBuffer中
                rows.get(rowNum).append(c);
                if (rowNum == 0 || rowNum == numRows - 1) {
                    // 边界处，方向改变
                    isDown = !isDown;
                }
                // 行号按方向加减1
                rowNum += isDown ? 1 : -1;
            }
            StringBuffer sb = new StringBuffer();
            for (StringBuffer row : rows) {
                sb.append(row);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}