package ca.bytetube._06_sort;

public class Partition {

    public static void partition(int[] array,int pivot){
        if (array == null || array.length < 2) return;
        partition(array,0,array.length - 1,pivot);

    }

    private static void partition(int[] array, int l, int r,int pivot) {
        int less = -1;
        int more = r + 1;
        while (l < more){
            if (array[l] < pivot) {
                swap(array,++less,l++);
            }else if (array[l] > pivot) {
                swap(array,--more,l);
            }else {
                l++;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
