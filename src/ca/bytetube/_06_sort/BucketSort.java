package ca.bytetube._06_sort;

import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static double[] bucketSort(double[] array){
        //① 创建一定数量的桶（比如用数组、链表作为桶）
        List<Double>[] buckets = new List[array.length];//链表(桶)数组
        //② 按照一定的规则（不同类型的数据，规则不同），将序列中的元素均匀分配到对应的桶
        //元素值* 元素数量
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (int)(array[i] * array.length);//桶编号
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);//将元素入桶
        }
        //③分别对每个桶进行单独排序
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);//升序
            //④ 将所有非空桶的元素合并成有序序列
//            for (int i1 = 0; i1 < buckets[i].size(); i1++) {
//                array[index] = buckets[i].get(i1);
//                index++;
//            }
            for (Double d : buckets[i]) {
                array[index] = d;
                index++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        double[] arr = {0.34,0.47,0.29,0.84,0.45,0.38,0.35,0.76};
        bucketSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
