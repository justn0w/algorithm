package com.justnow.bucketsort;

import com.justnow.insertsort.InsertSort;

/**
 * https://baike.baidu.com/item/%E6%A1%B6%E6%8E%92%E5%BA%8F/4973777?fr=kg_qa
 * 桶排序时间复杂度的分析
 */

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] array = {7, 12, 56, 23, 19, 33, 35, 42, 42, 2, 8, 22, 39, 26, 17};
        System.out.println(Arrays.toString(bucketSort.sort(array)));
    }

    private InsertSort insertSort = new InsertSort();
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return bucketSort(arr, 5);
    }
    public int[] bucketSort(int[] arr, int bucketSize){
        if(arr.length == 0){
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];

        for(int value : arr){
            if(value < minValue){
                minValue = value;
            }else if(value > maxValue){
                maxValue = value;
            }
        }

        //桶的个数
        int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        //利用映射函数将数据分配到各个桶中
        for(int i = 0; i < arr.length; i++){
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        //使用插入排序，对每个桶中数据进行排序
        int arrIndex = 0;
        for(int[] bucket : buckets){
            if(bucket.length <= 0){
                continue;
            }
            insertSort.sort(bucket);
            for (int i : bucket) {
                arr[arrIndex++] = i;
            }
        }
        return arr;
    }

    /**
     * 自动扩容，并保存数据，每次将新元素放到桶的最后面
     * @param arr
     * @param value
     * @return
     */
    public int[] arrAppend(int[] arr, int value){
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
