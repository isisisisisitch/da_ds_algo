package ca.bytetube._00_leetcode._04_sort;
//[1,3,4,2,5]
/*
    less than 1 on left side:none
    less than 3 on left side:1
    less than 4 on left side:1,3
    less than 2 on left side:1
    less than 5 on left side:1,3,4,2
    sum = 1+1+3+1+1+3+4+2 = 16
    sum = 4*1+2*3+1*4+1*2 = 16

 */
public class GetSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(getSum(arr));
    }
    public static int getSum(int[] arr){
        if (arr == null || arr.length < 2 ) return 0;
         return process(arr,0,arr.length-1);
    }

    private static int process(int[] array, int l, int r) {
        if ( l == r) return 0;
        int mid = l + ((r - l) >> 1);//(l + r)/2;//r - (r-l) /2;//
        return process(array,l,mid) + process(array,mid+1,r) + merge(array,l,mid,r);

    }
    private static int merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += array[p1] < array[p2] ? (r - p2 + 1 )*array[p1] : 0;
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
        return res;
    }

}
