package com.justnow.bsearch_12;


public class BSearch {

    /**
     * 一、查找重复元素首次出现的位置
     * a为存在重复元素的有序数组
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int findFirstValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            // 用右移动一位表示除号
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 当a[mid]的值等于value时，如果mid为0，说明a[mid]为数组的第一个元素，可以返回；
                // 如果mid不为零，同时mid前一个元素不等于value，说明mid是重复元素第一次出现的索引
                if (mid == 0 || (a[mid - 1] != value))
                    return mid;
                // 如果两种情况都不符合，说明，我们要查找的元素在[low, mid-1]之间
                else

                    high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二、查找重复元素首次出现的位置
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int findLastValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 当a[mid]的值等于value时，如果mid为0，说明a[mid]为数组的第一个元素，可以返回；
                // 如果mid不为零，同时mid前一个元素不等于value，说明mid是重复元素第一次出现的索引
                if (mid == n - 1 || (a[mid + 1] != value))
                    return mid;
                    // 如果两种情况都不符合，说明，我们要查找的元素在[low, mid-1]之间
                else

                    low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 三、查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int findFirstGEValue(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                // 如果a[mid]前面已经没有元素，或者前面一个元素小于要查找的值value
                // 那么a[mid]就是我们要找的元素
                if ((mid == 0) || (a[mid - 1] < value))
                    return mid;
                // 如果a[mid - 1] 大于等于要查找的value，说明要查找的元素在[low, mid - 1]之间
                else
                    high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 四、查找最后一个小于等于给定值的元素
     * 搞定这些问题的方法，只能是通过画图来解决
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int findLastLEValue(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid+1] > value)) {
                    return value;
                } else {
                    //如果mid+1的元素小于等于value，那么说明，要找的元素在[mid+1, high]之间
                    low = mid + 1;
                }
            }
        }
        return -1;
    }




}
