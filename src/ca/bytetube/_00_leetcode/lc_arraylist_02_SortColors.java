package ca.bytetube._00_leetcode;

import ca.bytetube._00_leetcode.common.ListNode;
import ca.bytetube._03_list.List;

/**
 * https://leetcode.com/problems/sort-colors/
 * @author dal
 */
public class lc_arraylist_02_SortColors {
    /*
    总思路：partition
    步骤：
    1。如果cur的值是0
    cur++
    left++
    2。如果cur的值是1
    cur++
    3。如果cur的值是2
    cur不动
    right--
     */
    public void sortColors(int[] nums) {
        int cur = 0;
        int left = 0;
        int right = nums.length - 1;
        while (cur <= right){
            if (nums[cur] == 0) {
                swap(nums,cur++,left++);

            }else if (nums[cur] == 1) {
                cur++;
            }else {
                swap(nums,cur,right--);

            }
        }
    }

    public static int[] partitionArray(int[] arr,int pivot){
        int l = 0;
        int r = arr.length - 1;
        int curr = 0;

        while (curr <= r) {
            if (arr[curr] > pivot) {
                swap(arr, curr, r);
                r--;
            }else if (arr[curr] < pivot) {
                swap(arr, curr, l);
                curr++;
                l++;
            }else {
                curr++;
            }
        }
        return arr;

    }

    public static ListNode partitionList(ListNode head, int pivot){
        //利用单链表的重连特性
        if (head == null) return head;
        ListNode lH = null;
        ListNode lT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;

        //用来保存下一个待分配的节点
        ListNode next = null;

        while (head != null){
            next = head.next;

            head.next = null;
            if (head.val < pivot) {
                if (lH == null) {
                    lH = head;
                    lT = head;
                }else {
                    lT.next = head;
                    lT = head;
                }
            } else  if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                }else {
                    mT.next = head;
                    mT = head;
                }
            }

            head = next;
        }

        //less ---> equal ---> more
        //less ---> equal
        if (lT != null) {
            lT.next = eH;
            eT = eT == null  ? lT: eT;
        }

        //equal ---> more
        if (eT != null) {
            eT.next = mH;

        }

        return lH != null? lH:eH != null ? eH: mH;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }



    public static void main(String[] args) {
        int[] arr = {10,2,99,7,5,4,6,2,8,10,11,1,-10,87};
        int[] array = partitionArray(arr, 10);
        print(array);
    }


}
