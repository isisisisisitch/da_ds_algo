package ca.bytetube._00_leetcode;

import ca.bytetube._00_leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author dal
 */
public class lc_linkedList_02_ReverseLinkedList {

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
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
