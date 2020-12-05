package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * @author dal
 */
public class lc_arraylist_01_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;
        while (i2 >= 0){
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[cur--] = nums1[i1--];
            }else {//i1 < 0 || nums2[i2] >= nums1[i1]
                nums1[cur--] = nums2[i2--];
            }
        }

    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n){
        int l1 = 0;
        int l2 = 0;
        int curr = 0;
        int[] nums3 = new int[m + n];
        while (l1 <= m - 1 && l2 <= n - 1) {
            if (nums1[l1] < nums2[l2]) {
                nums3[curr++] = nums1[l1++];
            }else {
                nums3[curr++] = nums2[l2++];
            }
        }

        if (l1 > m - 1) {
            while (l2 <= n - 1) {
                nums3[curr++] = nums2[l2++];
            }
        }else if (l2 > n - 1) {
            while (l1 <= m - 1) {
                nums3[curr++] = nums1[l1++];
            }
        }
        return nums3;
//        int[] nums3 = new int[nums1.length];
//
//        int i3 = 0;
//        int i1 = 0;
//        int i2 = 0;
//        while (i1 < m  && i2 < n){
//            if (nums1[i1] <= nums2[i2]){
//                nums3[i3] = nums1[i1];
//                i1++;
//            }
//            else {
//                nums3[i3] = nums2[i2];
//                i2++;
//            }
//            i3++;
//        }
//        while (i1 < m){
//            nums3[i3] = nums1[i1];
//            i1++;
//            i3++;
//        }
//        while (i2 < n){
//            nums3[i3] = nums2[i2];
//            i2++;
//            i3++;
//        }
//        return nums3;


    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,7,0,0,0};
        int[] nums2  = {2,3,6};

        int[] merges = merge2(nums1, 3, nums2, 3);
        System.out.println("");

    }
}
