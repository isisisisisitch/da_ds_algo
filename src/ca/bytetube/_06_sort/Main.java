package ca.bytetube._06_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
