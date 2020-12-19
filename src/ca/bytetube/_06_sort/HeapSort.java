package ca.bytetube._06_sort;

/**
 * 无序数组——>有序数组
 * 1.把无序数组重建位一个maxHeap
 * 2.交换堆顶元素和数组的最后一个元素，把当前这个堆顶元素剔除
 * 3.再大根堆化（恢复大根堆），重复2的操作
 */
public class HeapSort {
    public static void heapSort(int[] array){
        if (array == null || array.length < 2) return;
        //1.把无序数组重建位一个maxHeap
        for (int i = 0; i < array.length; i++) {
            heapInsert(array,i);
        }
        //2.交换堆顶元素和数组的最后一个元素，把当前这个堆顶元素剔除
        int size = array.length;
        swap(array,0,--size);

        //3.再大根堆化（恢复大根堆），重复2的操作
        while (size > 0){
            heapify(array,0,size);
            swap(array,0,--size);
        }
    }

    private static void heapify(int[] array, int index, int size) {//sift down
        int left = index * 2 + 1;
        while (left < size){
            //a.找到层内找最大值的下标
            int largest = left + 1 < size && array[left + 1] > array[left] ? left + 1:left;
            //更新
            largest = array[largest] > array[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(array,largest,index);
            index = largest;
            left = index * 2 + 1;
        }

    }


    private static void heapInsert(int[] array, int index) {//sift up
        while (array[index] > array[(index - 1)/2]){
            swap(array,index,(index - 1)/2);
            index = (index - 1)/2;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,8,99,-3,11};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
