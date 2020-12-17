package ca.bytetube._06_sort;

public class QuickSort {

    public static void quickSort(int[] array){
        if (array == null || array.length < 2) return;
        quickSort(array,0,array.length - 1);
    }
    //random QuickSort
    private static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            swap(array,l + (int) Math.random() * (r - l + 1),r);
            int[] partition = partition(array, l, r);
            quickSort(array,l,partition[0] -1);
            quickSort(array,partition[1] + 1,r);
        }
    }

    /**
     *
     * @param array
     * @param l
     * @param r
     * @return 是相等区域的左右边界 （2个值）
     */
    private static int[] partition(int[] array, int l, int r) {
        int less = l-1;
        int more = r;
        while (l < more){
            if (array[l] < array[r]) {
                swap(array,++less,l++);
            }else if (array[l] > array[r]) {
                swap(array,--more,l);
            }else {
                l++;
            }
        }
        //让大于区域的第一个元素和本次划分的基准交换
        //之所以这样做的目的：让等于区域连在一起
        swap(array,more,r);
        return new int[]{less+1,more};
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
