package top.chao.datastru.map;
/**
 *  @Description:
 *  @author: YiYChao
 *  @Date: 2020/1/19 10:48
 *  @Version: V1.0
 *  5315. 6 和 9 组成的最大数字 显示英文描述
 * 用户通过次数0
 * 用户尝试次数0
 * 通过次数0
 * 提交次数0
 * 题目难度Easy
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 */
import java.util.Arrays;

class Solution {
    private int maximum69Number (int num) {
        String str = Integer.toString(num);     // 数字转字符串处理
        int[] arr = new int[str.length() + 1];
        arr[str.length()] = num;    // 默认值
        for (int i = 0; i < str.length(); i++){     // 默认可能的变更值
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {    // 遍历数字的每一位
                if (j == i){    // 翻转数字
                    sb.append(str.charAt(j) == '9' ? '6' : '9');
                }else{
                    sb.append(str.charAt(j));
                }
            }
            arr[i] = Integer.parseInt(sb.toString());
        }
        Arrays.sort(arr);   // 从小到大进行排序
        return arr[arr.length - 1];     // 返回最大值
    }

    public static void main(String[] args) {
        int rst = new Solution().maximum69Number(9996);
        System.out.println(rst);
        int rst2 = new Solution().maximum69Number(9669);
        System.out.println(rst2);

//        Double pow = Math.pow(Double.parseDouble("10"), Double.parseDouble(Integer.toString(2)));
//        int t = pow.intValue();
//        System.out.println(pow + "\t\t" + t);
    }
}