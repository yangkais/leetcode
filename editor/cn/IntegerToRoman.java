package cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 整数转罗马数字
 *
 * @author YangKai
 */
//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 👍 879 👎 0


public class IntegerToRoman {

//    private static final Map<Integer, String> ROMANS = new HashMap<>(8);
//
//    static {
////        ROMANS.put("I", 1);
////        ROMANS.put("V", 5);
////        ROMANS.put("X", 10);
////        ROMANS.put("L", 50);
////        ROMANS.put("C", 100);
////        ROMANS.put("D", 500);
////        ROMANS.put("M", 1000);
//        ROMANS.put(1, "I");
//        ROMANS.put(4, "IV");
//        ROMANS.put(5, "V");
//        ROMANS.put(9, "IX");
//        ROMANS.put(10, "X");
//        ROMANS.put(40, "XL");
//        ROMANS.put(50, "L");
//        ROMANS.put(90, "XC");
//        ROMANS.put(100, "C");
//        ROMANS.put(400, "CD");
//        ROMANS.put(500, "D");
//        ROMANS.put(900, "CM");
//        ROMANS.put(1000, "M");
//    }

    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        // TO TEST
        System.out.println(solution.intToRoman(58));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, String> romans = new TreeMap<Integer, String>(Comparator.comparingInt(Integer::intValue).reversed()) {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> map : romans.entrySet()) {
                if (num < map.getKey()) {
                    continue;
                }
                int a = num / map.getKey();
                if (a > 0) {
                    String s = map.getValue();
                    for (int i = 0; i < a; i++) {
                        sb.append(s);
                    }
                }
                num %= map.getKey();
                if (num == 0) {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}