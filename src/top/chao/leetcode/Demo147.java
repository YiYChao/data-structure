package top.chao.leetcode;

import java.awt.event.AdjustmentEvent;

/**
 * <p>对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。<br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list</p>
 *
 * @author YiYChao
 * @version V1.0
 * @Date: 2020/11/20 11:08
 */
public class Demo147 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        insertionSortList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode pre;
        res.next = head;
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {    //如果是小于，那么符合题意，直接continue了
                head = head.next;       // 4 2 1 3
                continue;
            }

            pre = res;
            while (pre.next.val < head.next.val)//从头开始直到找到大于他的
                pre = pre.next;                 // 2 1 3
            ListNode cur = head.next;           //拿到当前的值
            head.next = cur.next;//除去当前的值
            cur.next = pre.next;//连接起来
            pre.next = cur;//在合适的位置赋值
        }
        return res.next;
    }

    // 进行插入排序
    public static void insertSort(ListNode tar, ListNode head) {
        if (head.next == null) return;
        ListNode last = head;
        ListNode curr = head.next;
        int temp;
        while (curr != null) {
            if (tar.val < head.val) {            // 比头节点还小，直接插入
                tar.next = head.next;
                head.next = tar;
                temp = head.val;
                head.val = tar.val;
                tar.val = temp;
                break;
            } else if (last.val <= tar.val && tar.val < curr.val) {      // 介于之间，直接插入
                last.next = tar;
                tar.next = curr;
                break;
            } else {     // 往后搜索
                last = curr;
                curr = curr.next;
            }
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

