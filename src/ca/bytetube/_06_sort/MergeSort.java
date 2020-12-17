package ca.bytetube._06_sort;

import java.util.Arrays;

public class MergeSort {

    //tail recursion
    public static void mergeSort(int[] array){
        if (array == null || array.length < 2) return;
        mergeSort(array,0,array.length - 1);
    }
    private static void mergeSort(int[] array, int l, int r) {
        if ( l == r) return;
        int mid = l + ((r - l) >> 1);//(l + r)/2;//r - (r-l) /2;//
        mergeSort(array,l,mid);//左侧有序
        mergeSort(array,mid+1,r);//右侧有序
        merge(array,l,mid,r);//左右两侧合并，整体有序
    }
    private static void merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r){
            help[i++] = array[p1] < array[p2]? array[p1++]:array[p2++];
        }
        while (p1 <= mid){//p2先走到结尾
            help[i++] = array[p1++];
        }
        while (p2 <= r){//p1先走到结尾
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            array[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }


    }


}
