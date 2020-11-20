package top.chao.leetcode;

/**
 *  <p>对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 插入排序算法：
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。<br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list</p>
 *  @author YiYChao
 *  @Date: 2020/11/20 11:08
 *  @version V1.0
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
        if (head.next == null) return head;
        ListNode last = head;
        ListNode curr = head.next;
        while (curr != null){
            if (last.val > curr.val){
                // 插入排序
                int temp = curr.val;
                if (curr.next != null){
                    last.next = curr.next;
                    curr = curr.next;
                }else {
                    curr = null;
                    last.next = null;
                }
                head = insertSort(temp, head);
            }else {     // 向后推移
                last = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    // 进行插入排序
    public static ListNode insertSort(int val, ListNode head){
        if (head.next == null) return head;
        ListNode last = head;
        ListNode curr = head.next;
        ListNode temp;
        while (curr != null){
            if (val < head.val){            // 比头节点还小，直接插入
                temp = head;
                head = new  ListNode(val);
                head.next = temp;
                break;
            } else if (last.val <= val && val < curr.val){      // 介于之间，直接插入
                temp = curr;
                curr = new ListNode(val);
                curr.next = temp;
                last.next = curr;
                break;
            }else {     // 往后搜索
                last = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

