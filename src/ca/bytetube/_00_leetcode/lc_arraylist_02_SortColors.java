package ca.bytetube._00_leetcode;

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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
