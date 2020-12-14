package ca.bytetube._06_sort;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        for (int cur = 0; cur < arr.length; cur++) {
            int minIndex = cur;
            for (int j = cur + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            int temp = arr[cur];
            arr[cur] = arr[minIndex];
            arr[minIndex] = temp;
        }


    }

    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
