package ca.bytetube._00_leetcode;

import ca.bytetube._00_leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author dal
 */
public class lc_linkedList_04_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //如果链表中只有2个节点
        if (head.next.next == null) return head.val == head.next.val;
        //1.找到中间节点
        ListNode mid = middleNode(head);
        //2.翻转右半部分（中间节点的右半部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        //3.分别让lHead向右移动，rHead向左移动，判断是否为回文结构
        boolean res = true;
        while (rHead != null){
            if (lHead.val != rHead.val) {
                res = false;
                break;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }
        //4.恢复右半部分
        reverseList(rOldHead);
        return res;
    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}
