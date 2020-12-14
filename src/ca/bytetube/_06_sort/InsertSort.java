package ca.bytetube._06_sort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] array){
        if (array == null || array.length < 2) return;
        for (int i = 1; i < array.length; i++) {
            for (int j = i- 1; j >= 0 && array[j] > array[j+1]; j--) {
                swap(array,j,j+1);
            }
        }

    }

    public static void insertSort1(int[] array) {
        int i,j,temp;
        for(i = 1; i < array.length; i++){
            temp = array[i];//-3
            j = i -1;//2
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
