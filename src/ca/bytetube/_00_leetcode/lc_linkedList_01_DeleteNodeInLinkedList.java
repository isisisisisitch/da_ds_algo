package ca.bytetube._00_leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @author dal
 */
public class lc_linkedList_01_DeleteNodeInLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        //1。后面节点覆盖当前节点
        node.val = node.next.val;
        //2。当前的节点的next指向后面第二个节点
        node.next = node.next.next;
    }
}
