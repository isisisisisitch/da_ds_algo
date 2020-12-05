package ca.bytetube._00_leetcode.list;

import ca.bytetube._00_leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * @author dal
 */
public class lc_linkedList_03_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;


        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!= null && fast.next != null) {//如果没有环时，能够正常退出
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {//address
                return true;
            }
        }
        return false;

    }



}
