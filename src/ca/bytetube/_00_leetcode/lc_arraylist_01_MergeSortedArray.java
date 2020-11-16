package ca.bytetube._00_leetcode;

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
}
