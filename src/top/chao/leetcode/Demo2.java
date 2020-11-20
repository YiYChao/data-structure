package top.chao.leetcode;

/**
 *  <p>给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807<br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers</p>
 *  @author YiYChao
 *  @Date: 2020/11/19 18:59
 *  @version V1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        addTwoNumbers(l1, l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, curr = null, nxt1 = l1, nxt2 = l2;
        boolean flag1 = true, flag2 = true;
        int upper = 0;                          // 进位标志
        while (true){
            if (!flag1 && !flag2 && upper == 0 ) break;        // 判断是否遍历完成
            int v1 = 0, v2 = 0;
            if (flag1){
                v1 =nxt1.val;
                if (nxt1.next == null){
                    flag1 = false;
                }else {
                    nxt1 = nxt1.next;           // 向后进行遍历
                }
            }
            if (flag2){
                v2 =nxt2.val;
                if (nxt2.next == null){
                    flag2 = false;
                }else {
                    nxt2 = nxt2.next;           // 向后进行遍历
                }
            }
            int v3 = v1 + v2 + upper;           // 使用进位
            if (v3 > 9){
                v3 = v3 % 10;
                upper = 1;
            }else {
                upper = 0;                      // 清除进位
            }
            ListNode temp = new ListNode(v3);
            if (res == null){
                res = temp;
                curr = res;
            }else {
                curr.next = temp;
                curr = temp;
            }
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// https://blog.csdn.net/qq_42124842/article/details/91368624