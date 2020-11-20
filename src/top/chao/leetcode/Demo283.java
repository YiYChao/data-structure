package top.chao.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]<br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes<p/>
 *
 * @author YiYChao
 * @version V1.0
 * @Date: 2020/11/19 18:29
 */
public class Demo283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int count = 0;          // 记录非0元素个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
                nums[count - 1] = nums[i];
            }
        }
        // 后续元素填充0
        for (int i = nums.length - 1; i >= count; i--) {
            nums[i] = 0;
        }
    }
}
